package service;

import entity.Employee;
import utils.PageBean;

/*
 * ÒµÎñÂß¼­
 */
public interface IEmployeeService {
	public void getAll(PageBean<Employee> pb);
}
