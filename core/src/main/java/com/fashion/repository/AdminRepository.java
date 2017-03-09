package com.fashion.repository;

import com.fashion.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoht
 * @date 2016/9/10 14:21
 */
public interface AdminRepository  extends CrudRepository<Admin,Integer>{

    public Admin findByUsernameAndEnabled(String username,boolean flg);

    public Admin findByUsername(String username);

    @Modifying
    @Query("update Admin a set a.password = ?2 where a.id = ?1")
    int resetPassword(Integer id,String newPassword);
}
