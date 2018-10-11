<%-- 
    Document   : TipoCliente-Add
    Created on : 27/03/2018, 11:09:00
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
        <h1>Tipo Cliente</h1>
        <a href="TipoCliente.jsp">Voltar</a></br>
        <form action="TipoClienteWS" method="POST">
            <label>Código:</label>
            <input type="text" name="txtcodigo">
            </br>
            <label>Nome:</label>
            <input type="text" name="txtnome">
            <button type="submit">Gravar</button>
        </form>
    </body>
</html>
