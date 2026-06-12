package com.sist.vo;

import lombok.Data;

//DB에서 가져온 값을 담는 바구니
@Data
public class SeoulVO {
	private int no,hit;
	private String title,poster,msg,address;
}
