<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/quan-tri/nguoi-dung/them-moi/luu" var="addUserAction"/>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
    <a href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/them-moi?lang=en">Login (English)</a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/quan-tri/nguoi-dung/them-moi?lang=vi">Login (Vietnamese)</a>
</div>

<form method="post" action="">
    <table>
        <tr>
            <td>
                <strong>
                    <spring:message code="label.userName" />
                </strong>
            </td>
            <td><input name="userName" /></td>
        </tr>
        <tr>
            <td>
                <strong>
                    <spring:message    code="label.password" />
                </strong>
            </td>
            <td><input name="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <spring:message code="label.submit" var="labelSubmit"></spring:message>
                <input type="submit" value="${labelSubmit}" />
            </td>
        </tr>
    </table>
</form>