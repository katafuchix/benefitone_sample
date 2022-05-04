/*
 * $Id: PartnerConstant.java,v 1.1 2006/01/31 09:22:12 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.core.util.partner;

public class PartnerConstant {

    /** 大エリアレベル */
    public static final String LARGE_AREA_LEVEL  = "1";
    /** 中エリアレベル */
    public static final String MIDDLE_AREA_LEVEL = "2";
    /** 小エリアレベル */
    public static final String SMALL_AREA_LEVEL  = "3";

    /** 大カテゴリレベル */
    public static final String LARGE_CAT_LEVEL  = "1";
    /** 中カテゴリレベル */
    public static final String MIDDLE_CAT_LEVEL = "2";
    /** 小カテゴリレベル */
    public static final String SMALL_CAT_LEVEL  = "3";

    /** カテゴリのシステムコードＩＤ */
    public static final String CAT_SYS_CD_ID  = "S006";

    /** 申請モード */
    public static final int MODE_TYPE_REGIST = 0;
    /** 編集モード */
    public static final int MODE_TYPE_EDIT = 1;
    /** 照会モード */
    public static final int MODE_TYPE_VIEW = 2;
    
    /** 全て */
    public static final String STATUS_ALL = "1";
    /** 登録待 */
    public static final String STATUS_REGIST_BEFORE = "2";
    /** 登録中 */
    public static final String STATUS_REGISTING = "3";
    /** 承認待 */
    public static final String STATUS_APPROVAL_BEFORE = "4";
    /** 承認済 */
    public static final String STATUS_APPROVAL_FINISH = "5";
    /** 差戻 */
    public static final String STATUS_SEND_BACK = "6";
    /** TODO: 反映7 */
    
    /** 共通項目削除フラグ	『削除フラグ』を"1" */
    public static final String DELETE_FLG_TRUE = "1";
    /** 共通項目削除フラグ	『削除フラグ』を"0" */
    public static final String DELETE_FLG_FALSE = "0";
    
    /** Screen Navigation Result */
    public static final String SCREEN_SUCCESS = "success";
    public static final String SCREEN_FAILED = "failed";
    public static final String SCREEN_ERROR = "error";

    public static final String CAT_CD = "18";
    
    /** Service Types */
    public static final String SERVICE_TYPE_BASIC = "20";
    public static final String SERVICE_TYPE_SCHOOL = "21";
    public static final String SERVICE_TYPE_RELAXATION = "22";
    public static final String SERVICE_TYPE_LEISURE = "23";
    public static final String SERVICE_TYPE_TRAVALSUPPORT = "24";
    public static final String SERVICE_TYPE_DAYNURSERY = "25";
    public static final String SERVICE_TYPE_BABYSITTER = "26";
    public static final String SERVICE_TYPE_SPORTS = "27";
    public static final String SERVICE_TYPE_GOURMENT = "28";
    public static final String SERVICE_TYPE_BRIDAL = "29";
    public static final String SERVICE_TYPE_ESTHETICS = "30";
    public static final String SERVICE_TYPE_RESTAURANT = "31";
    public static final String SERVICE_TYPE_TICKET = "32";
    
    /** Session Keys */
    public static final String TMENUVO_KEY = "tMenuVO";
    public static final String RMENUVO_KEY = "rMenuVO";
    public static final String SUPPLIER_TRSCTCPNY_KEY = "supplierTransactionsCompany";
    public static final String GB_KEY = "GBKey";
    public static final String MENU_KEY = "menuKey";
    public static final String STS_TYPE_CODE = "stsTypeCode";
    public static final String PREFE_KEY = "prefeKey";
    
    /** 現在表示件数プルダウンリスト値を取得する */
    public static final String M_SYS_CD_PAGE_SIZE  = "M002";
    
    public static final String MENU_NUMBER_TYPE = "91";
    
    /**  補助金区分コード="A"  */
    public static final String BNTY_TYPE_CD_A  = "A";
    
    public static final String UPLOAD_IMAGE_KEY = "uploadImageKey";
}