
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <h4>Lịch sử mượn sách của: <c:out value="${user.fullName}"/></h4>
                </div>
                <div class="row">
                    <div class="row">
                        <div class="col-sm-6">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Sach</th>
                                        <th>Thoi gian</th>
                                        <th>Control</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="row" items="${requestScope.listBorrowModel}">
                                    <tr>
                                        <c:set var = "currTimefmt" value = "${row.currTime}" />
                                        <td><c:out value="${row.id}"/></td>
                                        <td><c:out value="${row.book.title}"/></td>
                                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${currTimefmt}" /></td>
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
