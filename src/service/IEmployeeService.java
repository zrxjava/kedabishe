package service;

import entity.Employee;
import utils.PageBean;

/*
 * ҵ���߼�
 */
public interface IEmployeeService {
	public void getAll(PageBean<Employee> pb);
}
