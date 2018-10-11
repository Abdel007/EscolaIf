<%-- 
    Document   : Produto-Add
    Created on : 27/03/2018, 19:30:02
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
        <h1>Produto</h1>
        <a href="Produto.jsp">Voltar</a>
        </br>
        <form action="ProdutoWS" method="POST">
            <label>Código:</label>
            <input type="text" name="txtcodigo">
            </br>
            <label>Nome:</label>
            <input type="text" name="txtnome">
            </br>
            <label>Preço:</label>
            <input type="number" name="txtpreco">
            </br>
            <label>Tipo:</label>
            <input type="text" name="txttipo">
            </br>
            <button type="submit">Gravar</button>
        </form>
    </body>
</html>
