package com.kh.portpolio.member.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOImplXMLest2 {

	private final static Logger logger
		= LoggerFactory.getLogger(MemberDAOImplXMLest2.class);

	@Inject
	//@Qualifier : spring 컨테이너에 동일타입의 bean이 존재할경우 명시적으로 참조하고자하는 bean을 지정할때 사용
	//spring 컨테이너에서 관리되는 bean이름은 특별히 지정해주지않으면 클래스명을 기본값으로 갖는다.
	@Qualifier("memberDAOImplXML")	//소문자로 들어감, 
	MemberDAO memberDAO;
	
	
	@Test			//테스트 대상에서 포함할때
	@DisplayName("회원등록")
	@Disabled //테스트 대상에서 제외할때
		//디폴트 = 이름으로 구별,해당클래스함수를 호출
	void joinMember() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test6@test.com");
		memberVO.setPw("1234");
		memberVO.setTel("010-1224-5578");
		memberVO.setNickname("관리자5");
		memberVO.setGender("여");
		memberVO.setRegion("울산");
		memberVO.setBirth(java.sql.Date.valueOf("2002-01-02"));

		int cnt = memberDAO.joinMember(memberVO);
		
		logger.info("cnt:"+cnt);
	}
	//실패
	@Test
	@DisplayName("회원수정")
	@Disabled
	void modifyMember() {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test3@test.com");
		memberVO.setPw("1234");
		memberVO.setTel("010-1234-5678");
		memberVO.setNickname("수정된관리자4");
		memberVO.setGender("여");
		memberVO.setRegion("경기");
		memberVO.setBirth(java.sql.Date.valueOf("2000-01-03"));
		
		int cnt = memberDAO.modifyMember(memberVO);
		
		Assertions.assertEquals(1,cnt);
		logger.info("cnt:"+cnt);
	}
	//아직안해봄
	@Test
	@DisplayName("회원전체조회")
	@Disabled
	void listAllMember() {
		
		List<MemberVO> list = memberDAO.listAllMember();
		
		for(MemberVO memberVO : list) {
			logger.info(memberVO.toString());
		}
	}
	
	@Test
	@DisplayName("회원조회(개인)")
	@Disabled
	void listOneMember() {
		String id = "test@google.com";
		MemberVO memberVO = memberDAO.listOneMember(id);
			logger.info(memberVO.toString());
		
	}
	
	@Test
	@DisplayName("회원탈퇴")
	@Disabled
	void outMember() {
		String id = "test5@test.com";
		String pw = "1234";
		int cnt = memberDAO.outMember(id, pw);
		logger.info("cnt:"+cnt);
	}
	
	@Test
	@DisplayName("로그인")
	@Disabled
	void login() {
		String id = "test@google.com";
		String pw = "1234";
		MemberVO memberVO = memberDAO.login(id, pw);
		logger.info(memberVO.toString());
	}
	@Test
	@DisplayName("아이디찾기")
	@Disabled
	void findID() {
		String tel = "010-1254-7895";
		String birth = "00-01-02";
		String id = memberDAO.findID(tel, birth);
		logger.info(id);
	}
	
	@Test
	@DisplayName("비밀번호찾기")
	@Disabled
	void findPW() {
		String id = "test@google.com";
		String tel = "010-1254-7895";
		String birth = "00-01-02";
		String pw = memberDAO.findPW(id,tel, birth);
		Assertions.assertEquals("1234",pw);	//값이 같으면 통과
		logger.info(pw);
	}
	
	@Test
	@DisplayName("비밀번호변경")
	@Disabled
	void changePW() {
		String id = "test@google.com";
		String pw = "4321";
		int cnt = memberDAO.changePW(id,pw);
		Assertions.assertEquals(pw,memberDAO.listOneMember(id).getPw());
		logger.info("cnt = "+cnt);
	}

}



