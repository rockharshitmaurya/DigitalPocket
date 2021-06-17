/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uploder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import DBConnect.DBConnection;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 *
 * @author LENOVO
 */
@MultipartConfig
public class FileUpload extends HttpServlet {

    public static final String UPLOAD_DIR = "imagesDB";
    public String dbFileName = "";

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
            Part part = request.getPart("photo");
            String fileName = extractFileName(part);

            String applicationPath = getServletContext().getRealPath("");
            String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
            File fileUploadDirectory = new File(uploadPath);
            if (!fileUploadDirectory.exists()) {
                fileUploadDirectory.mkdirs();
            }
            String savePath = uploadPath + File.separator + fileName;
            String sRootPath = new File(savePath).getAbsolutePath();
            part.write(savePath + File.separator);

            out.print("FileSize : " + part.getSize() + "</br>"
                    + "File Root Path : " + sRootPath + "</br>"
                    + "save Path : " + savePath + "</br>"
                    + "application path : " + applicationPath + "</br>"
                    + "upload path : " + uploadPath);
            String type = fileName.substring(fileName.lastIndexOf("."));
            int size = (int) part.getSize() / (1024 * 1024);
            DBConnection db = new DBConnection();
            db.pstmt = db.con.prepareStatement("insert into documents(doc_id,doc_type,doc_size,doc_upload_time,doc_location,doc_filename,uid) values(?,?,?,now(),?,?,?)");
            db.pstmt.setString(1, "1");

            db.pstmt.setString(2, type);
            db.pstmt.setInt(3, size);
            db.pstmt.setString(4, sRootPath);
            db.pstmt.setString(5, fileName);
            db.pstmt.setInt(6, 18);
            int i = db.pstmt.executeUpdate();
            if (i > 0) {
                out.println("Sucess");
            }
        } catch (Exception e) {
            out.print(e.getMessage());
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

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
