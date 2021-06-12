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
public class rstToken implements Business{

    @Override
    public String actionLogic(HttpServletRequest request, HttpServletResponse response) {
            String code=request.getParameter("uid");
            String email=request.getParameter("email");
            
            
        try{ 
//            DBConnection db=new DBConnection();
            
        }catch(Exception e){
            return e.toString();
        }
        return "rstToken";
    }
    
    
}
