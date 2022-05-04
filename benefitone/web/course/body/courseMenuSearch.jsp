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
						}else if (oj.name == "CorpList"){
							jpURL = "05_cource_corp_list.htm"; 
						}else if (oj.name == "Cat_Ment"){
							jpURL = "06_cource_category_ment.htm"; 
						}else if (oj.name == "Cat_Del"){
							jpURL = "09_cource_menu_del.htm"; 
						}else if (oj.name == "Cat_ADD"){
							jpURL = "10_cource_menu_add.htm"; 
						}else if (oj.name == "Cat_Change"){
							jpURL = "11_cource_menu_ｃhange.htm"; 
						}
						location.href = jpURL; 
					} 
				</SCRIPT>
				<TABLE class="Header" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%">
					<TR>
						<TD align="center">
							<span class="Title">コース一覧 検索画面</span>
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
										<span class="SubTitle">【コース一覧 検索条件】</span>
									</TD>
								</TR>
							</TABLE>
							<BR />
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="100">
										 コース種別
									</TD>
									<TD colspan="3">
<h:selectOneMenu   id="shippingOption"
  required="true" >
  <f:selectItems value="#{courseClassListBean.selectCourseTypeList}" />
</h:selectOneMenu>
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
							</TABLE>
							<!-- コース -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0" DISABLED="DISABLED">
								<TR>
									<TD WIDTH="100">
										 コース
									</TD>
								</TR>
								<TR>
									<TD WIDTH="100">
										  ベース
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										オリジナル
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										カスタム
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
										</select>
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
									<td>
										<BR />
									</td>
								</TR>
							</TABLE>
							<!-- コースＩＤ 利用期間 -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD WIDTH="100">
										 コースＩＤ
									</TD>
									<TD>
										<input type="text" name="CourceID" DISABLED="DISABLED" />
									</TD>
									<TD WIDTH="80">
										   コース名
									</TD>
									<TD colspan="3">
										<input type="text" name="CourceName" maxlength="80" size="80" DISABLED="DISABLED" />
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 コース利用期間
									</TD>
									<TD colspan="2">
										<input type="text" maxlength="4" size="4" />年  
										<input type="text" maxlength="2" size="2" />月  
										<input type="text" maxlength="2" size="2" />日  
										～
										<input type="text" maxlength="4" size="4" />年  
										<input type="text" maxlength="2" size="2" />月  
										<input type="text" maxlength="2" size="2" />日  
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
							</TABLE>
							<!-- 法人 -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 法人ＩＤ
									</TD>
									<TD>
										<input type="text" name="CorpID" DISABLED="DISABLED" />
									</TD>
									<TD WIDTH="80">
										   法人名
									</TD>
									<TD colspan="3">
										<input type="text" name="CorpName" maxlength="80" size="80" DISABLED="DISABLED" />
									</TD>
								</TR>
								<TR>
									<!-- 間隔調整 -->
								</TR>
								<TR>
									<TD WIDTH="100">
										 カフェ対象企業
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
									<!-- 間隔調整 -->
								</TR>
							</TABLE>
							<!-- 利用可能カテゴリ -->
							<TABLE class="SearchConditionTable" BORDER="0" CELLPADDING="0" CELLSPACING="0">
								<TR>
									<TD COLSPAN="8">
										 利用可能カテゴリ
									</TD>
								</TR>
								<TR>
									<TD WIDTH="100">
										  大カテゴリ
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1"  DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										中カテゴリ
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
										</select>
									</TD>
									<TD WIDTH="60">
										        
									</TD>
									<TD WIDTH="100">
										小カテゴリ
									</TD>
									<TD>
										<select id="_id0:LST_PREFECTURE" name="_id0:LST_PREFECTURE" size="1" DISABLED="DISABLED">
											<option value="">------------</option>
											<option value="-1">料金区分</option>
											<option value="-2">親コース</option>
											<option value="-3">親コース</option>
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
										<input type="button" name="_id0:_id98" value="検索" onclick="jump(this)" />
										 
									</TD>
								</TR>
							</TABLE>
							<HR />
							<!-- 検索結果 -->
							<TABLE class="Table" width="100%">
								<TBODY>
									<TR>
										<TD class="SubTitle" colSpan="2">サービスメニュー検索結果</TD>
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
																コースＩＤ▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id70'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																コース名称▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id72'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																コース種別▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col">
															<A class="LinkTable" onclick="document.forms['form1']['form1:_idcl'].value='form1:table:_id72'; document.forms['form1'].submit(); return false;" 
															href="http://torinodv03.benefit-one.co.jp:8080/benefitone/customerList.faces#">
																利用期間▼
															</A>
														</TH>
														<TH class="SearchResultTableHeader" scope="col" align="center" colspan="5" >
															メンテナンス
														</TH>
													</TR>
												</THEAD>
												<!-- 検索結果一覧部 -->
												<TBODY>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															ＳＴＤ
														</TD>
														<TD>
															スタンダードコース
														</TD>
														<TD>
															ベースコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
															<TD WIDTH="75">
																<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
															</TD>
															<TD WIDTH="80">
																<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
															</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															ＧＬＤ
														</TD>
														<TD>
															ゴールドコース
														</TD>
														<TD>
															ベースコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															ＰＲＶ
														</TD>
														<TD>
															プライベートコース
														</TD>
														<TD>
															オリジナルコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
														</TD>
														<TD WIDTH="80">
															<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															ABCDEFGH
														</TD>
														<TD>
															プレステージゴールド
														</TD>
														<TD>
															オリジナルコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- 背景白組み(奇数行) -->
													<TR class="SearchResultNew">
														<TD>
															ＳＬＣ
														</TD>
														<TD>
															セレクトコース
														</TD>
														<TD>
															オリジナルコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
														</TD>
														<TD WIDTH="80">
															<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
														</TD>
													</TR>
													<!-- 背景青組み(偶数行) -->
													<TR class="SearchResultOdd">
														<TD>
															ＤＹＪ
														</TD>
														<TD>
															ダイジェストコース
														</TD>
														<TD>
															オリジナルコース
														</TD>
														<TD>
															05/11/11 ～ 05/11/11
														</TD>
														<TD>
															<input type="button" name="CorpList" value="法人一覧" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Ment" value="カテゴリメンテ" onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Del" value="メニュー一覧"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_ADD" value="メニュー追加"  onclick="jump(this)" />
														</TD>
														<TD>
															<input type="button" name="Cat_Change" value="料金変更" onclick="jump(this)" />
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
											<INPUT type="submit" value="　戻る　" name="form1:_id100" onclick="window.close()" />   
											<INPUT type="submit" value="CSV出力" name="form1:_id100" onclick="window.close()" />   
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
