package com.dbu.ppmtool.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbu.ppmtool.domain.Project;
import com.dbu.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
  
  @Autowired
  private ProjectService projectService;
  
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
    if (result.hasErrors()) {
      return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
    }
    Project newProject = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
  }

}
