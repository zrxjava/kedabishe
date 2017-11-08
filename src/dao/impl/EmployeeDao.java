package dao.impl;


import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.IEmployeeDao;
import entity.Employee;
import utils.JdbcUtils;
import utils.PageBean;

public class EmployeeDao implements IEmployeeDao{

	@Override
	public void getAll(PageBean<Employee> pb) {
		//1 ��ѯ�ܼ�¼�� 
		int totalCount = this.getTotalCount(); //�ܼ�¼��
		pb.setTotalCount(totalCount);
		//�ж�
		if(pb.getCurrentPage()<1){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//2 ��ȡ��ǰҳ �����ѯ����ʼ�кͷ��ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount(); //��ѯ����ʼ��
		int count = pb.getPageCount(); //��ѯ���ص�����
		//3 ��ҳ��ѯ���� �Ѳ鵽���������õ�pb������
		String sql="select * from employee limit ?,?";
		try {
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index,count);
			//���õ�pb��
			pb.setPageData(pageData);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from employee";
		try {
			QueryRunner qr=JdbcUtils.getQueryRunner();
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
