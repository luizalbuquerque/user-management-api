package api.usermanagement.repository;

import api.usermanagement.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public class GroupRepository extends JpaRepository<GroupEntity, Long> {
    GroupEntity findByName(String groupName);

    GroupEntity findByDescription(String groupDescription);
}
