package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URI 
		String uri=request.getRequestURI();
		//System.out.println(uri);
		uri=uri.substring(request.getContextPath().length()+1);
		//System.out.println(uri);
		EmpModel model=new EmpModel();
		String jsp="";
		if(uri.equals("emp/list.do")) //if문 대체 ==> annotation @RequestMapping("emp/list.do")
		{
			model.empListData(request); //HandlerMapping
			jsp="../emp/list.jsp"; //ViewResolver
		}
		else if(uri.equals("emp/detail.do"))
		{
			model.empDetailData(request);//@RequestMapping("emp/detail.do")
			jsp="../emp/detail.jsp";
		}
		//if문이 많다 => annotation 사용해라
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
