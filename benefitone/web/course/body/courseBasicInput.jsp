<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:p="http://java.sun.com/pager">

<jsp:directive.page contentType="text/html;charset=Windows-31J" pageEncoding="Windows-31J"/>

	<TABLE width="100%" BORDER="0" CELLPADDING="0" CELLSPACING="0">
		<TR>
			<TD>
				<SCRIPT Language="JavaScript">

						function itReturns(){
							if( confirm("���͓��e���j������܂��B\n��낵���ł����H" ) ){
								history.back();
							}else{
								return false;
							}
						}

				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">�R�[�X�V�K�쐬 ��{���o�^</span>
						</TD>
					</TR>
				</TABLE>
				<div align="right">
					<input type="button" value="�@�߂�@" onclick="itReturns();" />
				</div>
				<TABLE class="SearchCondition" border="1" width="100%">
					<TR>
						<TD>
							<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD>
										<span class="SubTitle">�y�R�[�X��{���z</span>
									</TD>
								</TR>
							</TABLE>
							<BR />
							<TABLE class="Table" cellspacing="0" cellpadding="0" border="0" width="100%">
								<TR>
									<TD class="SearchResult"></TD>
								</TR>
							</TABLE>
							<BR />
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="150">
										<font color="red">*</font>
										<h:outputText value="�R�[�X�h�c" />
									</TD>
									<TD colspan="3">
										<h:inputText id="courseId" value="#{courseBasicInputBean.courseId}" />
											<span class="FontResult"></span>
										</TD>
									</TR>
									<TR>
										<!-- �Ԋu���� -->
									</TR>
									<TR>
										<TD WIDTH="150">
											<font color="red">*</font>
											<h:outputText value="�R�[�X����" />
										</TD>
										<TD colspan="3">
											<h:inputText id="courseName" value="#{courseBasicInputBean.courseName}" />
											<span class="FontResult"></span>
										</TD>
									</TR>
									<TR>
										<!-- �Ԋu���� -->
									</TR>
									<TR>
										<TD WIDTH="150">
											<font color="red">*</font>
											<h:outputText value="�R�[�X���" />
										</TD>
										<TD colspan="3">
											<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1">
												<option value="">--------------------</option>
												<option value="-1">�x�[�X�R�[�X</option>
												<option value="-2">�I���W�i���R�[�X(�x�[�X����)</option>
												<option value="-3">�J�X�^���R�[�X</option>
											</select>
										</TD>
									</TR>
								</TABLE>
								<BR />
								<font color="red">*</font>�͕K�{���͂ł��B
								<BR />
								<HR />
								<CENTER>
									<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
										<TR>
											<TD>
												<h:commandButton value="�m��" action="#{courseBasicInputBean.detail}" />
											</TD>
											<TD>�@</TD>
											<TD>�@</TD>
										</TR>
									</TABLE>
								</CENTER>
							</TD>
						</TR>
					</TABLE>
			</TD>
		</TR>	
	</TABLE>
</html>
