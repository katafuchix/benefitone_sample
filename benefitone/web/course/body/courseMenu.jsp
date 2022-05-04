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
								<!-- 中項目ﾀｲﾄﾙ部 -->
								<TR>
									<TD class="Header2" colSpan="4">一覧検索・新規作成 </TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseBasicInput.jsp">●コース 新規作成</A>
									</TD>
									<TD>
										新規コースを作成します。
									</TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseMenuSerch.jsp">●コース 一覧検索</A>
									</TD>
									<TD>コースの種別や加盟法人、カテゴリなどの条件から、コースの情報検索を行います。 </TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR />
						<TABLE class="Table" width="100%">
							<TBODY>
								<TR>
									<TD class="Header2" colSpan="2">コース情報メンテナンス </TD>
								</TR>
								<TR>
									<TD width="20%">
										<A href="/benefitone/faces/course/courseInfoMaintenance.jsp">●コース情報メンテナンス</A>
									</TD>
									<TD>各コースの情報を編集します。 </TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR />
						<TABLE class="Table" width="100%">
							<TBODY>
								<TR>
									<TD class="Header2" colSpan="2">マスタメンテナンス </TD>
								</TR>
								<TR>
									<TD width="20%">
										<h:commandLink id="courseMenuFeeMaintenance" action="#{courseMenuFeeMaintenanceBean.select}" value="料金区分メンテナンス" />

									</TD>
									<TD>料金区分のメンテナンスを行います。 </TD>
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