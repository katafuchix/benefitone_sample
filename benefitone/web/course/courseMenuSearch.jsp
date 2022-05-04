<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page">

<!--
	- $Id: courseMenuSearch.jsp,v 1.1 2006/01/31 10:54:01 enokida Exp $
	- Copyright (C) 2005 Benefit One Inc. All rights reserved.
-->

<jsp:directive.page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J"/>

	<f:view>
		<link rel="stylesheet" href="../../css/style.css"/>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
			<title>
				�R�[�X�ꗗ ����
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
							<jsp:directive.include file="body/courseMenuSearch.jsp" />
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
