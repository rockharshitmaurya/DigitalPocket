<%-- 
    Document   : verifyemail
    Created on : 28-May-2021, 12:05:41 pm
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DBConnect.DBConnection" %>
<%@page errorPage="error" session="true"%>

<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        String otp = request.getParameter("uid");
        DBConnection db = new DBConnection();
        db.pstmt = db.con.prepareStatement("select email from email_verification where verification_code=?");
        db.pstmt.setString(1, otp);
        db.rst = db.pstmt.executeQuery();
        if (db.rst.next()) {
            String username = db.rst.getString("email");
            db.pstmt = db.con.prepareStatement("update login_master set status=? where email=?");
            db.pstmt.setInt(1, 1);
            db.pstmt.setString(2, username);
            int i = db.pstmt.executeUpdate();
            if (i > 0) {
                db.pstmt = db.con.prepareStatement("update email_verification set verification_time=now()");
                int j = db.pstmt.executeUpdate();
                if (j > 0) {
                    out.println("<h1>congratulations your account has been activated,</h1>");
                    String link = "index.html";
                    out.println("<h1><a href=" + link + ">Click Here To Login</a></h1>");
                } else {
                    out.println("cretion_time error");
                }
            } else {
               
                out.println("<h1>Error Inner !</h1>");
            }
        } else {
            out.println("<h1>Error Outer !</h1>");
            throw new Exception("Error");

        }
    %>
</body>

