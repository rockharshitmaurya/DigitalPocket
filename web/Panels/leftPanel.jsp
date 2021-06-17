
<%@page import="ActionLogic.Business"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="Business.*" %>--%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8" />

    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>e-Pocket</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet" type="text/css"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="//d3js.org/d3.v3.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.css" />
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link href="assets/css/demo.css" rel="stylesheet" type="text/css"/>
</head>

<body>

    <div class="wrapper">
        <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-5.jpg">


            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="" class="simple-text">
                        e-Pocket
                    </a>
                </div>

                <ul class="nav">
                    <li class="active">
                        <a href="DashboardPage">
                            <i class="pe-7s-graph"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    
                    <li class="active">
                        <a href="ProfilePage">
                            <i class="pe-7s-user"></i>
                            <p>User Profile</p>
                        </a>
                    </li>
                    <li class="active">
                        
                        <a href="DocumentPage">
                            <i class="pe-7s-notebook    "></i>
                            <p>Document List</p>
                        </a>
                    </li>
                    <li class="active">
                        <a href="NotificationPage">
                            <i class="pe-7s-bell"></i>
                            <p>Notification</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>