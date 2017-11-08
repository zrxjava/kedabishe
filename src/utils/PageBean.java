package utils;

import java.util.List;

/*
 * ��װ��ҳ�Ĳ���
 */
public class PageBean<T> {
	private int currentPage=1;            //��ǰҳ Ĭ����ʾ��һҳ
	private int pageCount=4;            //��ѯ���ص�����, Ĭ��ÿҳ��ʾ4��
	private int totalCount;                 //�ܼ�¼��
	private int totalPage;                   //��ҳ��=�ܼ�¼��/ÿҳ��ʾ������ ��������һ
	private  List<T> pageData;                //��ҳ��ѯ��������
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(totalCount % pageCount==0){
			totalPage=totalCount /pageCount;
		}else{
			totalPage=totalCount / pageCount+1;
		}
			
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
}
