<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.sist.dao.*"%>
 <%
 	EmpDAO dao=new EmpDAO();
 	List<EmpVO> list=dao.empListData();//여기 코딩이 => Model로 감 
 									   // 순수하게 자바 코딩을 위해서 
 	
 %>
<%--
	지시자 : page (import , 변환 코드)
		    taglib (제어문)
	
	내장객체 => request, response, session, ... cookie, application
			  -------  --------  -------			  -----------
			  					 모든 jsp에서 공유       getRealPath()
						응답(HTML,Cookie)  
			  사용자 요청값 
			  getParameter()
			  setAttribute() :기존의 리퀘스트를 받아서 리퀘스트에 값을 추가해서 보내줌
			  setCharacterEncoding() => 한글 디코딩 
	--------------------------------------------------------------- Spring, Spring-Boot
												request, response를 가급적 사용금지 (권장)
												================= 클래스 캡슐화(Model)
												class Model
												{
													httpServletRequest request;
													public void addAttribute(String key,Object obj)
													{
														request.setAttribute(key,obj);
													}
												}
	EL => ${requestScope.key}, ${sessionScope.key}, ${객체명.변수명} 
	        ------------ 생략 가능
	JSTL => <c:forEach>, <c:if>, <c:choose> 
	
	==> a.jsp?no=10
	    -----얘한테 보내는데 no값을 10을 보낸다
	    
	    C/S ==> 주거니 받거니 하는 것
	    --- 네트워크 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style type="text/css">
  .cotainer{
  margin-top: 50px;
  }
  .row{
  margin: 0px auto;
  width: 960px;
  }
  </style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h1 class="text-center">사원 목록</h1>
      <table class="table table-hover">
        <tr class="danger">
           <th class="text-center">사번</th>
           <th class="text-center">이름</th>
           <th class="text-center">직위</th>
           <th class="text-center">사수번호</th>
           <th class="text-center">입사일</th>
           <th class="text-center">급여</th>
           <th class="text-center">성과급</th>
           <th class="text-center">부서번호</th> 
        </tr>
        <%
        for(EmpVO vo:list)
        {
        %>
        <tr class="danger">
           <td class="text-center"><%=vo.getEmpno() %></td>
           <td class="text-center"><%=vo.getEname() %></td>
           <td class="text-center"><%=vo.getJob() %></td>
           <td class="text-center"><%=vo.getMgr() %></td>
           <td class="text-center"><%=vo.getHiredate().toString() %></td>
           <td class="text-center"><%=vo.getSal() %></td>
           <td class="text-center"><%=vo.getComm() %></td>
           <td class="text-center"><%=vo.getDeptno() %></td> 
        </tr>
        <%
        }
        %>
      </table>
    </div>
  </div>
</body>
</html>