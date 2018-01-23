package com.store;

import com.store.config.SecurityUtility;
import com.store.domain.security.Role;
import com.store.domain.User;
import com.store.domain.security.UserRole;
import com.store.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AngularApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public final static Logger logger = LoggerFactory.getLogger(AngularApplication.class);


    public static void main(String[] args) {

        SpringApplication.run(AngularApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        User user1 = new User();
        user1.setFirstName("emma");
        user1.setLastName("Smith");
        user1.setUsername("e");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user1.setEmail("buchynskalana@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));
        userService.createUser(user1, userRoles);

        userRoles.clear();

        User user2 = new User();
        user2.setFirstName("Admin");
        user2.setLastName("Admin");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user2.setEmail("Admin@gmail.com");
        Role role2 = new Role();
        role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user2, role2));

        userService.createUser(user2, userRoles);

    }
}
