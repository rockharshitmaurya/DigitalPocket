/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Back-On-Project
/**
 *
 * @author LENOVO
 */
public interface Business {

    /**
     *
     * @param request
     * @param response
     * @return
     */
    public String actionLogic(HttpServletRequest request,HttpServletResponse response);
}
