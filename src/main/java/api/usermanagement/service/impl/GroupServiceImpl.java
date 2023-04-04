package api.usermanagement.service.impl;

import api.usermanagement.dto.*;
import api.usermanagement.entity.GroupEntity;
import api.usermanagement.exception.BusinessException;
import api.usermanagement.repository.GroupRepository;
import api.usermanagement.service.GroupService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static api.usermanagement.util.ConstantUtils.*;

@Service
public class GroupServiceImpl implements GroupService  {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void save(GroupDto groupDto) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupName(groupDto.setGroupName());
        groupEntity.setGroupDescription(groupDto.setGroupDescription());
        groupRepository.save(groupEntity);
    }

    @Override
    public Optional<GroupEntity> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public GroupEntity<GroupEntity> updateGroup(long id) {
        return null;
    }

    @Override
    public GroupDto updateById(GroupUpdateForm form, Long id) {
        return null;
    }


    // Converter ENTITY to DTO
    private GroupDto convertToDto(GroupEntity groupEntity) {
        GroupDto dto = new GroupDto();
        dto.setId(groupEntity.getId());
        dto.setGroupDescription(groupEntity.getGroupDescription());
        return dto;
    }

    public void deleteById(Long id) {
        try {
            if (GroupRepository.existsById(id)) {
                groupRepository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_GROUP);
        }
    }
}
