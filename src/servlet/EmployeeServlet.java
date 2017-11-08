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
 *控制层
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
			//获取当前页参数 如果第一次访问当前页为空 
			String currPage = request.getParameter("currentPage");
			if ( currPage==null || "".equals(currPage.trim())){
				currPage ="1"; //设置当前页为1
			}
			//转换
			int currentPage=Integer.parseInt(currPage);
			//创建pageBean 设置当前页参数
			PageBean<Employee> pageBean = new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			//调用service
			employeeService.getAll(pageBean); //被dao填充了数据
			
			//保存对象到域中
			request.setAttribute("pageBean", pageBean);
			//跳转
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
