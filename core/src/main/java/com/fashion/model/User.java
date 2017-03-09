package com.fashion.model;

import com.fashion.model.base.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2015-10-21.
 */
@Entity
public class User extends BaseEntity {

    private String weixinNo;
    private String phone;
    private String email;
    private Boolean sex;
    private Integer age;
    private String address;


}
