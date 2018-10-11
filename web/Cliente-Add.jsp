<%-- 
    Document   : Cliente-Add
    Created on : 08/04/2018, 16:32:21
    Author     : Lucas Abdel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vendinha do zé</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Cliente</h1>
        <a href="Cliente.jsp">Voltar</a>
        </br>
        <form action="ClienteWS" method="POST">
            <label>Código:</label>
            <input type="text" name="txtcodigo">
            </br>
            <label>Nome:</label>
            <input type="text" name="txtnome">
            </br>
            <label>Tipo Cliente:</label>
            <input type="text" name="txttipocliente">
            </br>
            <button type="submit">Gravar</button>
        </form>
    </body>
</html>
