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
					confirm("基本情報を更新しますか？");
					}
					function pageAction(page) {
						document.forms[0].action = page;
						document.forms[0].submit();
						return false;
					}
				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">コース情報メンテナンス</span>
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
										<span class="SubTitle">コース情報メンテナンス</span>
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
										コース種別
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
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD WIDTH="150">
										<font color="red">*</font>
										コース
									</TD>
									<TD colspan="3">
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1">
											<option value="">--------------------</option>
											<option value="-1">スタンダードコース</option>
											<option value="-2">ゴールドコース</option>
										</select>
									</TD>
								</TR>
							</TABLE>
							<BR />
								<font color="red">*</font>は必須入力です。
							<BR />
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<!-- 間隔調整 -->
									<BR />
								</TR>
								<TR>
									<!-- 間隔調整 -->
									<BR />
								</TR>
								<TR>
									<TD WIDTH="20%">
										<A href="./13_cource_detail_ment.htm">●コース情報 編集・削除</A> 
									</TD>
									<TD WIDTH="5%">
										 
									</TD>
									<TD WIDTH="75%">
										コース内容の編集、または削除を行います
									</TD>
								</TR>
								<TR>
									<TD WIDTH="20%">
										<A href="./06_cource_category_ment.htm">●利用対象カテゴリ メンテ</A> 
									</TD>
									<TD WIDTH="5%">
										 
									</TD>
									<TD WIDTH="75%">
										コースの利用対象カテゴリを編集します
									</TD>
								</TR>
								<TR>
									<TD WIDTH="20%">
										<A href="09_cource_menu_del.htm">●利用対象メニュー一覧検索・削除</A> 
									</TD>
									<TD WIDTH="5%">
										 
									</TD>
									<TD WIDTH="75%">
										コースの利用対象メニューの一覧を検索します。検索結果から不要メニューの削除も可能です
									</TD>
								</TR>
								<TR>
									<TD WIDTH="20%">
										<A href="10_cource_menu_add.htm">●利用対象メニュー追加</A> 
									</TD>
									<TD WIDTH="5%">
										 
									</TD>
									<TD WIDTH="75%">
										コース専用メニュー、企業専用メニューの追加を行います
									</TD>
								</TR>
								<TR>
									<TD WIDTH="20%">
										<A href="11_cource_menu_ｃhange.htm">●利用対象メニュー料金変更</A> 
									</TD>
									<TD WIDTH="5%">
										 
									</TD>
									<TD WIDTH="75%">
										コース専用料金の編集を行います
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
				<BR />
				<BR />
				<HR />
			</TD>
		</TR>
	</TABLE>
</html>