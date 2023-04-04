package api.usermanagement.dto;


import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;

import java.util.Collection;
import java.util.List;

public class UserDto {

    private Long id;
    private String email;
    private String password;
    private List<RoleEntity> roleEntity;
    private List<RoleDto> roleDto;

    public UserDto(Long id, String email, String password, List<RoleEntity> roleEntity) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleEntity = roleEntity;
    }

    public UserDto(UserEntity userEntity) {
    }

    public UserDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(List<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }

    public List<RoleDto> getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(List<RoleDto> roleDto) {
        this.roleDto = roleDto;
    }
}