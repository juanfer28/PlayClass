<%-- 
    Document   : 03bienvenidda
    Created on : 20/09/2021, 8:29:38 p. m.
    Author     : Juanfer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon"= href="logoPlayClass.ico">
    <title>Bienvenida</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <div class="px-4 py-5 my-5 text-center">
        <img class="d-block mx-auto mb-1" src="logoPlayClass.png" alt="" width="100" height="100">
        <h1 class="display-5 fw-bold">¡Bienvenido! Carlos Hernandez</h1>
        <div class="col-lg-6 mx-auto">
          <p class="lead mb-4">Te queremos agradecer por haber escogido nuestra avanzada plataforma de cursos online, completamente Gamificada para regalarle a sus estudiantes la mas grata experiencia de aprendizaje.</p>
         
          <form action="creaciondeEscuelas.html" >
            <div class="form-floating mb-4">
              <input type="nombre" class="form-control" id="nombreAcademia" placeholder="nombreAcademia">
              <label for="nombreAcademia">Nombre de la Academia</label>
            </div>
            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">        
              <button type="submit" class="btn btn-primary btn-lg px-4 gap-3">Crear Academia</button>
              <button type="button" class="btn btn-outline-secondary btn-lg px-4">Saltar</button>
          </form>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script> 
</body>

</html>