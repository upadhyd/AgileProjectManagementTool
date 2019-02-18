package com.dbu.ppmtool.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dbu.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

  @Override
  Iterable<Project> findAllById(Iterable<Long> ids);
  
}
