package hutnyk.blog.Model.DTO;

import java.util.List;


public class UserDTO {

    private String email;
    private List<Long> articleIdList;
    private Long blogId;
    private List<Long> roleIdList;

    public UserDTO() {
    }

    public UserDTO(String email, List<Long> articleIdList, Long blogId, List<Long> roleIdList) {
        this.email = email;
        this.articleIdList = articleIdList;
        this.blogId = blogId;
        this.roleIdList = roleIdList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getArticleIdList() {
        return articleIdList;
    }

    public void setArticleIdList(List<Long> articleIdList) {
        this.articleIdList = articleIdList;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", articleIdList=" + articleIdList +
                ", blogId=" + blogId +
                ", roleIdList=" + roleIdList +
                '}';
    }
}