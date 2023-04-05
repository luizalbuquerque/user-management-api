package api.usermanagement.dto;

public class GroupDto {

    private Long id;
    private String groupName;
    private String groupDescription;

    private String members;

    public GroupDto(Long id, String groupName, String groupDescription, String members) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.members = members;
    }

    public GroupDto() {
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

    public void setNome(String nome) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
}
