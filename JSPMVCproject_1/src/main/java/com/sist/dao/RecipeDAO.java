package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.RecipeVO;

import java.io.*;

public class RecipeDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<RecipeVO> recipeListData(Map map)
	{
		SqlSession session=ssf.openSession();
		List<RecipeVO> list=session.selectList("recipeListData", map);
		session.close();
		return list;
	}
}
