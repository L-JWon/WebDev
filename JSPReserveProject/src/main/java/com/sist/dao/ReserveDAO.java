package com.sist.dao;
import java.io.*;
import java.util.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ReserveDAO {
	// xml 파싱
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
    <select id="foodListData" resultType="com.sist.dao.FoodVO" parameterType="String">
	  SELECT fno,name,poster,rownum
	  FROM food_location
	  WHERE rownum&lt;=50
	  AND type LIKE '%'||#{type}||'%'
	  ORDER BY fno ASC
   </select>
   */
	public static List<FoodVO> foodListData(String type)
	{
		SqlSession session=ssf.openSession();
		List<FoodVO> list=session.selectList("foodListData", type);
		session.close();
		return list;
	}
}
