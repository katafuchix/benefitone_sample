package jp.co.benefitone.presentation.course;

//import jp.co.benefitone.presentation.common.LoginUserBean;
import jp.co.benefitone.presentation.customer.BaseBean;


public class CourseBasicInputBean extends BaseBean {
	
	/**�R�[�XID**/
    private String courseId;
    private String courseName;
	/**
     * �����\���̏���
     * @return "success"��������
     */
	public String init() {

		return "session";
	}
	
	/**
     * �m��{�^���������̏���
     * @return "success"��������
     */
	public String detail() {

		return "success";
	}

	/**
	 * @return courseId��Ԃ��܂��B
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId��ݒ肵�܂��B
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return courseName��Ԃ��܂��B
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName��ݒ肵�܂��B
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


}

 
