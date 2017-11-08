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
		//1 查询总记录数 
		int totalCount = this.getTotalCount(); //总记录数
		pb.setTotalCount(totalCount);
		//判断
		if(pb.getCurrentPage()<1){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		//2 获取当前页 计算查询的起始行和返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount(); //查询的起始行
		int count = pb.getPageCount(); //查询返回的行数
		//3 分页查询数据 把查到的数据设置到pb对象中
		String sql="select * from employee limit ?,?";
		try {
			QueryRunner qr = JdbcUtils.getQueryRunner();
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index,count);
			//设置到pb中
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
