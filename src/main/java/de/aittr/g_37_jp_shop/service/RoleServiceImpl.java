package de.aittr.g_37_jp_shop.service;

import de.aittr.g_37_jp_shop.domain.entity.Role;
import de.aittr.g_37_jp_shop.repository.RoleRepository;
import de.aittr.g_37_jp_shop.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role getRoleUser() {
        Role role = repository.findByTitle("ROLE_USER");

        if (role == null) {
            throw new RuntimeException("Database does not contain ROLE_USER");
        }

        return role;
    }
}