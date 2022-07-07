
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <h2>Detail SiteClass: ${requestScope.name}</h2>
                        
                </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th> Last Name </th>
                                <th>Email</th>
                                <th>Control</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="row" items="${requestScope.listTrainee}">
                            <tr>
                                <td><c:out value="${row.id}"/></td>
                                <td><c:out value="${row.firstName}"/></td>
                                <td><c:out value="${row.lastName}"/></td>
                                <td><c:out value="${row.email}"/></td>
                                <td>
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
