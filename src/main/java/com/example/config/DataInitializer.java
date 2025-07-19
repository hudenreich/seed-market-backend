package com.example.config;

import com.example.entity.ERole;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional; // Import this!
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData() {
        // Проверяем и создаем роли, если их нет
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
            System.out.println("Role ROLE_USER created.");
        }
        if (roleRepository.findByName(ERole.ROLE_MODERATOR).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
            System.out.println("Role ROLE_MODERATOR created.");
        }
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
            System.out.println("Role ROLE_ADMIN created.");
        }

        // Создаем администратора, если его нет
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", "admin@example.com", encoder.encode("adminpass"));
            Set<Role> roles = new HashSet<>();

            // **********************************************************************************
            // ВАЖНО: Получаем роли из базы данных в этой же транзакции
            // Это гарантирует, что сущности Role "attached"
            // **********************************************************************************
            roleRepository.findByName(ERole.ROLE_ADMIN).ifPresent(roles::add);
            roleRepository.findByName(ERole.ROLE_MODERATOR).ifPresent(roles::add);
            roleRepository.findByName(ERole.ROLE_USER).ifPresent(roles::add);

            admin.setRoles(roles);
            userRepository.save(admin);
            System.out.println("Admin user created.");
        }
        // Можно добавить других пользователей, если нужно
    }
}