/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import DBConnect.DBConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class Login implements Business {

    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
        String msg = "login.java";
        try {
            DBConnection db = new DBConnection();
            String email = request.getParameter("email");
            String pass = request.getParameter("pwd");
            System.out.println(pass + " " + email);
            db.pstmt = db.con.prepareStatement("select password,status from login_master where email=?");
            db.pstmt.setString(1, email);
            db.rst = db.pstmt.executeQuery();
            if (db.rst.next()) {
                String pwd = db.rst.getString("password");
                int status = db.rst.getInt("status");
                if (status == 0) {
                    return "Your account is Not Activated Yet, Check Your Email to activate Your account";
                } else if (!pass.equalsIgnoreCase(pwd)) {
                    return "You Have Interd Wrong Password";
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("name", email);
                    response.sendRedirect("../dashboard");
                }
            } else {
                msg = "Sorry, username or password error!" + request.getPathInfo();
            }

        } catch (Exception e) {
            return e.getMessage();
        }
        return msg;
    }
}
