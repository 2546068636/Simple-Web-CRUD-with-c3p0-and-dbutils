package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.Bean;
import com.user.dao.Dao;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		String method =request.getParameter("method");
		if("update".equals(method)) {
			try {
				update(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("insert".equals(method)) {
			try {
				insert(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("delete".equals(method)) {
			try {
				delete(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("list".equals(method)) {
			try {
				list(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		List<Bean> list =Dao.queryUser();
		request.setAttribute("list", list);
		System.out.println("ajax");
		if(!list.isEmpty()) {
			request.setAttribute("message", "遍历成功");
			request.getRequestDispatcher("list.jsp").forward(request, response);
			String msg="success";
			response.getWriter().write(msg);
		}else {
			request.setAttribute("message", "遍历失败，即将返回主页");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			String msg="fail";
			response.getWriter().write(msg);
		}
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String sex=request.getParameter("sex");
		Bean b=new Bean();
		b.setName(name);
		b.setId(id);
		b.setSex(sex);
		if(Dao.deleteUser(b)) {
			request.setAttribute("message", "删除成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "删除失败，即将返回主页");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String sex=request.getParameter("sex");
		System.out.println(name+id+sex);
		Bean b=new Bean(name,id,sex);
		if(Dao.insertUser(b)) {
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "添加失败，即将返回主页");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String sex=request.getParameter("sex");
		Bean b=new Bean();
		b.setName(name);
		b.setId(id);
		b.setSex(sex);
		if(Dao.updateUser(b)){
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "修改失败，即将返回主页");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
