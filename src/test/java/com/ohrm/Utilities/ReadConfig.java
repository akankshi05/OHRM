package com.ohrm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

          Properties prop;

          public ReadConfig(){

              File scr = new File("src/Configuration/config.properties");
              try{

                  FileInputStream fis = new FileInputStream(scr);
                  prop = new Properties();
                  prop.load(fis);
              }
              catch(Exception e){
                  System.out.println("Exception is:" + e.getMessage());

              }
          }

          public String getUserName(){

              return prop.getProperty("username");
          }

          public String getUrl(){
              return prop.getProperty("url");
          }

          public String getPassword(){
              return prop.getProperty("password");
          }


}
