package Dao;

import Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
     Role findByRoleName(String rolename);
}
