package com.store.service.impl;

import com.store.config.SecurityUtility;
import com.store.domain.User;
import com.store.domain.security.Role;
import com.store.domain.security.UserRole;
import com.store.repository.*;
import com.store.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserBillingRepository userBillingRepository;

    @MockBean
    private UserPaymentRepository userPaymentRepository;

    @MockBean
    private UserShippingRepository userShippingRepository;

    @Before
    public void setUp() {
        User user1 = new User();
        user1.setFirstName("Admin");
        user1.setLastName("Admin");
        user1.setUsername("admin");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
        user1.setEmail("1@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));
        userService.createUser(user1, userRoles);
        userRoles.clear();

        Mockito.when(userRepository.findByUsername(user1.getUsername()))
                .thenReturn(user1);
    }

    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "admin";
        User found = userService.findByUsername(name);

        assertTrue("User found", found.isEnabled());
    }

}
