package hutnyk.blog.Model.DTO;

import java.util.List;

public class RoleDTO {

    private String name;
    private List<Long> userIdList;

    public RoleDTO() {
    }

    public RoleDTO(String name, List<Long> userIdList) {
        this.name = name;
        this.userIdList = userIdList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }
}