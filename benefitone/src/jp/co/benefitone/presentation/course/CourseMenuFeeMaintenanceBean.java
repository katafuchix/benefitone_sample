package jp.co.benefitone.presentation.course;
import java.io.Serializable;
import java.util.List;
import jp.co.benefitone.business.course.CourseMenuFeeMaintenanceService;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

public class CourseMenuFeeMaintenanceBean extends BaseBean implements Serializable {

    private CourseMenuFeeMaintenanceService courseMenuFeeMaintenanceService;
    private List bntyTypeList;
	private UIData itemTable;

	/* 
		BntyTypeList �A�N�Z�b�T�[
	*/
    public void setBntyTypeList(List bntyTypeList) {
        this.bntyTypeList = bntyTypeList;
    }
    public List getBntyTypeList() {
        return bntyTypeList;
    }

	/*
		CourseMenuFeeMaintenanceService �A�N�Z�b�T�[
	*/
	public void setCourseMenuFeeMaintenanceService(CourseMenuFeeMaintenanceService courseMenuFeeMaintenanceService) {
		this.courseMenuFeeMaintenanceService = courseMenuFeeMaintenanceService;
	}
    public CourseMenuFeeMaintenanceService getCourseMenuFeeMaintenanceService() {
        return courseMenuFeeMaintenanceService;
    }


	/*
		�R���X�g���N�^
	*/
	public CourseMenuFeeMaintenanceBean() {

	}

	public void select() {
		init();
	}


	public void init() {

		FacesContext context = FacesContext.getCurrentInstance();
		CourseMenuFeeMaintenanceService courseMenuFeeMaintenanceFacade = 
			(CourseMenuFeeMaintenanceService)context.getApplication().getVariableResolver().resolveVariable(context,"CourseMenuFeeMaintenanceService");
		itemTable = new UIData();

		try {
			bntyTypeList = courseMenuFeeMaintenanceFacade.getCourseMenuFeeList();
			itemTable.setValue(bntyTypeList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

