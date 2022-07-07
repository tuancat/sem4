<%-- 
    Document   : list-user
    Created on : Nov 29, 2019, 5:54:05 PM
    Author     : tuanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <button class="btn btn-primary" href="create-trainee" role="button" onclick="getDetailUser(0)">Thêm mới</button>
                </div>
                <div class="row">
                    <div class="row">
                        <div class="col-sm-6">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Username</th>
                                        <th>Fullname</th>
                                        <th>Control</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="row" items="${requestScope.listUser}">
                                    <tr onclick="getDetailUser(<c:out value="${row.id}"/>)" style="cursor: pointer">
                                        <td><c:out value="${row.id}"/></td>
                                        <td><c:out value="${row.userName}"/></td>
                                        <td><c:out value="${row.fullName}"/></td>
                                        <td>
                                            <a href="/BookLibrary/BorrowBookServlet?userid=<c:out value="${row.id}"/>">Mượn sách</a>||
                                            <a href="/BookLibrary/BorrowBookServlet?userid=<c:out value="${row.id}"/>&function=history">Lịch sử</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm-6" id="right-area">

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
<script>
    function getDetailUser(id) {
        $.ajax({
            url: "/BookLibrary/ListUserServlet?function=detail&id=" + id,
            success: function (result) {
                $("#right-area").html(result);
            }});
    }
</script>