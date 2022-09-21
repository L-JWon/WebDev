package com.sist.dao;
import java.util.*;
import java.sql.*;

//Model1 => MV => MVC (Spring) ==> 스프링에 포인트 
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//////////////////
	//드라이버 등록
	public EmpDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//class.forname => 리플렉션 (클래스 정보를 읽어와서 => 변수 초기화 나 메소드를 호출한다)
			//=> 리플렉션이 많이 쓰이는 곳 변수 초기화(Setter DI), 
			//메소드 호출 (Method DI) ********DI는 필수 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	//오라클 연결     메소드는 언제 만드냐 => 한개의 기능을 만들 때 (재사용), 중복을 제거할 때 
	//메소드와 함수의 차이점 => 함수는 독립적, 메소드는 클래스 종속
	//라이브러리와 프레임워크의 차이 => 라이브러리는 완제품 프레임워크는 레고  
	//dao와 service의 차이 =>
	public void getConnection() //ssf.openSession()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {}
	}
	//오라클 닫기
	public void disConnection() //session.close()
	{
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {}
	}
	////////////////// Config.xml 이 해주는 부분
	
	//기능 처리 
	// <select id="empListData" resultType="EmpVO">
	public List<EmpVO> empListData()//selectList();
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		try {
			getConnection(); //session=ssf.openSession();
			String sql="SELECT * FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				list.add(vo);
			}
			rs.close();
			// selectList
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection(); //session.close();
		}
		return list;
	}
	////////////////// mapper.xml(SQL, ResultType, ParameterType)
	
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo=new EmpVO();
		try {
			getConnection(); //session=ssf.openSession();
			String sql="SELECT * FROM emp WHERE empno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, empno); //parameterType="int"
			ResultSet rs=ps.executeQuery();
			rs.next();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));  //selectOne   while문이 돌아가면 selectList

			rs.close();
			// selectList
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection(); //session.close();
		}
		return vo;
	}
}
