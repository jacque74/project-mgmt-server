package com.GMWServicellc.projectmgmtserver.domain.project.repos;

import com.GMWServicellc.projectmgmtserver.domain.project.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByEmail(String email);
}
