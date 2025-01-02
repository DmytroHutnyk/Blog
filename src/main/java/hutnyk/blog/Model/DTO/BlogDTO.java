package hutnyk.blog.Model.DTO;



import java.util.List;


public class BlogDTO {

    private String name;
    private List<Long> articleIdList;
    private Long userId;

    public BlogDTO() {
    }

    public BlogDTO(String name, List<Long> articleIdList, Long userId) {
        this.name = name;
        this.articleIdList = articleIdList;
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getArticleIdList() {
        return articleIdList;
    }

    public void setArticleIdList(List<Long> articleIdList) {
        this.articleIdList = articleIdList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "name='" + name + '\'' +
                ", articleIdList=" + articleIdList +
                ", userId=" + userId +
                '}';
    }
}