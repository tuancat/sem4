<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
        <body>
            <div class="container-fluid">
                <div class="row">
                    <form class="form-horizontal" action="" method="POST" >
                        <div class="form-group">
                            <label for="txtTitle" class="col-sm-2 control-label">Firt Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txtFirstName" name="txtFirstName" value="<c:out value="${requestScope.currTrainee.firstName}"/> ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtAuthor" class="col-sm-2 control-label">Last Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="txtLastName" name="txtLastName" value="<c:out value="${requestScope.currTrainee.lastName}"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtDescription" class="col-sm-2 control-label">Email:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="txtEmail" name="txtEmail" value="<c:out value="${requestScope.currTrainee.email}"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="hidden" class="form-control" id="txtId" name="txtId" value="<c:out value="${requestScope.currTrainee.id}"/>">
                            <button type="submit" class="btn btn-default btnSubmitDiem">Lưu lại</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>