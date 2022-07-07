
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="row">
    <form class="form-horizontal" action="/BookLibrary/ListBookServlet" method="POST">
        <div class="form-group">
            <label for="txtid" class="col-sm-2 control-label">Id:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="ID" 
                       value="<c:out value="${book.id}"/>" disabled>
                <input type="hidden" id="txtid" name="txtid" value="<c:out value="${book.id}"/>" />
            </div>
        </div>
        <div class="form-group">
            <label for="txttitle" class="col-sm-2 control-label">Tên Sách:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txttitle" name="txttitle" placeholder="Tên sách" 
                       value="<c:out value="${book.title}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="txtauthor" class="col-sm-2 control-label">Tác giả:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtauthor" name="txtauthor" placeholder="Tác giả"
                       value="<c:out value="${book.author}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="txtdesription" class="col-sm-2 control-label">Miêu tả:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtdesription" name="txtdesription" placeholder="Miêu tả"
                       value="<c:out value="${book.description}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="txturl" class="col-sm-2 control-label">Link Download:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txturl" name="txturl" placeholder="Miêu tả"
                       value="<c:out value="${book.url}"/>">
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
