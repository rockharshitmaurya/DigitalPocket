<%-- 
    Document   : resetpassword
    Created on : 26-May-2021, 12:41:16 am
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link rel="icon" href="../../images/android-icon-72x72.png">
    </head>
    <body>
        <div class="container">    
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">New Password</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                        <%String email=request.getParameter("email");%>
                        
                        <form id="loginform" class="form-horizontal" role="form" onclick="">

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control" name="password" value="" placeholder="New Password">                                        
                                <input id="email" type="hidden" value="<%=email%>">
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="cpassword" type="password" class="form-control" name="confirm password" placeholder="Re-Enter Password">
                            </div>
                            <div style="margin-top:10px" class="form-group">
                                <div class="col-sm-12 controls">
                                    <a onclick="resetlogic('password','cpassword','email')" id="btn-fblogin" href="#" class="btn btn-primary">Change Password</a>
                                </div>
                            </div>
                          
                        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
                        </form>     
                    </div>                     
                </div>  
            </div>
        </div>


        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script> 
    </body>
</html>
