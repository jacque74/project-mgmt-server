package com.GMWServicellc.projectmgmtserver.domain.project.services;

import com.GMWServicellc.projectmgmtserver.domain.core.exceptions.ResourceCreationException;
import com.GMWServicellc.projectmgmtserver.domain.core.exceptions.ResourceNotFoundException;
import com.GMWServicellc.projectmgmtserver.domain.project.models.Project;
import com.GMWServicellc.projectmgmtserver.domain.project.repos.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) throws ResourceCreationException {
        Optional<Project> optional = projectRepository.findByEmail(project.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Project with email exists:" + project.getEmail());
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) throws ResourceNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Project with id: " +id));
        return project;
    }

    @Override
    public Project getByEmail(String email) throws ResourceNotFoundException {
        Project project = projectRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Project with email" + email));
        return project;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project update(Long id, Project projectDetail) throws ResourceNotFoundException {
        Project project = getById(id);
        project.setTitle(projectDetail.getTitle());
        project.setDescription(projectDetail.getDescription());
        project.setPublished(projectDetail.getPublished());
        project.setEmail(projectDetail.getEmail());
        project = projectRepository.save(project);
        return project;
    }

    @Override
    public void delete(Long id) {
        Project project = getById(id);
        projectRepository.delete(project);

    }
}
