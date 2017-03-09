package com.fashion.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhaoht
 * @date 2016/12/23 15:08
 */
@Service
@DisconfFile(filename = "jdbc.properties")
public class JdbcConfig {

    private String username;

    @Value(value = "1.0.0d")
    private String password;

    @DisconfFileItem(name = "jdbc.username",associateField = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
