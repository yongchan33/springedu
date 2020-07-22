package com.kh.portpolio;

import javax.inject.Inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class test {

	//이렇게하면 서버를 스타트하지 않고 테스트가 가능함.
	private final static Logger logger = LoggerFactory.getLogger(test.class);
	
	@Inject
	MemberDAO memberDAO;
	
	@Test
	@DisplayName("회원등록")
	void test1() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test3@test.com");
		memberVO.setPw("12344");
		memberVO.setTel("010-1254-7895");
		memberVO.setNickname("관리자4");
		memberVO.setGender("남");
		memberVO.setRegion("부산");
		memberVO.setBirth(java.sql.Date.valueOf("2000-01-02"));
		
		int cnt = memberDAO.joinMember(memberVO);
		
		logger.info("cnt"+cnt);
	}
}
