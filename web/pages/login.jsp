<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*"%>
<html>
<head>
    <title>Title</title>
    <%@include file="./include/headInclude.jsp"%>
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>登&nbsp;&nbsp;录</strong></h1>
                    <div class="description">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <!--<div class="form-top">
                        &lt;!&ndash;<div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>&ndash;&gt;
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>-->
                    <div class="form-bottom">
                        <form role="form" action="" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">点击登录</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


    <!-- Javascript -->
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.backstretch.min.js"></script>
    <script src="../js/scripts.js"></script>

    <!--[if lt IE 10]>
    <script src="../js/placeholder.js"></script>
    <![endif]-->
</body>
</html>
