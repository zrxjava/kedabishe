package dao;

import entity.Employee;
import utils.PageBean;

//�ӿ����
public interface IEmployeeDao {
	//��ҳ��ѯ����
	public void getAll(PageBean<Employee> pb);
	//��ѯ��¼��
	public int getTotalCount();
}
