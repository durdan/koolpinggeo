package com.drg.koolping.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

/**
 * Created by durdan on 30/10/2015.
 */

@Data
@Document
public class CustomerEntity {

    @Id
    private String customerId;

    @Email
    private String email;
    private String password;
    private String phone;
    private String postCode;
    private String firstName;
    private String lastName;
    private String createdDate;



}
