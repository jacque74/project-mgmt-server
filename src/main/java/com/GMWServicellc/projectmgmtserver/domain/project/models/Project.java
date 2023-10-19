package com.GMWServicellc.projectmgmtserver.domain.project.models;


import jakarta.persistence.*;
import lombok.*;


@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructors
@RequiredArgsConstructor // parameterized constructor
@Data // Generates getters and setters
@Table(name = "projectS")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;



    private String title;
   @NonNull
    private String description;

    private String published;

    @NonNull
    private String email;


    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, title, description, published, email);
    }


}



