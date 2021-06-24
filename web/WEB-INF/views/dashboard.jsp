<%-- 
    Document   : dashboard
    Created on : 24-May-2021, 1:08:59 am
    Author     : LENOVO
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DBConnect.DBConnection" %>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>




<%
    HttpSession session_check = request.getSession(false);
    if (session_check != null && session_check.getAttribute("name") != null) {
//        String name = (String) session_check.getAttribute("name");
//        out.print("Hello, " + name + " Welcome to Profile");
    } else {
        out.print("Please login first");
//        response.sendRedirect("index.html");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <%@include file="header.jspf" %>  

    </head>
    <body>
        <div class="row overflow-hidden">
            <div class="col-md-3 ">
                <form method="POST" action="fileupload" enctype="multipart/form-data">
                    <table border="0">
                        <tr>
                            <td><input type="file" name="photo" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" id="data" value="Upload" class="form-control btn-success">
                            </td>
                        </tr>
                    </table>
                </form>
                <form action="fc/Logout">
                    <input type="submit" value="Logout">
                </form>
                <!--                 <div style="position:relative;">
                                <a class='btn btn-primary' href='javascript:;'>
                                        Choose File...
                                        <input type="file" style='position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";opacity:0;background-color:transparent;color:transparent;' name="file_source" size="40"  onchange='$("#upload-file-info").html($(this).val());'>
                                </a>
                                &nbsp;
                                <span class='label label-info' id="upload-file-info"></span>
                        </div>-->
            </div>

            <div class="col-md-9">
                <%
                    DBConnection db = new DBConnection();
                    db.pstmt = db.con.prepareStatement("select doc_type,doc_location,doc_filename from documents where"
                            + "(uid=(select uid from user_master where email=?))");
                    db.pstmt.setString(1, session_check.getAttribute("name").toString());
                    db.rst = db.pstmt.executeQuery();
                    while (db.rst.next()) {%>

                <!--<img src="images/android-icon-72x72.png" alt="alt" width="150" height="150"/>-->
                <embed src="<%= db.rst.getString("doc_location") + db.rst.getString("doc_filename")%>" width="220" style="padding: 15px"/>
                <a href="imagesDB/Appointment_slip (1).pdf" download>Download <%=db.rst.getString("doc_type")%></a>
                <% }%>

            </div>
        </div>
    </body>
</html>
