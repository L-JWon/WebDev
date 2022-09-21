package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  1. 요청 (.do)
 *     => DispatcherServlet => 요청 정보를 넘겨준다 누구한테?  request한테 => Model <==> DAO
 *              |           <=   처리 내용을 다시 넘겨준다
 *          request를  jsp 에게 다시 보내준다 (출력 담당)
 *          		
 */

@Controller
public class ReserveModel {
	@RequestMapping("reserve/reserve.do")
	public String reserve_main(HttpServletRequest request,HttpServletResponse response)
	{
		return "../reserve/reserve.jsp";
	}
	@RequestMapping("reserve/select.do")
	public String food_select(HttpServletRequest request,HttpServletResponse response)
	{
		String type=request.getParameter("type");
		if(type==null)
			type="한식";
		List<FoodVO> list=ReserveDAO.foodListData(type);
		request.setAttribute("list", list);
		return "../reserve/select.jsp";
	}
}








