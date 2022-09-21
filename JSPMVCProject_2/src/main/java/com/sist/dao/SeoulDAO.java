package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class SeoulDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*
<select id="seoulListData" resultType="vo" parameterType="hashmap">
 SELECT no,title,poster,msg,address,num
 FROM (SELECT no,title,poster,msg,address,rownum AS num
 FROM SELECT no,title,poster,msg,address
 FROM seoul_location))
</select>
	 */
	public static List<SeoulVO> seoulListData(Map map)
	{
		SqlSession session=null;
		List<SeoulVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("seoulListData", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
}
