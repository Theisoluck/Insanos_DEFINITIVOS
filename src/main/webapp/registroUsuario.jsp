<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar usuario</title>
</head>
<body>
<form method="post" action="sign_in">
    <label>Ingrese su nombre de usuario: </label>
    <input type="text" name="user_name" >
    <br>
    <label>Ingrese su contraseña: </label>
    <input type="password" name="pass1" >
    <br>
    <label>Ingrese su contraseña nuevamente: </label>
    <input type="password" name="pass2" >
    <br>
    <label>Ingrese su correo: </label>
    <input type="email" name="email" >
    <br>
    <input type="submit" value="Registrarse">
</form>
</body>
</html>
