package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * ModelFactory decides which model implementation run
 * 
 * @author Shivanshi Gupta
 *
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");
	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	
	private ModelFactory() {
 
	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	
	public UserModelInt getUserModel() {
		//UserModelInt userModel = null;
		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		System.out.println(userModel);
		if (userModel == null) {
			
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				userModel = new UserModelJDBCImpl();
			}
			System.out.println(DATABASE);
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}
	
	
	
	
	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public StudentModelInt getStudentModel() { 
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		} 

		return subjectModel;
	}

	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			modelCache.put("facultyModel", facultyModel);
		}

		return facultyModel;
	}
	public BankModelInt getBankModel() {

		BankModelInt bankModel = (BankModelInt) modelCache.get("bankModel");
		if (bankModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				bankModel = new BankModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("bankModel", bankModel);
		}

		return bankModel;
	}
	public EmployeeModelInt getEmployeeModel() {

		EmployeeModelInt employeeModel = (EmployeeModelInt) modelCache.get("employeeModel");
		if (employeeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				employeeModel = new EmployeeModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("employeeModel", employeeModel);
		}

		return employeeModel;
	}
	
	public ProductModelInt getProductModel() {

		ProductModelInt productModel = (ProductModelInt) modelCache.get("productModel");
		if (productModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
						modelCache.put("productModel", productModel);
		}

		return productModel;
	}
	public OrderModelInt getOrderModel() {

		OrderModelInt orderModel = (OrderModelInt) modelCache.get("orderModel");
		if (orderModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				orderModel = new OrderModelHibImp();
			}
			modelCache.put("orderModel", orderModel);
		}

		return orderModel;
	}
	
	public LessonModelInt getLessonModel() {

		LessonModelInt lessonModel = (LessonModelInt) modelCache.get("lesson");
		if (lessonModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				lessonModel = new LessonModelHibImp();
			}
						modelCache.put("lessonModel", lessonModel);
		}

		return lessonModel;
	}

	public HotelModelInt getHotelModel() {

		HotelModelInt hotelModel = (HotelModelInt) modelCache.get("hotelModel");
		if (hotelModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				hotelModel = new HotelModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("hotelModel", hotelModel);
		}

		return hotelModel;
	}

	public IssueModelInt getIssueModel() {

		IssueModelInt issueModel = (IssueModelInt) modelCache.get("issuelModel");
		if (issueModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				issueModel = new IssueModelHib();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("issueNodel", issueModel);
		}

		return issueModel;
	}
	
	public ProjectModelInt getProjectModel() {

		ProjectModelInt projectModel = (ProjectModelInt) modelCache.get("projectlModel");
		if (projectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				projectModel = new ProjectModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("projectModel", projectModel);
		}

		return projectModel;
	}
	
	public JobModelInt getJobModel() {

		JobModelInt jobModel = (JobModelInt) modelCache.get("joblModel");
		if (jobModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				jobModel = new JobModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("jobModel", jobModel);
		}

		return jobModel;
	}
	
	public SalaryModelInt getSalaryModel() {

		SalaryModelInt salaryModel = (SalaryModelInt) modelCache.get("salaryModel");
		if (salaryModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				salaryModel = new SalaryModelHibImp();
			}
			/*
			 * if ("JDBC".equals(DATABASE)) { bankModel = new UserModelJDBCImpl(); }
			 */
			modelCache.put("salaryModel", salaryModel);
		}

		return salaryModel;
	}
	
	public FieldModelInt getFieldModel() {

		FieldModelInt fieldModel = (FieldModelInt) modelCache.get("fieldModel");
		if (fieldModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				fieldModel = new FieldModelHibImp();
			}
			
			modelCache.put("fieldModel", fieldModel);
		}

		return fieldModel;
	}
	
	public OwnerModelInt getOwnerModel() {

		OwnerModelInt ownerModel = (OwnerModelInt) modelCache.get("ownerModel");
		if (ownerModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				ownerModel = new OwnerModelHibImp();
			}
			
			modelCache.put("fieldModel", ownerModel);
		}

		return ownerModel;
	}



	
	



																																					




}
