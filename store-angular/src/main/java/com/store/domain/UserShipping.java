package com.store.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Class describes the entity "UserShipping"
 * The @Entity annotation says that objects of this class will be handled by hibernate.
 * @author Buchynska S
 */
@Entity
@Getter
@Setter
public class UserShipping implements Serializable{
    private static final long serialVersionUID = 46547883L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userShippingName;
    private String userShippingStreet1;
    private String userShippingStreet2;
    private String userShippingCity;
    private String userShippingState;
    private String userShippingCountry;
    private String userShippingZipcode;
    private Boolean userShippingDefault;


    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;



}
