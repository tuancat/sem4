
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row" style="text-align: center">
                    Ngưởi mượn sách: <c:out value="${user.fullName}"/>
                </div>
                <div class="row">
                    <form class="form-horizontal" action="/BookLibrary/BorrowBookServlet" method="POST">
                        <input type="hidden" value="<c:out value="${user.id}"/>" name="userid" id="userid"/>
                        <div class="form-group">
                            <label for="txtid" class="col-sm-2 control-label">Book:</label>
                            <div class="col-sm-10">
                                <select name="listBooks" id="listBooks" name="listBooks" autofocus> 
                                <c:forEach var="row" items="${requestScope.listBook}">
                                    <option value="<c:out value="${row.id}"/>"><c:out value="${row.title}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-warning btnSubmitDiem">Lưu lại</button>

                        </div>

                    </div>
                </form>
            </div>
        </div>

    </body>
</html>

