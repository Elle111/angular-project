package com.store.resource;

import com.store.domain.Product;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @RequestMapping (value="/add", method= RequestMethod.POST)
    public Product addProductPost(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value="/add/image", method=RequestMethod.POST)
    public ResponseEntity upload(
            @RequestParam("id") Long id,
            HttpServletResponse response, HttpServletRequest request
    ){
        try {
            Product product = productService.findOne(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id+".png";


            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/product/"+fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/update/image", method=RequestMethod.POST)
    public ResponseEntity updateImagePost(
            @RequestParam("id") Long id,
            HttpServletResponse response, HttpServletRequest request
    ){
        try {
            Product product = productService.findOne(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id+".png";

            Files.delete(Paths.get("src/main/resources/static/image/product/"+fileName));

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/product/"+fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/productList", method=RequestMethod.GET)
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public Product updateProductPost(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public ResponseEntity remove(@RequestBody String id) throws IOException{
        productService.removeOne(Long.parseLong(id));
        String fileName = id+".png";
        Files.delete(Paths.get("src/main/resources/static/image/book/"+fileName));

        return new ResponseEntity("Remove Success!", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @RequestMapping(value="/searchProduct", method=RequestMethod.POST)
    public List<Product> searchProduct (@RequestBody String keyword) {
        List<Product> productList = productService.blurrySearch(keyword);

        return productList;
    }

}
