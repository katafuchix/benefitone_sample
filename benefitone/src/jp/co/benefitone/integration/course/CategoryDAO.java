/*
 * $Id: CategoryDAO.java,v 1.1 2006/01/31 11:15:11 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.integration.course;

import java.util.List;
import java.util.Map;

import jp.co.benefitone.model.menu.CategoryVO;

/**
 * �l�l�m�O�P�P�F�J�e�S��DAO�C���^�[�t�F�[�X�B
 *
 * @version $Revision: 1.1 $
 * @author DAO�����c�[��
 */
public interface CategoryDAO<CategoryVO> {
        /**
         * �J�e�S�����擾����B
         * @return �J�e�S�����X�g
         * @ejb.transaction type="Required"
         * @ejb.permission unchecked="true"
         */
        public List<CategoryVO> getCatItemsByLevelAndKey(String catLevel, String catKey);
        public List<CategoryVO> getCourseTypeItem();

}
