<%--
  Created by IntelliJ IDEA.
  User: maksym
  Date: 01.12.18
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); response.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Book</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">
        <form:input path="title"/>
        <form:errors path="title"/>
        <%--<form:input path="authors.id"/>--%>
        <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/>
        <form:textarea path="description"/>
        <form:errors path="description"/>
        <form:input path="strPublishDate" type="datetime-local"/>
        <form:errors path="strPublishDate"/>
        <input type="submit" value="Save book"/>
    </form:form>
</body>
</html>
