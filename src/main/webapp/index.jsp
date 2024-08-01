<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link href="bootstrap-5.2.3-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="styles.css">
    <title>Inicio de Sesión</title>
</head>
<body>
<div class="container">
    <header class="text-center my-4">
        <div>
            <img src="img/logoUtez.png" alt="Center Image" class="img-fluid">
        </div>
    </header>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card mt-5">
                <div class="card-header text-center">
                    <h3>Inicio de Sesión</h3>
                </div>
                <div class="card-body">
                    <form method="post" action="LoginServlet">
                    <div class="form-group mb-3">
                            <label for="email">Ingrese su usuario:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group mb-3">
                            <label for="password">Ingrese su contraseña:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="form-group mb-3">
                            <label for="category">Seleccione su categoría:</label>
                            <select class="form-control" id="category" name="category" required>
                                <option value="Alumno">1. Alumno</option>
                                <option value="Docente">2. Docente</option>
                                <option value="Administrador">3. Administrador</option>
                            </select>
                        </div>
                        <%
                            HttpSession sesion = request.getSession();
                            String mensaje = (String) sesion.getAttribute("mensaje");

                            if (mensaje != null) {
                        %>
                        <div class="alert alert-danger" role="alert">
                            <%= mensaje %>
                        </div>
                        <%
                                sesion.removeAttribute("mensaje");
                            }
                        %>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
