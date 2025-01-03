package hutnyk.blog.Service;

import hutnyk.blog.Mapper.EntityMapper;
import hutnyk.blog.Model.DTO.UserDTO;
import hutnyk.blog.Model.User;
import hutnyk.blog.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final EntityMapper mapper;
    private final UserRepository repository;

    public UserService(EntityMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::userToDTO)
                .toList();
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = mapper.dtoToUser(userDTO);
        User savedUser = repository.save(user);
        return mapper.userToDTO(savedUser);
    }

    @Transactional
    public UserDTO findUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return mapper.userToDTO(user);
    }

    public void deleteUserById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Transactional
    public UserDTO findUserByEmail(String email) {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        return mapper.userToDTO(user);
    }
}