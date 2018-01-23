//package com.store.repository;
//
//import com.store.AngularApplication;
//import com.store.domain.Product;
//import com.store.repository.ProductRepository;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = NONE)
//@ContextConfiguration(classes = AngularApplication.class, loader = AnnotationConfigContextLoader.class)
//public class TestProductRepository {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ProductRepository productRepository;
//    private Product coffee;
//    private Product tea;
//
//   public TestProductRepository () {
//       coffee = new Product("coffee");
//       tea = new Product("tea");
//   }
//
//   @After
//    public void cleanup(){
//       this.entityManager.clear();
//   }
//
//   @Test
//    public void testFindAllProducts(){
//        this.entityManager.persist(coffee);
//        Iterable<Product> products = productRepository.findAll();
//        int count = 0;
//        for (Product productRepo: products){
//            assertEquals ("coffee", productRepo.getName());
//            assertEquals ("tea", productRepo.getName());
//            assertTrue(productRepo.getId()>0L);
//            count++;
//        }
//        assertEquals(1, count);
//   }
//}
