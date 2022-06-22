<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page Needs
    ================================================== -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Contact | Agency Perfect</title>

    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content="">

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,600,700" rel="stylesheet">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

    <!-- Favicon
    ================================================== -->
    <link rel="apple-touch-icon" sizes="180x180" href="../../assets/img/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../assets/img/favicon.png">

    <!-- Stylesheets
    ================================================== -->
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

    <header id="masthead" class="site-header site-header-white">
        <nav id="primary-navigation" class="site-navigation">
            <div class="container">

                <div class="navbar-header">
                   
                    <a href="index.html" class="site-title"><span>Agency</span>Perfect</a>

                </div><!-- /.navbar-header -->

                <div class="collapse navbar-collapse" id="agency-navbar-collapse">

                 
                    <ul class="nav navbar-nav navbar-right">

                        <li class="active"><a href="index.jsp" data-toggle="dropdown">Inicio</a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Album<i class="fa fa-caret-down hidden-xs" aria-hidden="true"></i></a>

                            <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                              <li><a href="views/album/insertarAlbum.jsp">Insertar</a></li>
                              <li><a href="Editar.html">Editar</a></li>
                              <li><a href="blog.html">Listar</a></li>
                            </ul>

                        </li>

                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Artista<i class="fa fa-caret-down hidden-xs" aria-hidden="true"></i></a>

                            <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                              <li><a href="views/artista/insertarArtista.jsp">Insertar</a></li>
                              <li><a href="Editar.html">Editar</a></li>
                              <li><a href="blog.html">Listar</a></li>
                            </ul>

                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Genero<i class="fa fa-caret-down hidden-xs" aria-hidden="true"></i></a>

                            <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                              <li><a href="../genero/insertarGenero.jsp">Insertar</a></li>
                              <li><a href="views/genero/listarGenero.jsp">Listar</a></li>
                              <li><a href="blog.html">Editar</a></li>
                            </ul>


                </div>

            </div>   
        </nav><!-- /.site-navigation -->
    </header><!-- /#mastheaed -->

    <div id="hero" class="hero overlay subpage-hero contact-hero">
        <div class="hero-content">
            <div class="hero-text">
                <h1>Listar</h1>
            </div><!-- /.hero-text -->
        </div><!-- /.hero-content -->
    </div><!-- /.hero -->

    <main id="main" class="site-main">

        <form>
        <table class="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
                <th scope="col">fechaGrabacion</th>
                <th scope="col">duracionCancion</th>
                <th scope="col">Estado</th>
                <th scope="col">Acciones</th>
              </tr>
            </thead>

            <c:forEach var="cancionesList" items="${cancionesList}">
                <tr>
                    <td>${cancionesList.getIdCancion()}</td>
                    <td>${cancionesList.getNombreCancion()}</td>
                    <td>${cancionesList.getFechaGrabacion()}</td>
                    <td>${cancionesList.getDuracionCancion()}</td>

                    <c:if test="${cancionesList.getEstadoCancion() == true}">

                    <td>                                  
                        <span>Genero Activo</span>                              
                    </td>                           
                </c:if>

                <c:if test="${cancionesList.getEstadoCancion() == false}">
                <td>
                    <span>Genero Inactivo</span>
                </td> 
            </c:if> 

            <td>
            <c:if test="${cancionesList.getEstadoCancion() == true}">
                <a href="cancionesList.?accion=estadoCancion&idcancion.=${cancionesList.getIdCancion()}&estadoCancion=false"><button>Inactivar</button> </a>
</c:if>      

      <c:if test="${cancionesList.getEstadoCancion() == false}">
                <a href="cancionesList?accion=estadoCancion&idCancion=${cancionesList.getIdCancion()}&estadoCancion=false"><button>Activar</button></a>
</c:if>
</td>

        <td>
            <a href="cancionesList?accion=editar&idCancion=${cancionesList.getIdCancion()}"><button>Editar</button></a>
            <a href="cancionesList?accion=eliminar&idCancion${cancionesList.getIdCancion()}"><button>Eliminar</button> </a>
        </td>             
</td>
       </tr>
    </c:forEach>   
          </table>
        </form>
                  


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap-select.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>
    <script src="assets/js/jquery.countTo.min.js"></script>
    <script src="assets/js/jquery.shuffle.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
    <script src="assets/js/script.js"></script>
  
</body>
</html>