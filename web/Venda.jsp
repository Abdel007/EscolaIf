<%-- 
    Document   : Venda
    Created on : 06/04/2018, 11:57:10
    Author     : Lucas Abdel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>vendinha do ze</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Venda</h1>
        <a href="Venda-Add.jsp">Novo</a></br>
        <a href="index.jsp">Páginas</a>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Data</th>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Valor Pago</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lista}" var="obj"> 
                <tr>
                    <td>${obj.codigo}</td>
                    <td>${obj.data}</td>
                    <td>${obj.produto.nome}</td>
                    <td>${obj.quantidade}</td>
                    <td>${obj.valorpago}</td>
                    <td><a href="Venda-upd.jsp">Alterar</a>
                        <a href="VendaWS?codigo=${obj.codigo}&data=${obj.data}&produto=${obj.produto.nome}&quantidade=${obj.quantidade}&valorpago=${obj.valorpago}" >Excluir</a>  
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
