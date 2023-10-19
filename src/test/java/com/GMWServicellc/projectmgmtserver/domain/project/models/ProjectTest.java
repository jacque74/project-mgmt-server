package com.GMWServicellc.projectmgmtserver.domain.project.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectTest {
    @Test
    public void constructorTest01() {
        Project project = new Project("Demo", "Demo1", "Demo2", "demo@user.com");
        project.setId(1L);

        String expected = "1 Demo Demo1 Demo2 demo@user.com";
        String actual = project.toString();

        Assertions.assertEquals(expected, actual);

    }
}
