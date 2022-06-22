<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
    <li class="active"><a href="../index.jsp" data-toggle="dropdown">Inicio</a></li>
    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Cancion<i class="fa fa-caret-down hidden-xs" aria-hidden="true"></i></a>

        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
          <li><a href="">Insertar</a></li>
          <li><a href="Editar.html">Editar</a></li>
          <li><a href="cancion?accion=visualizar">Listar</a></li>
        </ul>
        </ul>

    </li>
    <div class="overlay">
        <form action="cancion" method="post">          
           <div class="con">
           <header class="head-form">
              <h2>Insertar Cancion</h2>
           </header>
           <br>
           <div class="field-set">
             
                 <span class="input-item">
                   <i class="fa fa-user-circle"></i>
                 </span>           
              <br>

              <span class="input-item">
                <i class="fa fa-key"></i>
               </span>
              <input type="text"  class="form-input" placeholder="nombreCancion" id="nombreCancion"  name="nombreCancion" required>

              <input type="date"  class="form-input" placeholder="fechaGrabacion" id="fechaGrabacion"  name="fechaGrabacion" required>

              <input type="text"  class="form-input" placeholder="duracionCancion" id="duracionCancion"  name="duracionCancion" required>
             
              <div class="inputBox">
               <input class="fa fa-eye" class="form-input" class="form-check-input" type="checkbox"  name="estadoGenero" id="estadoGenero"  placeholder="Estado"required>
               <br>
               <label class="fa fa-eye" class="form-input" class="form-check-label" for="estadoGenero">Activo</label>
             </div>
             
             <span>
                <i class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
             </span>          
            
             <br>
              <div class="submit"> <button type="submit" name="accion" value="add" >Registar</button></div>
           </div>
        </form>
        </div>
</body>
</html>