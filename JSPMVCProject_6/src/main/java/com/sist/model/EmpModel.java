package com.sist.model;
import java.util.*;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import javax.servlet.http.HttpServletRequest;

/*
    EmpDAO dao=new EmpDAO();
 	List<EmpVO> list=dao.empListData();
 */
public class EmpModel {
	@RequestMapping("emp/list.do")
	public String empListData(HttpServletRequest request)
	{
	    EmpDAO dao=new EmpDAO();
	 	List<EmpVO> list=dao.empListData();
	 	// 이 리스트를 jsp로 전송
	 	request.setAttribute("list", list);
	 	return"../emp/list.jsp";
	}
	@RequestMapping("emp/detail.do")
	public String empDetailData(HttpServletRequest request)
	{
		EmpDAO dao=new EmpDAO();
		String empno=request.getParameter("empno");
		EmpVO vo=dao.empDetailData(Integer.parseInt(empno));

		// 이 리스트를 jsp로 전송
		request.setAttribute("vo", vo);
		return "../emp/detail.jsp";
	}
	
}
