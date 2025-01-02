package hutnyk.blog.Service;

import hutnyk.blog.Mapper.EntityMapper;
import hutnyk.blog.Model.DTO.RoleDTO;
import hutnyk.blog.Model.Role;
import hutnyk.blog.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final EntityMapper mapper;
    private final RoleRepository repository;

    public RoleService(EntityMapper mapper, RoleRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<RoleDTO> getAllRoles() {
        return repository.findAll().stream()
                .map(mapper::roleToDTO)
                .toList();
    }

    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role = mapper.dtoToRole(roleDTO);
        Role savedRole = repository.save(role);
        return mapper.roleToDTO(savedRole);
    }

    public RoleDTO findRoleById(Long id) {
        Role role = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
        return mapper.roleToDTO(role);
    }

    public void deleteRoleById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Role not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public RoleDTO findRoleByName(String name) {
        Role role = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with name: " + name));
        return mapper.roleToDTO(role);
    }
}