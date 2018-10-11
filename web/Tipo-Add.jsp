<%-- 
    Document   : Tipo-Add
    Created on : 21/03/2018, 10:38:38
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
        <h1>Tipo</h1>
        <a href="Tipo.jsp">Voltar</a>
        </br>
        <form action="TipoWS" method="POST">
            <label>Código:</label>
            <input type="text" name="txtcodigo">
            </br>
            <label>Nome:</label>
            <input type="text" name="txtnome">
            <button type="submit">Gravar</button>
        </form>
    </body>
</html>
