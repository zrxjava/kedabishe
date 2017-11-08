package service.impl;

import dao.IEmployeeDao;
import dao.impl.EmployeeDao;
import entity.Employee;
import service.IEmployeeService;
import utils.PageBean;

public class EmployeeService implements IEmployeeService{
	private IEmployeeDao employeeDao=new EmployeeDao();
	@Override
	public void getAll(PageBean<Employee> pb) {
		try {
			employeeDao.getAll(pb);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
