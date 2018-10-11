<%-- 
    Document   : Tipo
    Created on : 21/03/2018, 10:41:45
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
        <h1>Tipo</h1>
        <a href="Tipo-Add.jsp">Novo</a></br>
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
                    <td><a href="tipo-Upd.jsp">Alterar</a>
                        <a href="TipoWS?codigo=${obj.codigo}">Excluir</a>   
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
