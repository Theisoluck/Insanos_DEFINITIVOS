<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservas UTEZ</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<!--CABECERA-->
<div class="container">
    <header class="header">
        <div class="logo">
            <img src="img/logo.png" alt="Logo" class="log">
        </div>
        <div class="center-image">
            <img src="img/logoUtez.png" alt="Center Image">
        </div>
        <!--BOTON CERRAR SESIÓN-->
        <div class="btnOut">
            <button class="boton">Cerrar sesión <i class="bi bi-box-arrow-right" id="goOut"></i></button>
        </div>
    </header>
    <!--MENU DESPLEGABLE-->
    <aside class="sidebar">
        <div class="barra-lateral mini-barra-lateral">
            <div class="nombre-pagina">
                <ion-icon name="menu-outline" id="menu"></ion-icon>
                <span>Menú</span>
            </div>
            <nav class="navegacion">
                <li>
                    <a href="index.html">
                        <ion-icon name="person"></ion-icon>
                        <span>Usuarios</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <ion-icon name="today"></ion-icon>
                        <span>Reservas</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <ion-icon name="calendar"></ion-icon>
                        <span>Horarios</span>
                    </a>
                </li>
                <li>
                    <a href="registroEdificio.jsp">
                        <ion-icon name="business"></ion-icon>
                        <span>Edificios</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <ion-icon name="easel"></ion-icon>
                        <span>Espacios</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <ion-icon name="attach"></ion-icon>
                        <span>Historial</span>
                    </a>
                </li>
            </nav>
        </div>
    </aside>
    <div class="contenido">
        <div class="title">
            <h3 class="titulo">Gestión de Usuarios</h3>
        </div>
        <main class="content">
            <div class="registros">
                <div class="table-header" id="table_header">
                    <button type="button" class="btnUser" data-toggle="modal" data-target="#staticModal"><i
                            class="bi bi-plus"></i>Crear nuevo
                    </button>
                    <button class="btnUser"><i class="bi bi-box-arrow-up"></i>Subir usuarios</button>
                    <select name="drop-down" id="drop-down">
                        <option value="" selected>Estudiante</option>
                        <option value="">Docente</option>
                        <option value="">Administrador</option>
                    </select>
                </div>
                <table class="tabla" id="userTable">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Correo</th>
                        <th>Operaciones</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <div class="pie_tabla">
                    <p>Páginas</p>
                </div>
            </div>
        </main>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="staticModal" tabindex="-1" role="dialog" aria-labelledby="staticModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticModalLabel">Registro de Usuarios</h5>
                <button type="button" class="close" id="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Aquí va el contenido del formulario -->
                <form method="post" action="sign_in">
                    <div class="form-group">
                        <label>Ingrese su nombre: </label>
                        <input type="text" name="first_name" class="form-control" placeholder="Ingresar nombre">
                    </div>
                    <div class="form-group">
                        <label>Apellido Paterno: </label>
                        <input type="text" name="last_nameP" class="form-control"
                               placeholder="Ingrese apellido paterno">
                    </div>
                    <div class="form-group">
                        <label>Apellido Materno: </label>
                        <input type="text" name="last_nameM" class="form-control"
                               placeholder="Ingrese apellido materno">
                    </div>
                    <div class="form-group">
                        <label>Correo:</label>
                        <input type="email" name="email" class="form-control" placeholder="Ingrese correo">
                    </div>
                    <div class="form-group">
                        <label>Contraseña:</label>
                        <input type="password" name="password" class="form-control" placeholder="Ingrese contraseña">
                    </div>
                    <div class="form-group">
                        <label>Repetir contraseña:</label>
                        <input type="password" name="password" class="form-control" placeholder="Ingrese contraseña">
                    </div>
                    <div class="form-group">
                        <label>Tipo de Usuario: </label>
                        <select id="id_user_type" name="id_user_type" class="form-control">
                            <option value="1">Administrador</option>
                            <option value="2">Docente</option>
                            <option value="3">Alumno</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Ingrese el grupo al que pertenecera: </label>
                        <select id="id_grupo" name="id_grupo" class="form-control">
                            <option value="1">No aplica</option>
                            <option value="2">1°A</option>
                            <option value="3">1°B</option>
                            <option value="4">1°C</option>
                            <option value="5">1°D</option>
                            <option value="6">1°E</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--IMPORTACIONES-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="js/bootstrap.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
