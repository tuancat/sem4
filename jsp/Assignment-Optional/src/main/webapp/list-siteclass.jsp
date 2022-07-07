
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <a class="btn btn-primary" href="create-trainee" role="button">Thêm mới</a>
                </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                
                                <th>Control</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="row" items="${requestScope.listSiteClass}">
                            <tr>
                                <td><c:out value="${row.id}"/></td>
                                <td><c:out value="${row.name}"/></td>
                                
                                <td>
                                    <a class="btn btn-warning" href="detail-siteclass?id=<c:out value="${row.id}"/>" role="button">Detail</a>|||
                                    <a class="btn btn-warning" href="edit-trainee?id=<c:out value="${row.id}"/>" role="button">Edit</a>|||
                                    <a class="btn btn-danger" href="delete-trainee?id=<c:out value="${row.id}"/>" role="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
