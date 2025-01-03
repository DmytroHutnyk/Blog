package hutnyk.blog.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Article> articleList;

    @OneToOne(mappedBy = "blog", cascade = CascadeType.ALL)
    private User user;

    public Blog() {
    }

    public Blog(String name, List<Article> articleList, User user) {
        this.name = name;
        this.articleList = articleList;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}