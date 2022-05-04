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
 * �l�l�m�O�P�P�F�J�e�S��BaseDAO�����N���X�B
 *
 * @version $Revision: 1.1 $
 * @author DAO�����c�[��
 */
public class CategoryBaseDAOImpl implements CategoryBaseDAO {

    /** �Z�b�V�����t�@�N�g���I�u�W�F�N�g */
    private SessionFactory sessionFactory;

    /** VO�N���X�̃v���p�e�B�f�B�X�N���v�^ */
    private static PropertyDescriptor[] propertyDescriptors;

    /**
     * static�������q�Ńv���p�e�B�f�B�X�N���v�^���擾���܂��B
     * �擾�Ɏ��s�����ꍇ��ExceptionInInitializerError��throw���܂��B*/
    static {
        BeanInfo beanInfo;
        try  {
            beanInfo = Introspector.getBeanInfo(CategoryVO.class);
        } catch (IntrospectionException e) {
            // �����������ɗ�O������
            throw new ExceptionInInitializerError("beanInfo���擾�ł��܂���ł����B");
        }
        propertyDescriptors = beanInfo.getPropertyDescriptors();
    }

    /**
     * SessionFactory��ݒ肵�܂��B
     * �e�X�g�ł͎蓮�A���s���ł�SpringFramework�ɂ��Wiring����܂��B
     *
     * @param sessionFactory �Z�b�V�����t�@�N�g���I�u�W�F�N�g
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * �Z�b�V�����t�@�N�g����Ԃ��܂��B
     * @return �Z�b�V�����t�@�N�g��
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
