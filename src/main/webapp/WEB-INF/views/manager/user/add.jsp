<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/quan-tri/nguoi-dung/them-moi/luu" var="addUserAction"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            Language: <a href="?lang=en_US">English</a> - <a href="?lang=vi_VN">Viet Nam</a> - <a href="?lang=ja_JP">日本語</a>
            <h2>
                <spring:message code="hello"/>
            </h2>
            Locale: ${pageContext.response.locale}
            </body>
            <div class="card">
                <form class="form-horizontal" action="${addUserAction}" method="post" enctype="multipart/form-data">
                    <input type="text" class="form-control" name="username">
                    <input type="text" class="form-control" name="password">
                    <button type="submit">OK</button>
                </form>
                <form:form id="myform" action="${addUserAction}" method="post" modelAttribute="user">
                    <table>
                        <tr>
                            <td>User Name:</td>
                            <td><form:input path="username" cssClass="form-control"/>
                                <form:errors path="username" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><form:password path="password" cssClass="form-control"/>
                                <form:errors path="password" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><form:input path="email" cssClass="form-control"/>
                                <form:errors path="email" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit">OK</button>
                            </td>
                        </tr>
                    </table>
                </form:form>


            </div>
        </div>
    </div>
</div>