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
						if (oj.name == "_id0:_id98"){
							jpURL = "04_1_cource_menu_serch.htm"; 
						}else if (oj.name == "_id0:_id99"){
							jpURL = "04_cource_menu_serch.htm"; 
						}else if (oj.name == "CorpList"){
							jpURL = "05_cource_corp_list.htm"; 
						}else if (oj.name == "Cat_Ment"){
							jpURL = "06_cource_category_ment.htm"; 
						}else if (oj.name == "Cat_Del"){
							jpURL = "09_cource_menu_del.htm"; 
						}else if (oj.name == "Cat_ADD"){
							jpURL = "10_cource_menu_add.htm"; 
						}else if (oj.name == "Cat_Change"){
							jpURL = "11_cource_menu_��hange.htm"; 
						}
						location.href = jpURL; 
					} 
				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">�R�[�X�ꗗ �������</span>
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
										<span class="SubTitle">�y�R�[�X�ꗗ ���������z</span>
									</TD>
								</TR>
							</TABLE>
							<BR />
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="100">
										 �R�[�X���
									</TD>
									<TD colspan="3">
<h:selectOneMenu   id="shippingOption"
  required="true" >
  <f:selectItems value="#{courseClassListBean.selectCourseTypeList}" />
</h:selectOneMenu>
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
							</TABLE>
							<!-- �R�[�X -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0" DISABLED="DISABLED">
								<TR>
									<TD WIDTH="100">
										 �R�[�X
									</TD>
								</TR>
								<TR>
									<TD WIDTH="100">
										  �x�[�X
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										�I���W�i��
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										�J�X�^��
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
									<td>
										<BR />
									</td>
								</TR>
							</TABLE>
							<!-- �R�[�X�h�c ���p���� -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="100">
										 �R�[�X�h�c
									</TD>
									<TD>
										<input type="text" name="CourceID" DISABLED="DISABLED" />
									</TD>
									<TD WIDTH="80">
										   �R�[�X��
									</TD>
									<TD colspan="3">
										<input type="text" name="CourceName" maxlength="80" size="80" DISABLED="DISABLED" />
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 �R�[�X���p����
									</TD>
									<TD colspan="2">
										<input type="text" maxlength="4" size="4" />�N  
										<input type="text" maxlength="2" size="2" />��  
										<input type="text" maxlength="2" size="2" />��  
										�`
										<input type="text" maxlength="4" size="4" />�N  
										<input type="text" maxlength="2" size="2" />��  
										<input type="text" maxlength="2" size="2" />��  
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
							</TABLE>
							<!-- �@�l -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<!-- �Ԋu���� -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 �@�l�h�c
									</TD>
									<TD>
										<input type="text" name="CorpID" DISABLED="DISABLED" />
									</TD>
									<TD WIDTH="80">
										   �@�l��
									</TD>
									<TD colspan="3">
										<input type="text" name="CorpName" maxlength="80" size="80" DISABLED="DISABLED" />
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 �J�t�F�Ώۊ��
									</TD>
									<TD>
										<input type="checkbox" name="Caffe" DISABLED="DISABLED" />
									</TD>
									<TD WIDTH="80">
										   
									</TD>
									<TD colspan="3">
										   
									</TD>
								</TR>
								<TR>
									<!-- �Ԋu���� -->
								</TR>
							</TABLE>
							<!-- ���p�\�J�e�S�� -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD COLSPAN="8">
										 ���p�\�J�e�S��
									</TD>
								</TR>
								<TR>
									<TD WIDTH="100">
										  ��J�e�S��
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1"  DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										���J�e�S��
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										���J�e�S��
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">�����敪</option>
											<option value="-2">�e�R�[�X</option>
											<option value="-3">�e�R�[�X</option>
										</select>
									</TD>
								</TR>
							</TABLE>
							<BR />
							<BR />
							<HR />
							<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
								<TR>
									<TD valign="middle" align="right">
										<input type="button" name="_id0:_id98" value="����" onclick="jump(this)" />
										 
									</TD>
								</TR>
							</TABLE>
							<HR />
							<!-- �������� -->
							<TABLE class="Table" width="100%">
								<TBODY>
									<TR>
										<TD class="SubTitle" colSpan="2">�T�[�r�X���j���[��������</TD>
									</TR>
									<TR>
										<TD class="SearchResult" colSpan="2">120���̃f�[�^����v���܂����B1���`8����\�����Ă��܂��B</TD>
									</TR>
									<TR>
										<TD align="right">
											���݂̕\��������
											<SELECT id="form1:TXT_MENU17" size="1" name="form1:TXT_MENU17">
												<OPTION value="1" selected="selected">10</OPTION> 
												<OPTION value="2">20</OPTION>
												<OPTION value="3">30</OPTION>
											</SELECT>���ł��@ 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">�ŏ���</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">�O��</A> 
											<FONT color="#ff0000">1</FONT>
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">2</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">3</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">4</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">5</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">6</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">7</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">8</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">9</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">10</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">����</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">�Ō��</A> 
										</TD>
									</TR>
									<TR>
										<TD> </TD>
									</TR>
									<TR>
										<TD align="left" colSpan="2">
											<TABLE class="SearchResultTableEx" id="form1:table" cellSpacing="1" cellPadding="1" border="1">
												<THEAD>
													<TR>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id70'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																�R�[�X�h�c��
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id70'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																�R�[�X���́�
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id72'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																�R�[�X��ʁ�
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id72'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																���p���ԁ�
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col" align="center" colspan="5" >
															�����e�i���X
														</TH>
													</TR>
												</THEAD>
												<!-- �������ʈꗗ�� -->
												<TBODY>
													<!-- �w�i���g��(��s) -->
													<TR class="SearchResultNew">
														<TD>
															�r�s�c
														</TD>
														<TD>
															�X�^���_�[�h�R�[�X
														</TD>
														<TD>
															�x�[�X�R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
															<TD WIDTH="75">
																<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
															</TD>
													</TR>
													<!-- �w�i�g��(�����s) -->
													<TR class="SearchResultOdd">
														<TD>
															�f�k�c
														</TD>
														<TD>
															�S�[���h�R�[�X
														</TD>
														<TD>
															�x�[�X�R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- �w�i���g��(��s) -->
													<TR class="SearchResultNew">
														<TD>
															�o�q�u
														</TD>
														<TD>
															�v���C�x�[�g�R�[�X
														</TD>
														<TD>
															�I���W�i���R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
														</TD>
														<TD WIDTH="80">
															<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- �w�i�g��(�����s) -->
													<TR class="SearchResultOdd">
														<TD>
															ABCDEFGH
														</TD>
														<TD>
															�v���X�e�[�W�S�[���h
														</TD>
														<TD>
															�I���W�i���R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- �w�i���g��(��s) -->
													<TR class="SearchResultNew">
														<TD>
															�r�k�b
														</TD>
														<TD>
															�Z���N�g�R�[�X
														</TD>
														<TD>
															�I���W�i���R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
														</TD>
														<TD WIDTH="80">
															<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- �w�i�g��(�����s) -->
													<TR class="SearchResultOdd">
														<TD>
															�c�x�i
														</TD>
														<TD>
															�_�C�W�F�X�g�R�[�X
														</TD>
														<TD>
															�I���W�i���R�[�X
														</TD>
														<TD>
															05/11/11 �` 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="�@�l�ꗗ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="�J�e�S�������e" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="���j���[�ꗗ"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="���j���[�ǉ�"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="�����ύX" onclick="jump(this)" />
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
									<TR>
										<TD colSpan="2"> </TD>
									</TR>
									<TR align="middle">
										<TD colSpan="2">
											<INPUT type="submit" value="�@�߂�@" name="form1:_id100" onclick="window.close()" />   
											<INPUT type="submit" value="CSV�o��" name="form1:_id100" onclick="window.close()" />   
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<BR />
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</html>
