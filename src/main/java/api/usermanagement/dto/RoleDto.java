package api.usermanagement.dto;

import api.usermanagement.entity.RoleEntity;

public class RoleDto {

    private Long id;
    private String name;
    private String description;

    public RoleDto(Long id, String nome, String description) {
        this.id = id;
        this.name = nome;
        this.description = description;
    }

    public RoleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}