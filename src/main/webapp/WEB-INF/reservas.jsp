<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset='utf-8' />
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.js'></script>
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/css/bootstrap-datepicker.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/js/bootstrap-datepicker.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/locales/es.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
  <link rel="stylesheet" href="css/bootstrapReservas.css">
  
</head>
<body>
  <header class="cabecera">
      <div class="logo">
        <img src="img/logo.png" alt="Logo" class="log">
    </div>
    <div class="center-image">
        <img src="img/logoUtez.png" alt="Center Image">
    </div>
    <!--BOTON CERRAR SESIÓN-->
    <a href="index.html">
    <div class="btnOut">
        <button class="boton">Cerrar sesión <i class="bi bi-box-arrow-right" id="goOut"></i></button>
    </div>
    </a>
    </div>
</header>
<!---->
<div class="main">
  <div class="barra-lateral mini-barra-lateral">
    <div class="nombre-pagina">
      <ion-icon name="menu-outline" id="menu"></ion-icon>
      <span>Menú</span>
  </div>
  <nav class="navegacion">
      <li>
          <a href="bienvenido.jsp">
              <ion-icon name="person"></ion-icon>
              <span>Usuarios</span>
          </a>
      </li>
      <li>
          <a href="reservas.jsp">
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
          <a href="">
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
<div id="calendar-container">
  <div id='calendar'></div>
</div>
</div>
  <div class="modal fade" id="reservationModal" tabindex="-1" aria-labelledby="reservationModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="reservationModalLabel">Reserva de Aula</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form id="reservationForm">
            <div class="mb-3">
              <label for="reservationDate" class="form-label">Fecha</label>
              <div id="reservationDate" class="form-control-plaintext"></div>
            </div>
            <div class="mb-3">
              <label for="startTime" class="form-label">Hora de inicio</label>
              <div id="startTime" class="form-control-plaintext"></div>
            </div>
            <div class="mb-3">
              <label for="endTimeSelect" class="form-label">Hora de fin</label>
              <select id="endTimeSelect" class="form-select"></select>
            </div>
            <div class="mb-3">
              <label for="title" class="form-label">Título</label>
              <input type="text" class="form-control" id="title" maxlength="35">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
          <button type="button" class="btn btn-primary" id="saveReservation">Guardar</button>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="viewReservationModal" tabindex="-1" aria-labelledby="viewReservationModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="viewReservationModalLabel">Información de la Reserva</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p><strong>Título:</strong> <span id="viewTitle"></span></p>
                <p><strong>Fecha:</strong> <span id="viewDate"></span></p>
                <p><strong>Hora de inicio:</strong> <span id="viewStart"></span></p>
                <p><strong>Hora de fin:</strong> <span id="viewEnd"></span></p>
            </div>
            <div class="modal-footer justify-content-start">
                <button type="button" class="btn btn-link">
                    <i class="bi bi-pencil-square"></i>
                </button>
                <button type="button" class="btn btn-link">
                    <i class="bi bi-trash"></i>
                </button>
                <button type="button" class="btn btn-secondary ms-auto" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
  <div class="modal fade" id="datePickerModal" tabindex="-1" aria-labelledby="datePickerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="datePickerModalLabel">Seleccionar Fecha</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="input-group date" id="datepicker">
            <input type="text" class="form-control">
            <span class="input-group-append">
              <span class="input-group-text bg-light d-block">
                <i class="fa fa-calendar"></i>
              </span>
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<!--IMPORTACIONES-->

<script src="js/bootstrap.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</html>