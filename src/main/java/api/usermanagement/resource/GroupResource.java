package api.usermanagement.resource;

import api.usermanagement.dto.*;
import api.usermanagement.entity.GroupEntity;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.repository.GroupRepository;
import api.usermanagement.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/groups")
public class GroupResource {
    private final GroupService groupService;

    private final GroupRepository groupRepository;

    public GroupResource(GroupService groupService, GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody GroupDto groupDto) {
        groupService.save(groupDto);
    }


    @GetMapping
    public List<GroupEntity> list() {
        return groupRepository.findAll();
    }


    @GetMapping("/{groupId}")
    // @Secured({"GROUP_A", "GROUP_B"})
    public Optional<GroupEntity> findById(@PathVariable Long id) {
        return groupService.findById(id);
    }


    @PutMapping("/{groupId}")
    public UserDto updateById(@RequestBody GroupUpdateForm form, @PathVariable("id") Long id) {
        return groupService.updateById(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        groupService.deleteById(id);
    }


}
