<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


    <div class="login-container">
        <div class="login-image">
            <img src="${pageContext.request.contextPath}/images/vali.png" alt="Login Image">
        </div>
        <div class="login-form">
            <h2>Sign in</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <i class="fa fa-user"></i>
                    <input type="text" id="login-name" name="username" placeholder="Your Name" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock"></i>
                    <input type="password" id="login-password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group checkbox-group">
                    <input type="checkbox" id="remember" name="remember">
                    <label for="remember">Remember me</label>
                </div>
                <div class="form-group">
                    <button type="submit" class="button">Log in</button>
                </div>
            </form>
            <p><a href="${pageContext.request.contextPath}/signup.jsp">Create an account</a></p>
            <p>Or login with</p>
            <div class="social-login">
                <a href="#">Facebook</a>
                <a href="#">Twitter</a>
                <a href="#">Google</a>
            </div>
        </div>
    </div>


</body>
</html>
