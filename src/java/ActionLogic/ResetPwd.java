/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConnect.DBConnection;

/**
 *
 * @author LENOVO
 */
public class ResetPwd implements Business {

    @Override
    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String email = request.getParameter("email");
        String pwd=request.getParameter("pwd");
        try {
            DBConnection db = new DBConnection();
            db.pstmt = db.con.prepareStatement("update login_master set password=? where email=?");
            db.pstmt.setString(1, pwd);
            db.pstmt.setString(2, email);
            int i=db.pstmt.executeUpdate();
            if(i>0){
            return "Your password is Changed Sucessfully , You are being redirected to Login Page..";
            }

        } catch (Exception e) {
            return e.toString();
        }
        return "Last Return";
    }

}
