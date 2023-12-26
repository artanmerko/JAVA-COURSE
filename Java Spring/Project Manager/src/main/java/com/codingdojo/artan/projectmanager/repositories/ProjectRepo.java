package com.codingdojo.artan.projectmanager.repositories;

import com.codingdojo.artan.projectmanager.models.Project;
import com.codingdojo.artan.projectmanager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
    List<Project> findAll();
    Project findByIdIs(Long id);
    List<Project> findAllByUsers(User user);
    List<Project> findByUsersNotContains(User user);
}