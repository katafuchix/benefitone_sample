<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page">
	
<jsp:directive.page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J"/>
	<Script src="../js/Script.js" language="JavaScript" >
		<!--
		-->
	</Script>
	<TABLE class="Header" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<TBODY>
			<TR>
				<TD vAlign="center" nowrap="nowrap" width="1%">
					<IMG height="32" src="../img/pp.gif" width="32" align="absMiddle" />
				</TD>
				<TD class="Title" vAlign="center" nowrap="nowrap" align="middle">コースメニュー</TD>
				<TD vAlign="center" nowrap="nowrap" width="1%">
					<h:outputText value="ユーザ: #{facesContext.externalContext.userPrincipal.name}"/>
					<h:commandButton value="ログアウト" action="#{logoutBean.logout}" immediate="true"/>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR />
</html>
