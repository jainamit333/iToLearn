<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	  xmlns:social="http://spring.io/springsocial"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	  layout:decorator="layout">
	<head>
		<title>Spring Social Showcase</title>
		<link rel="stylesheet" th:href="@{/resources/page.css}" type="text/css" media="screen"></link>
		<link rel="stylesheet" th:href="@{/resources/form.css}" type="text/css" media="screen"></link>
		<link rel="stylesheet" th:href="@{/resources/messages/messages.css}" type="text/css" media="screen"></link>
	</head>
	<body>
		<div id="header">
			<h1><a th:href="@{/}">Spring Social Showcase</a></h1>
		</div>
		
		<div id="leftNav">
			Left nav menu
		</div>
		
		<div id="content" layout:fragment="content">
			<h3>Your Facebook Photo Album: <span th:text="${album.name}">album name</span></h3>
				
			<span th:each="photo : ${photos}">
				<img th:src="${photo.images[0].source}" align="middle"/>
			</span>
		</div>
	</body>
</html>
