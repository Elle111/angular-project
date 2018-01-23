package com.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class describes the entity "Products"
 * The @Entity annotation says that objects of this class will be handled by hibernate.
 *  @Table (name = "product") annotation points to the "products" table in which objects will be stored.
 * @author Buchynska S
 */
@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 4678786L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String name;

    private String category;
    private String size;
    private String servingType;
    private String roast;
    private String region;
    private String caffeine;
    private int listPrice;
    private int ourPrice;
    private boolean active = true;
    private int inStockNumber;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    private MultipartFile productImage;

}
