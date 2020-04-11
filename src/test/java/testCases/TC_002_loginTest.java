package testCases;


import org.json.simple.JSONArray;

import org.json.simple.JSONObject;


import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class TC_002_loginTest {

    @Test(dataProvider = "dp")
    void login(){


        }

//    //read data
//    @DataProvider(name="dp")
//    public String[] readJson() throws IOException, ParseException, org.json.simple.parser.ParseException {
//
//        JSONParser jsonParser = new JSONParser();
//        FileReader fr = new FileReader("./SharedData/loginData.json");
//
//        Object obj =jsonParser.parse(fr);
//       JSONObject userloginsObj =  (JSONObject) obj;
//       JSONArray userLoginsArray = (JSONArray) userloginsObj.get("userlogins");
//
//       String arr[] = new String[userLoginsArray.size()];
//
//       for (int i=0; i<userLoginsArray.size(); i++){
//
//        JSONObject users = (JSONObject) userLoginsArray.get(i);
//        String user = (String)users.get("username");
//        String pwd = (String)users.get("password");
//
//        arr[i]=user+","+pwd;
//
//       }
//       return arr;
//    }
}
