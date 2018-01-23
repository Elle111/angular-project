//package com.store.service.impl;
//
//        import com.store.domain.Product;
//        import com.store.repository.ProductRepository;
//        import com.store.service.ProductService;
//        import com.store.service.impl.ProductServiceImpl;
//        import org.junit.Before;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.mockito.Mockito;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.boot.test.context.TestConfiguration;
//        import org.springframework.boot.test.mock.mockito.MockBean;
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.test.context.junit4.SpringRunner;
//
//        import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//public class ProductServiceImplTest {
//
//    @TestConfiguration
//    static class ProductServiceImplTestContextConfiguration {
//
//        @Bean
//        public ProductService productService() {
//            return new ProductServiceImpl();
//        }
//    }
//
//    @Autowired
//    private ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;
//
//    @Before
//    public void setUp() {
//        Product coffee = new Product("coffee");
//
//        Mockito.when(productRepository.findByNameContaining(coffee.getName()))
//                .thenReturn(coffee);
//    }
//
//    @Test
//    public void whenValidName_thenProductShouldBeFound() {
//        String name = "coffee";
//        Product found = productService.blurrySearch(name);
//
//        assertEquals (name, found.getName());
//    }
//}
