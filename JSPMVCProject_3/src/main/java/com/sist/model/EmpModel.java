package com.sist.model;
import java.util.*;
import com.sist.dao.*;
import javax.servlet.http.HttpServletRequest;

/*
    EmpDAO dao=new EmpDAO();
 	List<EmpVO> list=dao.empListData();
 */
public class EmpModel {
	public void empListData(HttpServletRequest request)
	{
	    EmpDAO dao=new EmpDAO();
	 	List<EmpVO> list=dao.empListData();
	 	// 이 리스트를 jsp로 전송
	 	request.setAttribute("list", list);
	}
}
