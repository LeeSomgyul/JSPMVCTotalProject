package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SeoulModel {
	// 테이블 이름
	private String[] table = {
			"",
			"seoul_location",
			"seoul_nature",
			"seoul_shop",
			"seoul_hotel"
	};
	
	private String[] title = {
			"",
			"서울 명소",
			"서울 자연",
			"서울 쇼핑",
			"서울 호텔"
	};
	
	@RequestMapping("seoul/list.do")
	public String seoul_list(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if(page == null)
			page="1";
		String tno = request.getParameter("tno");
		if(tno == null)
			tno="1";
		
		int curpage = Integer.parseInt(page);
		
		Map map = new HashMap();
		map.put("table", table[Integer.parseInt(tno)]);
		map.put("start", (curpage*12)-12);
		
		List<SeoulVO> list = SeoulDAO.seoulListData(map);
		int totalpage = SeoulDAO.seoulTotalPage(map);
		
		//출력 대상 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("tno", tno);
		request.setAttribute("title", title[Integer.parseInt(tno)]);
		
		//request를 받는 jsp 지정
		return "../seoul/list.jsp";
	}
	
	@RequestMapping("seoul/detail.do")
	public String seoul_detail(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		String tno = request.getParameter("tno");
		
		Map map = new HashMap();
		map.put("no", Integer.parseInt(no));
		map.put("table", table[Integer.parseInt(tno)]);
		
		SeoulVO vo = SeoulDAO.seoulDetailData(map);
		
		request.setAttribute("no", no);
		request.setAttribute("tno", tno);
		
		return "../seoul/detail.jsp";
	}
}
