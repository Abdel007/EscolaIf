<%-- 
    Document   : Produto
    Created on : 27/03/2018, 19:28:58
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
        <h1>Produto</h1>
        <a href="Produto-Add.jsp">Novo</a></br>
        <a href="index.jsp">Páginas</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Tipo</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista}" var="obj"> 
                <tr>
                    <td>${obj.codigo}</td>
                    <td>${obj.nome}</td>
                    <td>${obj.preco}</td>
                    <td>${obj.tipo.nome}</td>
                    <td><a href="Produto-upd.jsp">Alterar</a>
                        <a href="ProdutoWS?codigo=${obj.codigo}&nome=${obj.nome}&preco=${obj.preco}&tipo=${obj.tipo.nome}" >Excluir</a>  
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
