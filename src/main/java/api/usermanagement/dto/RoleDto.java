package api.usermanagement.dto;

import api.usermanagement.entity.RoleEntity;

public class RoleDto {
    private Long id;
    private String name;
    private String description;




    public RoleDto(Long id, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public RoleDto(RoleEntity roleEntity) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

