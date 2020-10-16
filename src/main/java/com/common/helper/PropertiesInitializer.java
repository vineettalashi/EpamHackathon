package com.common.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesInitializer {


    private static PropertiesInitializer instance =null;


    private Properties props = null;


    private PropertiesInitializer() throws FileNotFoundException, IOException{


        this.props=new Properties();
        File fileUserProp = new File(".\\src\\main\\resources\\config\\apiconfig.properties");
        props.load(new FileInputStream(fileUserProp));
    }

    public static PropertiesInitializer getInstance() throws FileNotFoundException, IOException{
        if(instance==null){
            instance=new PropertiesInitializer();
        }
        return instance;
    }

    //Generic
    public String getValue(String propKey){
        return props.getProperty(propKey);
    }

    public String getBaseUrl(){
        return props.getProperty("base.url");
    }

}
