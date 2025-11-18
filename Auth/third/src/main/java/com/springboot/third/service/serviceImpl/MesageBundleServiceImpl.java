package com.springboot.third.service.serviceImpl;

import com.springboot.third.config.ResourceBundle;
import com.springboot.third.helper.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MesageBundleServiceImpl {
    private ResourceBundleMessageSource resourceBundle;
    @Autowired
    public MesageBundleServiceImpl(ResourceBundleMessageSource resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
    public String getMessageEn(String key){
        return resourceBundle.getMessage(key,null,new Locale("en"));
    }
    public String getMessageAr(String key){
        return resourceBundle.getMessage(key,null,new Locale("ar"));
    }
    public ExceptionResponse getMessage(String key){
        return new ExceptionResponse(getMessageEn(key),getMessageAr(key));
    }
}
