/*
 * $Id: CategoryDAO.java,v 1.1 2006/01/31 11:15:11 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.integration.course;

import java.util.List;
import java.util.Map;

import jp.co.benefitone.model.menu.CategoryVO;

/**
 * ＭＭＮ０１１：カテゴリDAOインターフェース。
 *
 * @version $Revision: 1.1 $
 * @author DAO生成ツール
 */
public interface CategoryDAO<CategoryVO> {
        /**
         * カテゴリを取得する。
         * @return カテゴリリスト
         * @ejb.transaction type="Required"
         * @ejb.permission unchecked="true"
         */
        public List<CategoryVO> getCatItemsByLevelAndKey(String catLevel, String catKey);
        public List<CategoryVO> getCourseTypeItem();

}
