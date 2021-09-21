<%-- 
    Document   : 02inscribirse
    Created on : 20/09/2021, 8:22:23 p. m.
    Author     : Juanfer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon"= href="logoPlayClass.ico">
    <title>Crear Cuenta</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
  
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action="Bienvenida%20y%20preguntar%20nombre%20de%20la%20academia.html">
    <img class="mb-1" src="logoPlayClass.png" alt="" width="100" height="100">
    <h1 class="h3 mb-2 fw-bold">PlayClass</h1>
    <h1 class="h3 mb-6 fw-normal">Crea tu Cuenta</h1>

    <div class="form-floating mb-3">
      <input type="nombre" class="form-control" id="nombre" placeholder="juan fernando">
      <label for="nombre">Nombre Completo</label>
    </div>
    <div class="form-floating mb-3">
        <input type="email" class="form-control" id="correo" placeholder="name@example.com">
        <label for="correo">Correo Electrónico</label>
      </div>
    <div class="form-floating mb-3">
      <input type="password" class="form-control" id="contrasena" placeholder="Password">
      <label for="contrasena">Contraseña</label>
    </div>
    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="contrasena2" placeholder="Password">
        <label for="contrasena2">Confirmar Contraseña</label>
      </div>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Acepto  <a href="#" class="link-primary"> Términos de Servicio</a> y <a href="#" class="link-primary">Políticas de privacidad</a>
        </label>
      </div>
    </div>
      <button class="w-100 btn btn-lg btn-primary" type="submit">Crear Cuenta</button>
    <a href="Definifivo%20Login.html">
      <button type="button" class="mt-3 mb-1 w-70 btn btn-outline-secondary">Volver a iniciar Sesión</button>
    </a>
    <p class="mt-2 mb-3 text-muted">2021</p>
  </form>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script> 
</body>

</html>