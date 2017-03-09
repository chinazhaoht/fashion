package com.fashion.model.security;

import com.fashion.model.Admin;
import com.fashion.model.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhaoht
 * @date 2016/9/10 14:59
 */
@Entity
@Table(name = "security_role")
public class Role extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String name; // 角色名称

    private String displayName; // 角色显示名称

    private String remark;

    private boolean enabled;

    private LocalDateTime createdTime;

    private LocalDateTime lastModifiedTime;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "security_role_authority", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id") })
    private List<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin admin;

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Role))
            return false;

        if (id == null)
            return super.equals(obj);

        return this.id.equals(((Role) obj).id);
    }

    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }

}
