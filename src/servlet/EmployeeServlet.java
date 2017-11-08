package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;
import utils.PageBean;

/**
 *���Ʋ�
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private IEmployeeService employeeService = new EmployeeService();

    public EmployeeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			//��ȡ��ǰҳ���� �����һ�η��ʵ�ǰҳΪ�� 
			String currPage = request.getParameter("currentPage");
			if ( currPage==null || "".equals(currPage.trim())){
				currPage ="1"; //���õ�ǰҳΪ1
			}
			//ת��
			int currentPage=Integer.parseInt(currPage);
			//����pageBean ���õ�ǰҳ����
			PageBean<Employee> pageBean = new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			//����service
			employeeService.getAll(pageBean); //��dao���������
			
			//�����������
			request.setAttribute("pageBean", pageBean);
			//��ת
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
