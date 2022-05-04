package jp.co.benefitone.presentation.course;

//import jp.co.benefitone.presentation.common.LoginUserBean;
import jp.co.benefitone.presentation.customer.BaseBean;


public class CourseBasicInputBean extends BaseBean {
	
	/**コースID**/
    private String courseId;
    private String courseName;
	/**
     * 初期表示の処理
     * @return "success"成功する
     */
	public String init() {

		return "session";
	}
	
	/**
     * 確定ボタン押下時の処理
     * @return "success"成功する
     */
	public String detail() {

		return "success";
	}

	/**
	 * @return courseIdを返します。
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseIdを設定します。
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return courseNameを返します。
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseNameを設定します。
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


}

 
