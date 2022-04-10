package Security.service;

import Dao.RoleRepository;
import Dao.UserRepository;
import Entity.Role;
import Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class AccountService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    public AccountService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User loadUserName(String name){
        return userRepository.findByName(name);
    }

    public User addNewUser(User user){
        String pwd = user.getPassword();
        user.setPassword(passwordEncoder.encode(pwd));
        return userRepository.save(user);
    }

    public Role addNewRole(Role role){
        return roleRepository.save(role);
    }
    public void addRoleToUser(String username, String rolename){
        Role role = roleRepository.findByRoleName(rolename);
        User user = userRepository.findByName(username);

        user.getRoleCollection().add(role);
    }
}
