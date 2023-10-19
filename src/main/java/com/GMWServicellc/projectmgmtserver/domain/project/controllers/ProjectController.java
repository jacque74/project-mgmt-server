package com.GMWServicellc.projectmgmtserver.domain.project.controllers;

import com.GMWServicellc.projectmgmtserver.domain.project.models.Project;
import com.GMWServicellc.projectmgmtserver.domain.project.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController// Allows spring to look for URL UR
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAll(){
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project){
        project = projectService.create(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id){
        Project project = projectService.getById(id);
        return  new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Project> getByEmail(@RequestParam String email){
        Project project = projectService.getByEmail(email);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Project> update(@PathVariable("id") Long id, @RequestBody Project projectDetail){
        projectDetail = projectService.update(id, projectDetail);
        return new ResponseEntity<>(projectDetail, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
