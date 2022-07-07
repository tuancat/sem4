
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="row">
    <form class="form-horizontal" action="/BookLibrary/ListUserServlet" method="POST">
        <div class="form-group">
            <label for="txtid" class="col-sm-2 control-label">Id:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="ID" 
                       value="<c:out value="${user.id}"/>" disabled>
                <input type="hidden" id="txtid" name="txtid" value="<c:out value="${user.id}"/>" />
            </div>
        </div>
        <div class="form-group">
            <label for="txttitle" class="col-sm-2 control-label">Username:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtusername" name="txtusername" placeholder="Tên Ngưởi dùng" 
                       value="<c:out value="${user.userName}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="txtauthor" class="col-sm-2 control-label">Fullname:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtfullName" name="txtfullName" placeholder="Fullname"
                       value="<c:out value="${user.fullName}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="txtdesription" class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="txtpassword" name="txtpassword" 
                       value="<c:out value="${user.password}"/>">
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-warning btnSubmitDiem">Lưu lại</button>
                <button type="button" class="btn btn-danger btnSubmitDiem">Xoá</button>
            </div>
           
        </div>
    </form>
</div>
