
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <button class="btn btn-primary" href="create-trainee" role="button" onclick="getDetailBook(0)">Thêm mới</button>
                </div>
                <div class="row">
                    <div class="row">
                        <div class="col-sm-6">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Title</th>
                                        <th>Control</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="row" items="${requestScope.listBook}">
                                    <tr onclick="getDetailBook(<c:out value="${row.id}"/>)" style="cursor: pointer">
                                        <td><c:out value="${row.id}"/></td>
                                        <td><c:out value="${row.title}"/></td>
                                        <td><c:out value="${row.author}"/></td>
                                        <td>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-sm-6" id="right-area">

                    </div>
                </div>


                </body>
                </html>
                <script>
                    
                    function getDetailBook(id) {
                        console.log("getDetailBook:" + id);
                        $.ajax({
                            url: "/BookLibrary?function=detail&id=" + id, 
                            success: function (result) {
                                $("#right-area").html(result);
                            }});
                    }
                    $(document).ready(function () {
//                        console.log("load script list-book");
//                        $.ajax({url: "/BookLibrary?id=1", success: function (result) {
//                                $("#right-area").html(result);
//                        }});
                    });
                </script>