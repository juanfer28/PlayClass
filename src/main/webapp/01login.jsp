<%-- 
    Document   : 01login
    Created on : 20/09/2021, 7:56:32 p. m.
    Author     : Juanfer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar Sesión</title>
    <link rel="icon" href="logoPlayClass.ico">
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form>
    <img class="mb-1" src="logoPlayClass.png" alt="" width="100" height="100">
    <h1 class="h3 mb-2 fw-bold">PlayClass</h1>
    <h1 class="h3 mb-6 fw-normal">Por favor inicie sesión</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
      <label for="floatingInput">Correo Electrónico</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Contraseña</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        Crea tu Cuenta
        <a href="Inscribirse.html" class="link-primary">Aqui</a>
      </label>
    </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar sesión</button> 
      <a href="xxxxxxx">
    <button type="button" class="mt-3 mb-1 w-70 btn btn-outline-secondary">Recuperar Contraseña</button>
      </a>
    <p class="mt-2 mb-3 text-muted">2021</p>
  </form>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script> 
</body>

</html>