package com.dbu.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.dbu.ppmtool.domain.Project;
import com.dbu.ppmtool.repositories.ProjectRepository;

/**
 * Why create a service layer?
 * We have seen people auto-wiring repository straight into controllers.
 * Good for small simple service or game. 
 * But then you end up putting a lot of logic into the controller which compromises readeability and causes code smell.
 * You always to have your logic abstracted from controller as much as possible.
 * You want your controller to be just a router as much as possible.
 * @author Dhaivat
 *
 */

@Service
public class ProjectService {
  
  @Autowired
  private ProjectRepository projectRepository;
  
  public Project saveOrUpdateProject(Project project) {
    
    //Logic
    
    return projectRepository.save(project);
  }

}