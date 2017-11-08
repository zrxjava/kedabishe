package dao;

import entity.Employee;
import utils.PageBean;

//接口设计
public interface IEmployeeDao {
	//分页查询数据
	public void getAll(PageBean<Employee> pb);
	//查询记录数
	public int getTotalCount();
}
