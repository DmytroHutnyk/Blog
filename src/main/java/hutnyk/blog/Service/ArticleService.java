package hutnyk.blog.Service;

import hutnyk.blog.Mapper.EntityMapper;
import hutnyk.blog.Model.DTO.ArticleDTO;
import hutnyk.blog.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    private final ArticleRepository repository;
    private final EntityMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, EntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



}
