/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import javax.servlet.http.HttpServletRequest;
import DBConnect.DBConnection;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class Registration implements Business {

    /**
     *
     * @param request
     * @param response
     * @return
     */
    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String no = request.getParameter("txtEmpPhone");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        String ans = request.getParameter("ans");
        String qus = request.getParameter("qus");
        
        try {
            DBConnection db = new DBConnection();
//            db.pstmt=db.con.prepareStatement("select max(uid) from user_master");
//            db.rst=db.pstmt.executeQuery();
//            int max=db.rst.next()==true?db.rst.getInt(1):1;
            
            db.pstmt = db.con.prepareStatement("insert into user_master(name,phone_no,city_id,email,gender)"
                    + " values(?,?,(select id from cities where "
                    + "(name=? AND country_id=(select id from countries where name=?))),?,?)");
//            db.pstmt.setInt(1, max);
            db.pstmt.setString(1, name);
            db.pstmt.setString(2, no);
            db.pstmt.setString(3, city);
            db.pstmt.setString(4, country);
            db.pstmt.setString(5, email);
            db.pstmt.setString(6, gender);
            PreparedStatement userq = db.pstmt;
            db.pstmt = db.con.prepareStatement("insert into login_master(email,password,status) values(?,?,?)");
            db.pstmt.setString(1, email);
            db.pstmt.setString(2, pwd);
            db.pstmt.setInt(3, 0);
            int j = db.pstmt.executeUpdate();
            int k = userq.executeUpdate();

            Random rnd = new Random();
            int otp = rnd.nextInt(999999);
            db.pstmt = db.con.prepareStatement("insert into email_verification(email,verification_code,creation_time) values(?,?,now())");
            db.pstmt.setString(1, email);
            db.pstmt.setString(2, String.valueOf(otp));
            int l = db.pstmt.executeUpdate();
            MailSender ms = new MailSender();
            ms.email = email;
            ms.msg = "http://localhost:8080/DigitalPocket/verifyemail?uid=" + String.valueOf(otp);
            ms.processRequest(request, response);
            return "Registion Sucessfull,please please check your inbox to verfy Your email";

        } catch (Exception e) {
            return e + "Exception#";
        }

    }

    boolean rollback(DBConnection db, String name, String table) throws Exception {
        db.pstmt = db.con.prepareStatement("delete from" + table + "where email=" + name);
        int i = db.pstmt.executeUpdate();
        return i > 0 ? true : false;
    }
}
