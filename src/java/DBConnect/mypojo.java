/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author LENOVO
 */
public class mypojo {
    public HashMap<Integer,String> dataGet(){
        HashMap<Integer,String> map=new HashMap<>(); 
        int i=0;
        try{
//            URL url = new URL("https:\//api.github.com/users/rockharshitmaurya");
//HttpURLConnection http = (HttpURLConnection)url.openConnection();
//System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
//http.disconnect();   
            DBConnect.DBConnection db=new DBConnection();
               db.pstmt=db.con.prepareStatement("select * from user_table");
               db.rst=db.pstmt.executeQuery();
               while(db.rst.next()){
                   
                 map.put(++i, db.rst.getString(i));
//                 System.out.println(map);
               }
            }catch(Exception e){
                System.out.print(e);
            }
        return map;
    }
//    public static void main(String[] args) {
//        new mypojo().dataGet();
//    }
}
