<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar usuario</title>
</head>
<body>
<form method="post" action="sign_in">
    <label>Ingrese su nombre: </label>
    <input type="text" name="first_name" >
    <br>
    <label>Ingrese su apellido paterno: </label>
    <input type="text" name="last_nameP" >
    <br>
    <label>Ingrese su apellido materno: </label>
    <input type="text" name="last_nameM" >
    <br>
    <label>Ingrese su correo: </label>
    <input type="email" name="email" >
    <br>
    <label>Ingrese su contraseña: </label>
    <input type="password" name="password" >
    <br>
    <label>Ingrese su contraseña nuevamente: </label>
    <input type="password" name="password" >
    <br>
    <label>Ingrese el Rol: </label>
    <select id="id_user_type" name="id_user_type">
      <option value="1">Administrador</option>
      <option value="2">Docente</option>
      <option value="3">Alumno</option>
    </select>
    <br>
    <label>Ingrese el grupo al que pertenecera: </label>
    <select id="id_grupo" name="id_grupo">
        <option value="1">Ninguno</option>
        <option value="2">1°A</option>
        <option value="3">1°B</option>
        <option value="4">1°C</option>
        <option value="5">1°D</option>
        <option value="6">1°E</option>
    </select>
    <br>

    <input type="submit" value="Registrarse">
</form>
</body>
</html>

