<%-- 
    Document   : Cliente
    Created on : 08/04/2018, 16:32:01
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
        <h1>Cliente</h1>
        <a href="Cliente-Add.jsp">Novo</a></br>
        <a href="index.jsp">Páginas</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>Tipo Cliente</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lista}" var="obj"> 
                <tr>
                    <td>${obj.codigo}</td>
                    <td>${obj.nome}</td>
                    <td>${obj.tipocliente.nome}</td>
                    <td><a href="Cliente-upd.jsp">Alterar</a>
                        <a href="ClienteWS?codigo=${obj.codigo}&nome=${obj.nome}&tipocliente=${obj.tipocliente.nome}" >Excluir</a>    
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
