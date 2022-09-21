package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class SeoulModel {
	@RequestMapping("seoul/list.do")
	public String seoulListData(HttpServletRequest request, HttpServletResponse response)
	{
		
		Map map=new HashMap();
		map.put("start", 1);
		map.put("end", 12);
		List<SeoulVO> list=SeoulDAO.seoulListData(map);
		request.setAttribute("list", list);
		return "../seoul/list.jsp";
	}
}
