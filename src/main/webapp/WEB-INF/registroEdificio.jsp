<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Edificios</title>
</head>
<body>
<form method="post" action="manage_building">
    <label>Nombre del Edificio: </label>
    <input type="text" name="building_name" required>
    <br>
    <input type="submit" value="Agregar Edificio">
</form>

<!-- Listado de Edificios -->
<h2>Listado de Edificios</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <!-- Aquí se itera sobre la lista de edificios obtenida del servidor -->
    <c:forEach var="building" items="${buildings}">
        <tr>
            <td>${building.id}</td>
            <td>${building.name}</td>
            <td>
                <!-- Botón para actualizar -->
                <form method="post" action="update_building" style="display:inline;">
                    <input type="hidden" name="building_id" value="${building.id}">
                    <input type="text" name="new_building_name" placeholder="Nuevo nombre">
                    <input type="submit" value="Actualizar">
                </form>

                <!-- Botón para eliminar -->
                <form method="post" action="delete_building" style="display:inline;">
                    <input type="hidden" name="building_id" value="${building.id}">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
