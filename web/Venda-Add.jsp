<%-- 
    Document   : Venda-Add
    Created on : 06/04/2018, 11:57:36
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
        <h1>Venda</h1>
        <a href="Venda.jsp">Voltar</a>
        </br>
        <form action="VendaWS" method="POST">
            <label>Código:</label>
            <input type="text" name="txtcodigo">
            </br>
            <label>Data:</label>
            <input type="text" name="txtdata">
            </br>
            <label>Produto:</label>
            <input type="text" name="txtproduto">
            </br>
            <label>Quantidade:</label>
            <input type="text" name="txtquantidade">
            </br>
            <label>Valor Pago:</label>
            <input type="text" name="txtvalorpago">
            </br>
            <button type="submit">Gravar</button>
        </form>
    </body>
</html>
