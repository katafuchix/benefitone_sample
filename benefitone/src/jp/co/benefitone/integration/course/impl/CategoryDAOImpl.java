/*
 * $Id: CategoryDAOImpl.java,v 1.1 2006/01/31 09:25:33 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.integration.course.impl;

import jp.co.benefitone.integration.course.CategoryDAO;
import jp.co.benefitone.integration.course.base.CategoryBaseDAOImpl;

import java.util.List;
import java.util.LinkedList;

import net.sf.hibernate.Query;
import jp.co.benefitone.common.fw.integration.HibernateUtil;
import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.core.util.partner.PartnerConstant;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Session;
import jp.co.benefitone.model.menu.CategoryVO;


/**
 * ＭＭＮ０１１：カテゴリDAO実装クラスです。
 *
 * @version $Revision: 1.1 $
 * @author DAO生成ツール
 */
public class CategoryDAOImpl extends CategoryBaseDAOImpl implements CategoryDAO {
    private static final String DELETE_FLAG = "0";
    /** セッションファクトリオブジェクト */
    private SessionFactory sessionFactory;

    /**
     * SessionFactoryを設定します。
     * テストでは手動、実行時ではSpringFrameworkによりWiringされます。
     *
     * @param sessionFactory セッションファクトリオブジェクト
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * セッションファクトリを返します。
     * @return セッションファクトリ
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


	public List<CategoryVO> getCatItemsByLevelAndKey(String catLevel, String catKey) {
        Session session = null;
        List<CategoryVO> list = null;
        StringBuffer strbuff = new StringBuffer();
        CategoryVO cat = null;

        session = HibernateUtil.getSession(this.sessionFactory);
        try {
            list = new LinkedList< CategoryVO >();
            cat = new CategoryVO();
            cat.setKey(new Long(1));
            cat.setName("ベース");
            list.add(cat);
            cat = new CategoryVO();
            cat.setKey(new Long(2));
            cat.setName("オリジナル");
            list.add(cat);
            cat = new CategoryVO();
            cat.setKey(new Long(3));
            cat.setName("カスタム");
            list.add(cat);
            /*
            session = HibernateUtil.getSession(this.getSessionFactory());
            strbuff.append("select DISTINCT category from ")
                       .append(" CategoryVO category ")
                       .append(" where ")
                       .append(" category.level= ")
                       .append(catLevel);
            if (!catLevel.equals(PartnerConstant.LARGE_CAT_LEVEL)) {
                strbuff.append(" and category.parentCategory = ").append(catKey);
            };
            strbuff.append(" and category.deleteFlag='0' ORDER BY category.key ASC");
            Query query = session.createQuery(strbuff.toString());
            list = query.list();*/
            return list;
        }
//        catch (HibernateException e) {
//            throw new DatabaseRuntimeException(e);
//        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    public List<CategoryVO> getCourseTypeItem() {
        Session session = null;
        List<CategoryVO> list = null;
        StringBuffer strbuff = new StringBuffer();
        CategoryVO cat = null;

        session = HibernateUtil.getSession(this.sessionFactory);
        try {
            list = new LinkedList< CategoryVO >();
            cat = new CategoryVO();
            cat.setKey(new Long(1));
            cat.setName("AAA");
            list.add(cat);
            cat = new CategoryVO();
            cat.setKey(new Long(2));
            cat.setName("BBB");
            list.add(cat);
            /*
            session = HibernateUtil.getSession(this.getSessionFactory());
            strbuff.append("select DISTINCT category from ")
                       .append(" CategoryVO category ")
                       .append(" where ")
                       .append(" category.level= ")
                       .append(catLevel);
            if (!catLevel.equals(PartnerConstant.LARGE_CAT_LEVEL)) {
                strbuff.append(" and category.parentCategory = ").append(catKey);
            };
            strbuff.append(" and category.deleteFlag='0' ORDER BY category.key ASC");
            Query query = session.createQuery(strbuff.toString());
            list = query.list();*/
            return list;
        }
//        catch (HibernateException e) {
//            throw new DatabaseRuntimeException(e);
//        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

}
