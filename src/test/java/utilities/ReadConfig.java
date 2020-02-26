package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** This test should read config properties

 */
public class ReadConfig {

    Properties pro;

    public ReadConfig(){

        File src = new File("./Configuration/config.properties");

        try{
            FileInputStream fs = new FileInputStream(src);          //read config File to get common data
            pro =new Properties();
            pro.load(fs);
        }catch (IOException ex){
            System.out.println("Error: File not found");
        }
    }

    public String getBrowser(){
        return pro.getProperty("browser");
    }
    public String getUrl(){
        return pro.getProperty("url");
    }

    public String getChromePath(){
        return pro.getProperty("chromePath");
    }

    public String getIePath(){
        return pro.getProperty("iePath");
    }

    public String getFirefoxPath(){
        return pro.getProperty("firefoxPath");
    }

}
