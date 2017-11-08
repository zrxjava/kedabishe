package utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//初始化连接池
//创建dbutils核心工具类
public class JdbcUtils {
	
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	//创建dbutils核心工具类
	public static QueryRunner getQueryRunner(){
		//传入了数据源对象 则不需要传连接对象，会自动获取连接，当然也不用关闭连接，会自动关闭
		QueryRunner qr=new QueryRunner(dataSource);
		return qr;
	}
}
