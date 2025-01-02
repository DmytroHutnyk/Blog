package hutnyk.blog.Service;

import hutnyk.blog.Mapper.EntityMapper;
import hutnyk.blog.Model.Blog;
import hutnyk.blog.Model.DTO.BlogDTO;
import hutnyk.blog.Repository.BlogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final EntityMapper mapper;
    private final BlogRepository repository;

    @Autowired
    public BlogService(EntityMapper mapper, BlogRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<BlogDTO> getAllBlogs() {
        return repository.findAll().stream()
                .map(mapper::blogToDTO)
                .toList();
    }

    public BlogDTO addBlog(BlogDTO blogDTO) {
        Blog blog = mapper.dtoToBlog(blogDTO);
        Blog savedBlog = repository.save(blog);
        return mapper.blogToDTO(savedBlog);
    }

    public BlogDTO findBlogById(Long id) {
        Blog blog = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Blog not found with id: " + id));
        return mapper.blogToDTO(blog);
    }

    public void deleteBlogById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Blog not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public BlogDTO findBlogByName(String name) {
        Blog blog = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Blog not found with name: " + name));
        return mapper.blogToDTO(blog);
    }
}