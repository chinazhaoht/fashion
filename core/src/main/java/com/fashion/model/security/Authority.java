package com.fashion.model.security;

import com.fashion.model.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author zhaoht
 * @date 2016/9/10 15:00
 */
@Entity
@Table(name = "security_authority")
public class Authority  extends BaseEntity implements GrantedAuthority{
    private static final long serialVersionUID = 1L;

    private String name;

    private String displayName;

    private String remark;

    private LocalDateTime createdTime;

    private Integer pId; // 上级权限id

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

    public String getAuthority() {
        return name;
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Authority))
            return false;

        if (id == null)
            return super.equals(obj);

        return this.id.equals(((Authority) obj).id);
    }

    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }

}
