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
				<SCRIPT language="JavaScript">
					function entryConfirm(){
						confirm("��{�����X�V���܂����H");
					}
					function pageAction(page) {
						document.forms[0].action = page;
						document.forms[0].submit();
						return false;
					}
					function jump(oj) { 
						if (oj.name == "form1:_id100"){
							jpURL = "04_1_cource_menu_serch.htm"; 
						}else if (oj.name == "_id0:_id98"){
							jpURL = "09_cource_menu_del.htm"; 
						}else if (oj.name == "_id0:_id99"){
							jpURL = "03_cource_detail_.htm"; 
						}
						location.href = jpURL; 
					} 
				</SCRIPT>

				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">�����敪�����e�i���X���</span>
						</TD>
					</TR>
				</TABLE>
				<div align="right">
					<input id="_id0:kkyic" type="submit" name="_id0:kkyic" value="&#12288;&#12288;&#25147;&#12427;&#12288;&#12288;"  onclick="window.location.href='./00_main_menu.htm'" />
				</div>


				<TABLE class="SearchCondition" border="1" width="100%">
					<TR>
						<TD>
							<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD>
										<span class="SubTitle">�y�����敪 �����e�i���X�z</span>
									</TD>
								</TR>
							</TABLE>
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="10">
									</TD>
									<TD WIDTH="100">
										<font color="red">*</font>�����敪�h�c
									</TD>
									<TD>
										<h:inputText id="feeId" required="false" maxlength="10" size="10" />
									</TD>
								</TR>
								<TR>
									<TD WIDTH="10">
									</TD>
									<TD WIDTH="110">
										<font color="red">*</font>�����敪����
									</TD>
									<TD WIDTH="100">
										<h:inputText id="feeName" required="false" maxlength="80" size="80" />
									</TD>
								</TR>
								<TR>
								<!-- �Ԋu���� -->
								</TR>
							</TABLE>
							<BR />
							<font color="red">*</font>�͕K�{���͂ł��B
							<BR />
							<HR />
							<CENTER>
							</CENTER>
							<TABLE class="Table" width="100%">
								<TBODY>
									<TR>
										<TD>�y�����敪�ꗗ�z</TD>
									</TR>
									<TR>
										<TD align="left" colSpan="2">


											<h:dataTable binding="#{courseMenuFeeMaintenanceBean.itemTable}" value="#{courseMenuFeeMaintenanceBean.bntyTypeList}" var="c">
												<h:column>
													<f:facet name="header">
														<h:outputText value="�R�[�X��" />
													</f:facet>
													<h:outputText value="#{c.bntyTypeRem}" />
												</h:column>
											</h:dataTable>

										</TD>
									</TR>
									<TR>
										<TD colSpan="2"> </TD>
									</TR>
								</TBODY>
							</TABLE>

							<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD>
										<input type="button" name="_id0:_id99" value="�V�K�쐬" onclick="jump(this)" />
									</TD>
									<TD>�@</TD>
									<TD>
										<input type="button" name="_id0:_id98" value="�ҏW" onclick="jump(this)" />
									</TD>
									<TD>�@</TD>
									<TD>
										<input type="button" name="_id0:_id98" value="�폜" onclick="jump(this)" />
									</TD>
								</TR>
							</TABLE>
							<BR />
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>

</html>