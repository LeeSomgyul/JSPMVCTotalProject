package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.SeoulVO;

//seoul-mapper에서 id=""호출하여 직접 DB에 실행 
public class SeoulDAO {
	private static SqlSessionFactory ssf;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<SeoulVO> seoulListData(Map map){
		SqlSession session = ssf.openSession();
		List<SeoulVO> list = session.selectList("seoulListData",map);
		session.close();
		return list;
	}
	
	public static int seoulTotalPage(Map map) {
		SqlSession session = ssf.openSession();
		int total = session.selectOne("seoulTotalPage", map);
		session.close();
		return total;
	}
	
	public static SeoulVO seoulDetailData(Map map) {
		SqlSession session = ssf.openSession();
		
		String t = (String)map.get("table");
		if(!t.endsWith("hotel"))
			session.update("hitIncrement",map);
		
		SeoulVO vo = session.selectOne("seoulDetailData", map);
		session.close();
		return vo;
	}
}
