package api.usermanagement.service;

import api.usermanagement.dto.*;
import api.usermanagement.entity.GroupEntity;
import api.usermanagement.entity.RoleEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface GroupService {
    void save(GroupDto groupDto);

    Optional<GroupEntity> findById(Long id);

    ResponseEntity<GroupEntity> updateGroup(long id);

    GroupDto updateById(GroupUpdateForm form, Long id);

    void deleteById(Long id);
}
