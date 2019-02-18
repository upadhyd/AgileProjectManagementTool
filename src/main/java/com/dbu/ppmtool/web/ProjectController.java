package com.dbu.ppmtool.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbu.ppmtool.domain.Project;
import com.dbu.ppmtool.services.ProjectService;
import com.dbu.ppmtool.services.ValidationErrorMapService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
  
  @Autowired
  private ProjectService projectService;
  
  @Autowired
  private ValidationErrorMapService validationErrorMapService;
  
  /**
   * What is Binding Result?
   * https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc
   * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/validation/BindingResult.html
   * @param project
   * @param result
   * @return
   */
  @PostMapping("")
  public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
    ResponseEntity<?> errorMap = validationErrorMapService.validationErrorMap(result);
    if(errorMap != null) return errorMap;
    Project newProject = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
  }
  
  @GetMapping("/{projectIdentifier}")
  public ResponseEntity<?> getProjectbyIdentifier(@PathVariable String projectIdentifier) {
    Project project = projectService.findProjectByProjectIdentifier(projectIdentifier);
    return new ResponseEntity<Project>(project, HttpStatus.OK);
  }
  
  @GetMapping("/all")
  public Iterable<Project> findAllProjects() {
    return projectService.findAllProjects();
  }
  
  @DeleteMapping("/{projectIdentifier}")
  public ResponseEntity<?> deleteProject(@PathVariable String projectIdentifier) {
    projectService.deleteProjectByIdentifier(projectIdentifier);
    return new ResponseEntity<String>("Project with identifier '"+projectIdentifier+"' deleted.", HttpStatus.OK);
  }

}
