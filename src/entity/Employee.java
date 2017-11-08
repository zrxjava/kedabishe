package entity;

//实体类设计（因为使用了dbutils 属性要与数据库字段名一致）
public class Employee {
	private int empId;
	private String empName;
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
