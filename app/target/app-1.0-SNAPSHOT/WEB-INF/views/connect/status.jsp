<%--
  Created by IntelliJ IDEA.
  User: amit
  Date: 19/6/16
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:social="http://spring.io/springsocial"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorator="layout">
<head>
    <title>Spring Social Showcase</title>
    <link rel="stylesheet" th:href="@{/resources/page.css}" type="text/css" media="screen"/>
    <link rel="stylesheet" th:href="@{/resources/form.css}" type="text/css" media="screen"/>
    <link rel="stylesheet" th:href="@{/resources/messages/messages.css}" type="text/css" media="screen"/>
</head>
<body>
<div id="header">
    <h1><a th:href="@{/}">Spring Social Showcase</a></h1>
</div>

<div id="leftNav">
    Left nav menu
</div>

<div id="content" layout:fragment="content">
    <h3>Your Connections</h3>

    <div class="accountConnection" th:each="providerId : ${providerIds}">
        <h4><img th:src="@{# {${providerId} + '.icon'}}" width="36" height="36" /><span th:text="# {${providerId}
        + '.displayName'}">provider name</span></h4>
        <p>
 				<span th:if="$ { !# lists.isEmpty(connectionMap[__${providerId}__])}">
					You are connected to <span th:text="# { $ {providerId} + '.displayName'}">provider name</span> as
                    <%--<span th:text="${ connectionMap[ __${ providerId }__ ][0].displayName}">user display name</span>.--%>
				</span>
				<span th:if="$ {#lists.isEmpty(connectionMap[__${providerId}__])}">
					You are not yet connected to <span th:text="# {${providerId} + '.displayName'}">provider name</span>.
				</span>
            Click <a th:href="@{'/connect/' + ${ providerId}}">here</a> to manage your <span th:text="# { ${ providerId} + '.displayName'}">
            provider name
        </span> connection.
        </p>
    </div>
</div>
</body>
</html>