/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import javax.servlet.http.HttpServletRequest;
import DBConnect.DBConnection;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author LENOVO
 */
public class Registration implements Business{
     public String actionLogic(HttpServletRequest request,HttpServletResponse response){
         String name=request.getParameter("name");
         String email=request.getParameter("email");
       String pwd=request.getParameter("pwd");
       String cpwd=request.getParameter("cpwd");
       String no=request.getParameter("txtEmpPhone");
       String state=request.getParameter("state");
       String city=request.getParameter("city");
       String country=request.getParameter("country");
       String gender=request.getParameter("gender");
       String ans=request.getParameter("ans");
       String qus=request.getParameter("qus");
       try{
           DBConnection db=new DBConnection();
            db.pstmt=db.con.prepareStatement("insert into user_master(uid,name,phone_no,city_id,email,gender) values(?,?,?,?,?,?)");
            db.pstmt.setInt(1, 1);
            db.pstmt.setString(2,name);
            db.pstmt.setString(3,no);
            db.pstmt.setInt(4,1);
            db.pstmt.setString(5,email);
            db.pstmt.setString(6,gender);
            int i=db.pstmt.executeUpdate();
            if(i>0){
                db.pstmt=db.con.prepareStatement("insert into login_master(email,password,name) values(?,?,?)");
                db.pstmt.setString(1, email);
                db.pstmt.setString(2, pwd);
                db.pstmt.setInt(3, Integer.valueOf(name));
                int j=db.pstmt.executeUpdate();
                if(j>0){
                   Random rnd = new Random();
                    int otp = rnd.nextInt(999999); 
                    db.pstmt=db.con.prepareStatement("insert into verification(user_id,vcode) values(?,?)");
                     db.pstmt.setString(1, email.substring(0,email.indexOf("@")));
                     db.pstmt.setString(2, String.valueOf(otp));
                     int k=db.pstmt.executeUpdate();
                     if(k>0){
//                         out.println("<h1>Registion Sucessfull,please please check your inbox to verfy Your email</h1>");
                    MailSender ms=new MailSender();
                    ms.email=email;
                    ms.msg="http://localhost:8080/DigitalPocket/verifyemail?uid="+String.valueOf(otp);
                    ms.processRequest(request, response);
                    return "Registion Sucessfull,please please check your inbox to verfy Your email";
                     }else{
                          rollback(db, email, "registration");
                           rollback(db, email, "login");
                         return "E-Mail Error";
                         
                     }
                }else{
                    rollback(db, email, "registration");
                }
            }else{
                return "Reg Error";
            }
      
       } catch(Exception e){
           return e+"Exception#";
       }
       return new String("");
     }
     boolean rollback(DBConnection db,String name,String table)throws Exception{
         db.pstmt=db.con.prepareStatement("delete from"+table+"where email="+name);
         int i=db.pstmt.executeUpdate();
         return i>0?true:false;
     }
}
