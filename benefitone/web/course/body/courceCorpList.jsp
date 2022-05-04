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
					function jump(oj) { 
						if (oj.name == "_id0:_id98"){
							jpURL = "04_1_cource_menu_serch.htm"; 
						}else if (oj.name == "_id0:_id99"){
							jpURL = "04_cource_menu_serch.htm"; 
						}
						location.href = jpURL; 
					} 
				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">法人一覧</span>
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
										<span class="SubTitle">【コース情報】</span>
									</TD>
								</TR>
							</TABLE>
							<BR />
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="120">
										 コース：
									</TD>
									<TD colspan="3">
										ＳＴＤ   ／   スタンダードコース
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD>
										 コース種別：
									</TD>
									<TD colspan="3">
										ベースコース
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD>
										 コース利用期間：
									</TD>
									<TD colspan="3">
										2005年01月12日～2999年12月31日
									</TD>
								</TR>
							</TABLE>
							<BR />
							<BR />
							<HR />
							<!-- 検索結果 -->
							<TABLE class="Table" width="100%">
								<TBODY>
									<TR>
										<TD class="SubTitle" colSpan="2">【法人一覧】</TD>
									</TR>
									<TR>
										<TD class="SearchResult" colSpan="2">120件のデータが一致しました。1件～8件を表示しています。</TD>
									</TR>
									<TR>
										<TD align="right">
											現在の表示件数は
											<SELECT id="form1:TXT_MENU17" size="1" name="form1:TXT_MENU17">
												<OPTION value="1" selected="selected">10</OPTION> 
												<OPTION value="2">20</OPTION>
												<OPTION value="3">30</OPTION>
											</SELECT>件です　 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">最初へ</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">前へ</A> 
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
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">次へ</A> 
											<A href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">最後へ</A> 
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
																法人ＩＤ▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id70'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																法人名▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id72'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																法人名カナ▼
															</A>
														</TH>
													</TR>
												</THEAD>
												<!-- 検索結果一覧部 -->
												<TBODY>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															100070
														</TD>
														<TD>
															株式会社　コミュニケーション・アート
														</TD>
														<TD>
															コミュニケーションアート
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															100520
														</TD>
														<TD>
															株式会社　寒山
														</TD>
														<TD>
															カンザン
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															100523
														</TD>
														<TD>
															パソナファミリークラブ　事務局
														</TD>
														<TD>
															パソナファミリークラブジムキョク
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															100524
														</TD>
														<TD>
															東京財団
														</TD>
														<TD>
															トウキョウザイダン
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															100530
														</TD>
														<TD>
															株式会社　クラブハウス
														</TD>
														<TD>
															クラブハウス
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															100531
														</TD>
														<TD>
															株式会社　ナティックス
														</TD>
														<TD>
															ナティックス
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															100533
														</TD>
														<TD>
															ビジネスファクトリー　株式会社
														</TD>
														<TD>
															ビジネスファクトリー
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															100544
														</TD>
														<TD>
															新開　株式会社
														</TD>
														<TD>
															シンカイ
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															100557
														</TD>
														<TD>
															医療法人社団　秀島歯科医院
														</TD>
														<TD>
															ヒデシマシカイイン
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															100558
														</TD>
														<TD>
															新ケミカル商事　株式会社
														</TD>
														<TD>
															シンケミカルショウジ
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															101471
														</TD>
														<TD>
															株式会社　ティー・ヴィー・エス
														</TD>
														<TD>
															ティーヴィーエス
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															104241
														</TD>
														<TD>
															株式会社　テイパーズ
														</TD>
														<TD>
															テイパーズ
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
											<INPUT type="submit" value="　戻る　" name="form1:_id100" onclick="pageAction('04_1_cource_menu_serch.htm')" />   
											<INPUT type="submit" value="CSV出力" name="form1:_id100" onclick="pageAction('04_1_cource_menu_serch.htm')" />   
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
