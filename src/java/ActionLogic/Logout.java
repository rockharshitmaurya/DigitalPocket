/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class Logout implements Business{

    @Override
    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
        String msg="";
           
            HttpSession session=request.getSession();  
            session.invalidate();  
        try {
            response.sendRedirect("index.html");
        } catch (IOException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
            return "You are successfully logged out!"+msg; 
        
    }
    
}
