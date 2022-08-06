package com.devsuperior.bds04.dto;


import com.devsuperior.bds04.entities.User;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private Long id;

    @Email(message = "Favor inserir email válido")
    private String email;

    private final Set<RoleDto> roles = new HashSet<>();

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDto(User entity) {
        id = entity.getId();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }
}
