﻿    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>首页</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/main1.css" rel="stylesheet">
	</head>
	<body>
<!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <!-- 导航栏 开始-->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Project</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">首页</a></li>
          <li><a href="admin.do?param=${sessionScope.user.id}">管理页面</a></li>
          <li><a href="#">退出</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
   <!-- 导航栏 结束-->
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>成功登录！</h1>
    </div>
    <table
						class="table table-bordered table-hover table-condensed table-full-width">
						<tr>
							<td width="90" class="success">用户名</td>
							<td width="150" >${sessionScope.user.userName}</td>
							<td width="90" class="success">密码</td>
							<td width="150" >${sessionScope.user.pwd}</td>
							<td width="90" class="success">性别</td>
							<td width="150" >${sessionScope.user.gender}</td>
							<td rowspan="2" width='120'><img src='users/user_32.png' width='100'></td>
						</tr>
						<tr>
							<td width="90" class="success">类型</td>
							<td width="150" >${sessionScope.user.category}</td>
							<td width="90" class="success">兴趣</td>
							<td width="150" colspan="3" >${sessionScope.user.interest}</td>
						</tr>
					</table>
  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">网站访问次数：</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>