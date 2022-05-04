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
							if( confirm("入力内容が破棄されます。\nよろしいですか？" ) ){
								history.back();
							}else{
								return false;
							}
						}

				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">コース新規作成 基本情報登録</span>
						</TD>
					</TR>
				</TABLE>
				<div align="right">
					<input type="button" value="　戻る　" onclick="itReturns();" />
				</div>
				<TABLE class="SearchCondition" border="1" width="100%">
					<TR>
						<TD>
							<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD>
										<span class="SubTitle">【コース基本情報】</span>
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
										<h:outputText value="コースＩＤ" />
									</TD>
									<TD colspan="3">
										<h:inputText id="courseId" value="#{courseBasicInputBean.courseId}" />
											<span class="FontResult"></span>
										</TD>
									</TR>
									<TR>
										<!-- 間隔調整 -->
									</TR>
									<TR>
										<TD WIDTH="150">
											<font color="red">*</font>
											<h:outputText value="コース名称" />
										</TD>
										<TD colspan="3">
											<h:inputText id="courseName" value="#{courseBasicInputBean.courseName}" />
											<span class="FontResult"></span>
										</TD>
									</TR>
									<TR>
										<!-- 間隔調整 -->
									</TR>
									<TR>
										<TD WIDTH="150">
											<font color="red">*</font>
											<h:outputText value="コース種別" />
										</TD>
										<TD colspan="3">
											<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1">
												<option value="">--------------------</option>
												<option value="-1">ベースコース</option>
												<option value="-2">オリジナルコース(ベース除く)</option>
												<option value="-3">カスタムコース</option>
											</select>
										</TD>
									</TR>
								</TABLE>
								<BR />
								<font color="red">*</font>は必須入力です。
								<BR />
								<HR />
								<CENTER>
									<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
										<TR>
											<TD>
												<h:commandButton value="確定" action="#{courseBasicInputBean.detail}" />
											</TD>
											<TD>　</TD>
											<TD>　</TD>
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
