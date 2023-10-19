package com.GMWServicellc.projectmgmtserver.domain.project.services;

import com.GMWServicellc.projectmgmtserver.domain.core.exceptions.ResourceCreationException;
import com.GMWServicellc.projectmgmtserver.domain.core.exceptions.ResourceNotFoundException;
import com.GMWServicellc.projectmgmtserver.domain.project.models.Project;

import java.util.List;

public interface ProjectService {
    Project create(Project project) throws ResourceCreationException;
    Project getById(Long id) throws ResourceNotFoundException;
    Project getByEmail(String email) throws ResourceNotFoundException;
    List<Project> getAll();
    Project update(Long id, Project projectDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
