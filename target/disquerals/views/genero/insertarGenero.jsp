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
    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Genero<i class="fa fa-caret-down hidden-xs" aria-hidden="true"></i></a>

        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
          <li><a href="genero?accion=registrar">Insertar</a></li>
          <li><a href="genero?accion=editar">Editar</a></li>
          <li><a href="genero?accion=visualizar">Listar</a></li>
        </ul>
        </ul>

    </li>
    <div class="overlay">
        <form action="genero" method="post">          
           <div class="con">
           <header class="head-form">
              <h2>Insertar Genero</h2>
           </header>
           <br>
           <div class="field-set">
            <label class="form-input" for="exampleFormControlInput1">Nombre Genero</label>
            <div class="inputBox">
                <input class="form-input" class="form-control" name="nombreGenero" id="nombreGenero" type="text" placeholder="Nombre"required>
            </div>
              <br>
              <br>
              <div class="inputBox">
               <input class="fa fa-eye" class="form-input" class="form-check-input" type="checkbox"  name="estadoGenero" id="estadoGenero"  placeholder="Estado"required>
               <br>
               <label class="fa fa-eye" class="form-input" class="form-check-label" for="estadoGenero">Activo</label>
             </div>
              <br>
              <div class="submit"  class="inputBox"> 
               <button type="submit" name="accion" value="add">Registar</button>
            </div>
           </div>
        </form>
        </div>
</body>
</html>