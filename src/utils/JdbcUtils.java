package utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//��ʼ�����ӳ�
//����dbutils���Ĺ�����
public class JdbcUtils {
	
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	//����dbutils���Ĺ�����
	public static QueryRunner getQueryRunner(){
		//����������Դ���� ����Ҫ�����Ӷ��󣬻��Զ���ȡ���ӣ���ȻҲ���ùر����ӣ����Զ��ر�
		QueryRunner qr=new QueryRunner(dataSource);
		return qr;
	}
}
