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
									<TD nowrap="nowrap"><em>PP�V�X�e��</em></TD>
									<TD valign="middle">
										<TABLE class="Menu" border="0" width="100%">
											<TR class="Header2">
												<TD nowrap="nowrap" COLSPAN="2">�ꗗ�����E�V�K�쐬</TD>
												<TD nowrap="nowrap">�R�[�X��񃁃��e�i���X</TD>
												<TD nowrap="nowrap">�}�X�^�����e�i���X</TD>
											</TR>
											<TR>
												<TD nowrap="nowrap">
													<h:commandLink value="���R�[�X �V�K�쐬" action="#{courseBasicInputBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="���R�[�X �ꗗ����" action="#{courseMenuSerchBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="���R�[�X��񃁃��e�i��" action="#{courseInfoMaintenanceBean.init}" immediate="true" />
												</TD>
												<TD nowrap="nowrap">
													<h:commandLink value="�������敪�����e�i��" action="#{courseMenuFeeMaintenanceBean.init}" immediate="true" />
												</TD>
											</TR>
										</TABLE>
									</TD>
									<TD vAlign="center" nowrap="nowrap" width="1%">
										<h:outputText value="���[�U: #{facesContext.externalContext.userPrincipal.name}"/>
										<h:commandButton value="���O�A�E�g" action="#{logoutBean.logout}" immediate="true"/>
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
