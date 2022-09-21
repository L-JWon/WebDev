package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자 요청 진입...");
		//EmpModel model=new EmpModel();
		System.out.println("요청처리...");
		//model.empListData(request);
		try {
			Class clsName=Class.forName("com.sist.model.EmpModel");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			methods[0].invoke(obj, request);
			//메소드명은 개발자 마음대로 제작할 수 있다 
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("request에 결과 값을 채운다");
		//request를 jsp로 다시 전송
		RequestDispatcher rd=request.getRequestDispatcher("../emp/emp2.jsp");
		rd.forward(request, response);
	}

}
