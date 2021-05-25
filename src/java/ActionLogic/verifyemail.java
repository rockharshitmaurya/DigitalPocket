/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionLogic;

import DBConnect.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class verifyemail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String otp=request.getParameter("uid");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verifyemail</title>");            
            out.println("</head>");
            out.println("<body>");
            DBConnection db=new DBConnection();
            db.pstmt=db.con.prepareStatement("select user_id from verification where vcode=?");
            db.pstmt.setString(1, otp);
            db.rst=db.pstmt.executeQuery();
            if(db.rst.next()){
                String username=db.rst.getString("user_id");
                db.pstmt=db.con.prepareStatement("update login set status=? where u_id=?");
                db.pstmt.setInt(1, 1);
                db.pstmt.setString(2, username);
                int i=db.pstmt.executeUpdate();
                if(i>0){
                    out.println("<h1>congratulations your account has been activated,</h1>");
                    String link="signin";
                    out.println("<h1><a href="+link+">Click Here To Login</a></h1>");
                }else{
                    
                   out.println("<h1>Error Inner !</h1>"); 
                }
            }else{
               out.println("<h1>Error Outer !</h1>"); 
            }
            
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            e.printStackTrace(out);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
