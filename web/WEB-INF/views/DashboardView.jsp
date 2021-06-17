<%-- 
    Document   : DashboardView
    Created on : 16-Jun-2021, 10:50:18 am
    Author     : LENOVO
--%>
<%@include file="../../Panels/leftPanel.jsp" %>
        <div class="main-panel">
            <nav class="navbar navbar-default navbar-fixed">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="">Dashboard</a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-left">
                            <li>
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-dashboard"></i>
                                </a>
                            </li>
                        </ul>
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <%
                               String     name = (String)session.getAttribute("currentUser");
                                %>
                                <a href="">
                                    Logged In as <%= name %>
                                </a>
                            </li>
                            <li>
                                <% name=null; %>
                                <a href="LoginPage">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title">Users Behavior</h4>

                                </div>
                                <div id="cal-heatmap"></div>
                                <script type="text/javascript">
                                    var cal = new CalHeatMap();
                                    cal.init({});
                                </script>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title" style="font-weight: bold;">Documents Count</h4>
                                    <canvas id="myChart" style="width:50%;max-width:430px"></canvas>
                                    <script>
                                        var xValues = ["PDF", "MsWord", "Images", "Zip", "Audio & Video"];
                                        var yValues = [4, 5, 11, 3, 6];
                                        var barColors = [
                                            "#b91d47",
                                            "#00aba9",
                                            "#2b5797",
                                            "#e8c3b9",
                                            "#1e7145",
                                            "#3e9743"
                                        ];
                                        new Chart("myChart", {
                                            type: "pie",
                                            data: {
                                                labels: xValues,
                                                datasets: [{
                                                    backgroundColor: barColors,
                                                    data: yValues
                                                }]
                                            },
                                            options: {
                                                title: {
                                                    display: false,
                                                }
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title" style="font-weight: bold;">Document View</h4>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>               
            </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="DashboardPage">
                                    Home
                                </a>
                            </li>

                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>document.write(new Date().getFullYear())</script> <a href="/ep">e-Pocket</a>
                    </p>
                </div>
            </footer>

        </div>
    </div>
    <%@include file="../../Panels/bottomPanel.jsp" %>
