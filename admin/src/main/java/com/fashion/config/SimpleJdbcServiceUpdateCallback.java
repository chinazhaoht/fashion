package com.fashion.config;

import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoht
 * @date 2016/12/23 15:13
 */
public class SimpleJdbcServiceUpdateCallback implements IDisconfUpdate {

    protected static final Logger logger = LoggerFactory.getLogger(SimpleJdbcServiceUpdateCallback.class);

    @Override
    public void reload() throws Exception {

    }
}
