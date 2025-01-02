package hutnyk.blog.Service;

import hutnyk.blog.Mapper.EntityMapper;
import hutnyk.blog.Model.DTO.ArticleDTO;
import hutnyk.blog.Repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;
    private final EntityMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, EntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ArticleDTO> findAllArticles(){
        return repository.findAll().stream().map(mapper::articleToDTO).toList();
    }

    public ArticleDTO findArticleById(Long id){
        return mapper.articleToDTO(
                repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Article not found with id: " + id))
        ) ;
    }

    public ArticleDTO addArticle(ArticleDTO dto){
        return mapper.articleToDTO(repository.save(mapper.dtoToArticle(dto)));
    }

    public List<ArticleDTO> findArticlesByTitle(String title) {
        return repository.findByTitle(title).stream()
                .map(mapper::articleToDTO)
                .toList();
    }

    public void deleteArticleById(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Article not found with id:  + id");
        }
        repository.deleteById(id);
    }
}
