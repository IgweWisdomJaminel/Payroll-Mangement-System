package com.jaminel.payrollmangementsystem.data.model;

import com.jaminel.payrollmangementsystem.data.model.enums.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @UuidGenerator
    private String id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @ElementCollection
    private Set<Role> role;

}
