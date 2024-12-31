package hutnyk.blog.Model.DTO;


public class ArticleDTO {

    private String title;
    private Long userId;
    private Long blog;

    public ArticleDTO() {
    }

    public ArticleDTO(String title, Long userId, Long blog) {
        this.title = title;
        this.userId = userId;
        this.blog = blog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBlogId() {
        return blog;
    }

    public void setBlogId(Long blog) {
        this.blog = blog;
    }
}