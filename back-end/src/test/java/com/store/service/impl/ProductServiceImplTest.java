package com.store.service.impl;

import com.store.config.SecurityUtility;
import com.store.domain.Product;
import com.store.domain.User;
import com.store.domain.security.Role;
import com.store.domain.security.UserRole;
import com.store.repository.*;
import com.store.service.ProductService;
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
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private RoleRepository roleRepository;

    @Before
    public void setUp() {
        Product product1 = new Product();
        long id = 1;
        product1.setId( id);
        product1.setName("French coffee");
        product1.setCategory("coffee");
        product1.setSize("1 Lb Bag");

        Mockito.when(productRepository.findOne(product1.getId()))
                .thenReturn(product1);
    }

    @Test
    public void whenValidName_thenProductShouldBeFound() {
        long id = 1;
        Product found = productRepository.findOne(id);

        assertTrue("Product found", found.isActive());
    }

}
