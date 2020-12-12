
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form action="/authorization" method="post">
        <label>Username </label> <input type="text" name="username"><br>
        <label>Password </label> <input type="password" name="password"><br>
        <input type="submit" value="Увійти">
    </form>
</body>
</html>
