package com.fashion.model;

import com.fashion.model.base.BaseEntity;
import com.fashion.model.security.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2015-10-21.
 */
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"mobile"}),
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class Admin extends BaseEntity {

    private static final long serialVersionUID = 5756552757094999975L;

    @NotNull
    @Length(min=2,max=50)
    private String username;
    @NotNull
    @Length(max=60)
    private String password;
    @Length(min=7,max=18)
    private String mobile;
    @Email
    @Length(max=128)
    private String email;
    @NotNull
    private LocalDateTime createdTime;
    @NotNull
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "admin_role",joinColumns = {@JoinColumn(name = "admin_id",referencedColumnName = "id")},inverseJoinColumns={@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles(){
        return roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }
}
