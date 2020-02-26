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
        String browser = pro.getProperty("browser");
        return null;
    }
    public String getUrl(){
        String url = pro.getProperty("url");
        return url;
    }

    public String getChromePath(){
        String chromePath = pro.getProperty("chromePath");
        return chromePath;
    }

    public String getIePath(){
        String iePath = pro.getProperty("iePath");
        return iePath;
    }

    public String getFirefoxPath(){
        String firefoxPath = pro.getProperty("firefoxPath");
        return firefoxPath;
    }

}
