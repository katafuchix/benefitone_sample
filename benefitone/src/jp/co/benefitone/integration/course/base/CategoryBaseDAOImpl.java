/*
 * $Id: CategoryBaseDAOImpl.java,v 1.1 2006/01/31 09:25:10 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.integration.course.base;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.common.fw.integration.HibernateUtil;
import jp.co.benefitone.model.menu.CategoryVO;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.StaleObjectStateException;

/**
 * ＭＭＮ０１１：カテゴリBaseDAO実装クラス。
 *
 * @version $Revision: 1.1 $
 * @author DAO生成ツール
 */
public class CategoryBaseDAOImpl implements CategoryBaseDAO {

    /** セッションファクトリオブジェクト */
    private SessionFactory sessionFactory;

    /** VOクラスのプロパティディスクリプタ */
    private static PropertyDescriptor[] propertyDescriptors;

    /**
     * static初期化子でプロパティディスクリプタを取得します。
     * 取得に失敗した場合はExceptionInInitializerErrorをthrowします。*/
    static {
        BeanInfo beanInfo;
        try  {
            beanInfo = Introspector.getBeanInfo(CategoryVO.class);
        } catch (IntrospectionException e) {
            // 内部検査中に例外が発生
            throw new ExceptionInInitializerError("beanInfoを取得できませんでした。");
        }
        propertyDescriptors = beanInfo.getPropertyDescriptors();
    }

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

}
