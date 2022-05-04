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
		<TR>
			<TD>
				<TABLE cellspacing="0" cellpadding="0" border="0" height="100%" width="100%">
					<TR>
						<TD valign="middle" height="1%">
							<TABLE class="Header" cellspacing="0" cellpadding="0" border="0" width="100%">
								<TR>
									<TD nowrap="nowrap" valign="middle" width="1%"></TD>
									<TD nowrap="nowrap"><em>PPシステム</em></TD>
									<TD valign="middle">
										<TABLE class="Menu" border="0" width="100%">
											<TR class="Header2">
												<TD nowrap="nowrap" COLSPAN="2">一覧検索・新規作成</TD>
												<TD nowrap="nowrap">コース情報メンテナンス</TD>
												<TD nowrap="nowrap">マスタメンテナンス</TD>
											</TR>
											<TR>
												<TD nowrap="nowrap">
													<h:commandLink value="●コース 新規作成" action="#{courseBasicInputBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="●コース 一覧検索" action="#{courseMenuSerchBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="●コース情報メンテナン" action="#{courseInfoMaintenanceBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="●料金区分メンテナン" action="#{courseMenuFeeMaintenanceBean.init}" immediate="true" />
												</TD>
											</TR>
										</TABLE>
									</TD>
									<TD vAlign="center" nowrap="nowrap" width="1%">
										<h:outputText value="ユーザ: #{facesContext.externalContext.userPrincipal.name}"/>
										<h:commandButton value="ログアウト" action="#{logoutBean.logout}" immediate="true"/>
									</TD>
									<TR>
										<TD class="Title" nowrap="nowrap" valign="middle" align="center" colspan="3" />
									</TR>
								</TR>
							</TABLE>
							<div class="Header"><hr/></div>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</html>
