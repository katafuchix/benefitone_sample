<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page">

<!--
	- $Id: courceDetailInput_CustomCoruce.jsp,v 1.2 2006/01/31 08:25:58 enokida Exp $
	- Copyright (C) 2005 Benefit One Inc. All rights reserved.
-->

<jsp:directive.page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J"/>

	<f:view>
		<link rel="stylesheet" href="../../css/style.css"/>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
			<title>
				コース新規作成 詳細情報登録
			</title>
		</head>
		<body>
			<h:form id="mainFrm">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:directive.include file="common/courseBasicNavigator.jsp" />
						</td>
					</tr>
					<tr>
						<td>
							<jsp:directive.include file="body/courceDetailInput_CustomCoruce.jsp" />
						</td>
					</tr>
					<tr>
						<td>
							<jsp:directive.include file="common/courseFooter.jsp"/>
						</td>
					</tr>
				</table>
			</h:form>
		</body>
	</f:view>
</html>
