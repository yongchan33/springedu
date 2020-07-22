package com.kh.portfolio.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.member.vo.MemberVO;


@Repository
public class MemberDAOImplXML implements MemberDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImplXML.class);
	
	@Inject
	private SqlSession sqlSession;
	
	//회원 등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("MemberDAOImplXML.joinMember()호출됨");
		
		//mapper > namespace.id, prarmeterType
		return sqlSession.insert("mappers.MemberDAO-mapper.joinMember",memberVO);
	}
	
	//회원 수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		logger.info("MemberDAOImplXML.modifyMember()호출됨");
		return sqlSession.update("mappers.MemberDAO-mapper.modifyMember",memberVO);
	}
	
	//회원 전체조회
	@Override
	public List<MemberVO> listAllMember() {
		logger.info("MemberDAOImplXML.listAllMember()호출됨");
		
		return sqlSession.selectList("mappers.MemberDAO-mapper.listAllMember");
	}
	
	//회원 개별조회
	@Override
	public MemberVO listOneMember(String id) {
		logger.info("MemberDAOImplXML.listOneMember()호출됨");
		return sqlSession.selectOne("mappers.MemberDAO-mapper.listOneMember",id);
	}
	
	//회원 탈퇴
	@Override
	public int outMember(String id, String pw) {
		logger.info("MemberDAOImplXML.outMember()호출됨");
		//여러개 넘길게 있으면, 객체로 넘겨야댐.맵컬렉션에 담아서 넘김
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw",pw);
		
		
		return sqlSession.delete("mappers.MemberDAO-mapper.outMember",map);
	}
	//로그인
	@Override
	public MemberVO login(String id, String pw) {
		logger.info("MemberDAOImplXML.login()호출됨");
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw",pw);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.login",map);
	}
	
	//아이디 찾기
	@Override
	public String findID(String tel, String birth) {
		logger.info("MemberDAOImplXML.findID()호출됨");
		Map<String,String> map = new HashMap<>();
		map.put("tel",tel);
		map.put("birth",birth);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.findID",map);
	}
	
	//비밀번호 찾기
	@Override
	public String findPW(String id, String tel, String birth) {
		logger.info("MemberDAOImplXML.findPW()호출됨");
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("tel",tel);
		map.put("birth",birth);
		return sqlSession.selectOne("mappers.MemberDAO-mapper.findPW",map);

	}
	//비밀번호 변경
	@Override
	public int changePW(String id, String pw) {
		logger.info("MemberDAOImplXML.changePW()호출됨");
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw",pw);
		return sqlSession.update("mappers.MemberDAO-mapper.changePW",map);

	}
	
	//프로파일 이미지 조회
	@Override
	public byte[] findProfileImg(String id) {

		return null;
	}
	
	
}
