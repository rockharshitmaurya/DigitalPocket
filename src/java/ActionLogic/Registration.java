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
            db.pstmt=db.con.prepareStatement("insert into registration(name,email,password,rec_q,rec_a,country,state,city,mo_no,gender) values(?,?,?,?,?,?,?,?,?,?)");
            db.pstmt.setString(1,name);
            db.pstmt.setString(2,email);
            db.pstmt.setString(3,pwd);
            db.pstmt.setString(4,qus);
            db.pstmt.setString(5,ans);
            db.pstmt.setString(6,country);
            db.pstmt.setString(7,state);
            db.pstmt.setString(8,city);
            db.pstmt.setString(9,no);
            db.pstmt.setString(10,gender);
            int i=db.pstmt.executeUpdate();
            if(i>0){
                db.pstmt=db.con.prepareStatement("insert into login(email,password,u_id,name) values(?,?,?,?)");
                db.pstmt.setString(1, email);
                db.pstmt.setString(2, pwd);
                db.pstmt.setString(3, email.substring(0,email.indexOf("@")));
                db.pstmt.setString(4, name);
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
