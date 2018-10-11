<%-- 
    Document   : TipoCliente
    Created on : 27/03/2018, 11:01:03
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
        <h1>Tipo Cliente</h1>
        <a href="TipoCliente-Add.jsp">Novo</a></br>
        <a href="index.jsp">Páginas</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lista}" var="obj">
                <tr>
                    <td>${obj.codigo}</td>
                    <td>${obj.nome}</td>
                    <td><a href="TipoCliente-upd.jsp">Alterar</a>
                        <a href="TipoClienteWS?codigo=${obj.codigo}&nome=${obj.nome}" >Excluir</a>   
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
