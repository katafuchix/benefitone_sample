<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:p="http://java.sun.com/pager">

<jsp:directive.page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J"/>


		<TABLE class="SearchCondition" cellSpacing="0" cellPadding="0" width="100%" border="1">
			<TBODY>
				<TR>
					<TD>
						<TABLE class="Table" width="100%">
							<TBODY>
								<!-- ���������ٕ� -->
								<TR>
									<TD class="Header2" colSpan="4">�ꗗ�����E�V�K�쐬 </TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseBasicInput.jsp">���R�[�X �V�K�쐬</A>
									</TD>
									<TD>
										�V�K�R�[�X���쐬���܂��B
									</TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseMenuSerch.jsp">���R�[�X �ꗗ����</A>
									</TD>
									<TD>�R�[�X�̎�ʂ�����@�l�A�J�e�S���Ȃǂ̏�������A�R�[�X�̏�񌟍����s���܂��B </TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR />
						<TABLE class="Table" width="100%">
							<TBODY>
								<TR>
									<TD class="Header2" colSpan="2">�R�[�X��񃁃��e�i���X </TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseInfoMaintenance.jsp">���R�[�X��񃁃��e�i���X</A>
									</TD>
									<TD>�e�R�[�X�̏���ҏW���܂��B </TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR />
						<TABLE class="Table" width="100%">
							<TBODY>
								<TR>
									<TD class="Header2" colSpan="2">�}�X�^�����e�i���X </TD>
								</TR>
								<TR>
									<TD width="20%">
										<h:commandLink id="courseMenuFeeMaintenance" action="#{courseMenuFeeMaintenanceBean.select}" value="�����敪�����e�i���X" />

									</TD>
									<TD>�����敪�̃����e�i���X���s���܂��B </TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR />
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	<BR /><BR /><BR /><BR /><BR />

</html>