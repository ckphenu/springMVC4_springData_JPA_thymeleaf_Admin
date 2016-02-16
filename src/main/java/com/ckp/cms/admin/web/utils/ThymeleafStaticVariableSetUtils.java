package com.ckp.cms.admin.web.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Ecic Chen on 2016/2/14.
 */
public class ThymeleafStaticVariableSetUtils {

    public static Map returnAmap(String configPath){
        try {
            Resource resource = new ClassPathResource(configPath);
            InputStream inputStream = resource.getInputStream();
            Properties properties = new Properties();
            properties.load(new InputStreamReader(inputStream,"UTF-8"));
            Map<String,Object> staticVariable = new HashMap<String, Object>((Map)properties);
            return staticVariable;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
