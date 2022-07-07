 <%-- 
    Document   : hit-counter
    Created on : Sep 14, 2016, 11:55:39 AM
    Author     : TuanCNH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
    Integer hitsCount = 
      (Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 ){
       /* First visit */
       out.println("Welcome to my website!");
       hitsCount = 1;
    }else{
       /* return visit */
       out.println("Welcome back to my website!");
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>
<p>Total number of visits: <%= hitsCount%></p>