package jp.co.benefitone.integration.course;

import java.util.List;
import java.util.ArrayList;
import jp.co.benefitone.model.course.BntyTypeVO;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;


public class CourseMenuFeeMaintenanceDAOImpl
	extends HibernateDaoSupport
	implements CourseMenuFeeMaintenanceDAO {


	/* �S�������̎��s */

	public List selectAllItems() {

			return getHibernateTemplate().loadAll(BntyTypeVO.class);
	}

}
