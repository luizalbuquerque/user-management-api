package api.usermanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groupName", nullable = false)
    private String groupName;

    @Column(name = "description", nullable = false)
    private String groupDescription;

    public GroupEntity() {
    }

    public GroupEntity(Long id, String groupName, String groupDescription, GroupEntity groupEntity) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return groupName;
    }

    public void setName(String name) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return groupName;
    }

    public void setDescription(String description) {
        this.groupDescription = groupDescription;
    }
}
