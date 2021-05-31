/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConnect.DBConnection;

/**
 *
 * @author LENOVO
 */
public class Forget implements Business {

    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
        MailSender ms = new MailSender();
        String email = request.getParameter("email");
        Random rnd = new Random();
        int otp = rnd.nextInt(999999);
        try {
            DBConnection db = new DBConnection();
            db.pstmt = db.con.prepareStatement("insert into email_verification(email,verification_code,creation_time) values(?,?,now())");
            db.pstmt.setString(1, email);
            db.pstmt.setString(2, String.valueOf(otp));
            int l = db.pstmt.executeUpdate();
            ms.email = email;
            ms.msg = "http://localhost:8080/DigitalPocket/verifyemail?uid=" + String.valueOf(otp);
            ms.processRequest(request, response);
            return "Success ! </strong>we have sent you an link vie email, Use the the link to Rest Your Password";
        } catch (Exception e) {

        }
        return email;
    }

}
