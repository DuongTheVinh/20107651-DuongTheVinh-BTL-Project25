<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


    <div class="signup-container">
        <div class="signup-form">
            <h2>Sign up</h2>
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="form-group">
                    <i class="fa fa-user"></i>
                    <input type="text" id="name" name="username" placeholder="Your Username" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-user"></i>
                    <input type="text" id="fullName" name="fullName" placeholder="Your Full Name" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope"></i>
                    <input type="email" id="email" name="email" placeholder="Your Email" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-home"></i>
                    <input type="text" id="address" name="address" placeholder="Your Address" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-phone"></i>
                    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Your Phone Number" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock"></i>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock"></i>
                    <input type="password" id="confirm-password" name="confirm-password" placeholder="Repeat your password" required>
                </div>
                <div class="form-group checkbox-group terms">
                    <input type="checkbox" id="terms" name="terms" required>
                    <label for="terms">I agree all statements in <a href="#">Terms of service</a></label>
                </div>
                <div class="form-group">
                    <button type="submit">Register</button>
                </div>
            </form>
            <p><a href="${pageContext.request.contextPath}/login.jsp">I am already member</a></p>
        </div>
        <div class="signup-image">
            <img src="${pageContext.request.contextPath}/images/balo.png" alt="Signup Image">
        </div>
    </div>


</body>
</html>
