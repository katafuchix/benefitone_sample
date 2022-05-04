package jp.co.benefitone.business.course;
import java.util.List;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;
import jp.co.benefitone.integration.course.CourseMenuFeeMaintenanceDAO;

public class CourseMenuFeeMaintenanceServiceImpl extends HibernateDaoSupport 
	implements CourseMenuFeeMaintenanceService {

	private CourseMenuFeeMaintenanceDAO courseMenuFeeMaintenanceDAO;

	public void setCourseMenuFeeMaintenanceDAO(CourseMenuFeeMaintenanceDAO courseMenuFeeMaintenanceDAO) {
		this.courseMenuFeeMaintenanceDAO = courseMenuFeeMaintenanceDAO;
	}

	/* ‘SŒŒŸõ */
	public List getCourseMenuFeeList() {
		return courseMenuFeeMaintenanceDAO.selectAllItems();
	}

}
