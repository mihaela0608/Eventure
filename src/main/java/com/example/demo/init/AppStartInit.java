package com.example.demo.init;

import com.example.demo.model.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartInit implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public AppStartInit (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run (String... args) throws Exception {
        if (roleRepository.count() == 0){
            roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));
            roleRepository.save(new Role("ORGANIZER"));
        }
    }
}
