package hutnyk.blog.Mapper;

import hutnyk.blog.Model.Article;
import hutnyk.blog.Model.Blog;
import hutnyk.blog.Model.DTO.ArticleDTO;
import hutnyk.blog.Model.DTO.BlogDTO;
import hutnyk.blog.Model.DTO.RoleDTO;
import hutnyk.blog.Model.DTO.UserDTO;
import hutnyk.blog.Model.Role;
import hutnyk.blog.Model.User;
import hutnyk.blog.Repository.ArticleRepository;
import hutnyk.blog.Repository.BlogRepository;
import hutnyk.blog.Repository.RoleRepository;
import hutnyk.blog.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityMapper {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final ArticleRepository articleRepository;
    private final RoleRepository roleRepository;


    public EntityMapper(UserRepository userRepository, BlogRepository blogRepository, ArticleRepository articleRepository,
                        RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
        this.articleRepository = articleRepository;
        this.roleRepository = roleRepository;
    }

    public ArticleDTO articleToDTO (Article article){
        return new ArticleDTO(article.getTitle(), article.getUser().getId(), article.getBlog().getId());
    }

    public BlogDTO blogToDTO(Blog blog){
        return new BlogDTO(blog.getName(),
                blog.getArticleList().stream().map(Article::getId).toList(),
                blog.getUser().getId());
    }

    public RoleDTO roleToDTO(Role role){
        return new RoleDTO(role.getName(),
                role.getUserList().stream().map(User::getId).toList());
    }

    public UserDTO userToDTO(User user){
        return new UserDTO(user.getEmail(),
                user.getArticleList().stream().map(Article::getId).toList(),
                user.getBlog().getId(),
                user.getRoleList().stream().map(Role::getId).toList());
    }

    public Article dtoToArticle(ArticleDTO articleDTO){
        User user = userRepository.findById(articleDTO.getUserId()).orElseThrow(
                () -> new EntityNotFoundException("User not found with id: " + articleDTO.getUserId())
        );

        Blog blog = blogRepository.findById(articleDTO.getBlogId()).orElseThrow(
                () -> new EntityNotFoundException("Blog not found with id: " + articleDTO.getBlogId())
        );
        return new Article(articleDTO.getTitle(), user, blog);
    }

    public Blog dtoToBlog(BlogDTO blogDTO) {
        User user = userRepository.findById(blogDTO.getUserId()).orElseThrow(
                () -> new EntityNotFoundException("User not found with id: " + blogDTO.getUserId())
        );

        List<Article> articles = blogDTO.getArticleIdList().stream()
                .map(articleId -> articleRepository.findById(articleId).orElseThrow(
                        () -> new EntityNotFoundException("Article not found with id: " + articleId)
                ))
                .toList();

        return new Blog(blogDTO.getName(), articles, user);
    }


    public User dtoToUser(UserDTO userDTO) {
        Blog blog = blogRepository.findById(userDTO.getBlogId()).orElseThrow(
                () -> new EntityNotFoundException("Blog not found with id: " + userDTO.getBlogId())
        );

        List<Article> articles = userDTO.getArticleIdList().stream()
                .map(articleId -> articleRepository.findById(articleId).orElseThrow(
                        () -> new EntityNotFoundException("Article not found with id: " + articleId)
                ))
                .toList();

        List<Role> roles = userDTO.getRoleIdList().stream()
                .map(roleId -> roleRepository.findById(roleId).orElseThrow(
                        () -> new EntityNotFoundException("Role not found with id: " + roleId)
                ))
                .toList();

        return new User(userDTO.getEmail(), articles, blog, roles);
    }

    public Role dtoToRole(RoleDTO roleDTO) {
        List<User> users = roleDTO.getUserIdList().stream()
                .map(userId -> userRepository.findById(userId).orElseThrow(
                        () -> new EntityNotFoundException("User not found with id: " + userId)
                ))
                .toList();

        return new Role(roleDTO.getName(), users);
    }


}
