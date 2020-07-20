package com.kh.portfolio.test;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rtest")
public class RestController {
	private static Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@GetMapping(value="/1", produces="application/json")
	public Person getMemberJson() {
		Person p1 = new Person("홍길동",30);
		
		return p1;
	}
	@GetMapping(value="/2", produces="application/xml")
	public Person getMemberXml() {
		Person p1 = new Person("홍길동",30);
		
		return p1;
	}
	@GetMapping(value="/3", produces="application/json")
	public List<Person> getMembersJson() {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("홍길동",30));
		list.add(new Person("홍길동1",40));
		list.add(new Person("홍길동2",50));
		list.add(new Person("홍길동3",60));
		list.add(new Person("홍길동4",70));
		list.add(new Person("홍길동5",80));
		
		return list;
	}
	@GetMapping(value="/4", produces="application/json")
	public Map<String,Person> getMembersJson2() {
		Map<String,Person> map = new HashMap<>();
		
		map.put("1", new Person("홍길동1",10));
		map.put("2", new Person("홍길동2",20));
		map.put("3", new Person("홍길동3",30));
		map.put("4", new Person("홍길동4",40));
		map.put("5", new Person("홍길동5",50));
		
		
		return map;
	}
	@GetMapping(value="/6", produces="application/xml")
	public Map<String,Person> getMembersXML2() {
		Map<String,Person> map = new HashMap<>();
		
		map.put("1", new Person("홍길동1",10));
		map.put("2", new Person("홍길동2",20));
		map.put("3", new Person("홍길동3",30));
		map.put("4", new Person("홍길동4",40));
		map.put("5", new Person("홍길동5",50));
		
		
		return map;
	}
	@GetMapping(value="/7", produces="application/json")
	public String[] getStirng1() {
		String[] names = {"홍1","홍2","홍3"};

		return names;
	}
	@GetMapping(value="/8", produces="application/xml")
	public String[] getStirng2() {
		String[] names = {"홍1","홍2","홍3"};

		return names;
	}
	@GetMapping(value="/9/{number}", produces="application/json")
	public Person test1(
			@PathVariable("number") String number
			
			) {
		Map<String,Person> map = new HashMap<>();
		Person p1 = null;
		map.put("1", new Person("홍길동1",10));
		map.put("2", new Person("홍길동2",20));
		map.put("3", new Person("홍길동3",30));
		map.put("4", new Person("홍길동4",40));
		map.put("5", new Person("홍길동5",50));
		
		
		p1= map.get(number);
		
		return p1;
	}
	
	@GetMapping(value="/10/{number}", produces="application/json")
	public ResponseEntity<Person> test2(
			@PathVariable("number") String number){
			ResponseEntity<Person> res = null;
			
			Person p1 = null;
		
		Map<String,Person> map = new HashMap<>();

		map.put("1", new Person("홍길동1",10));
		map.put("2", new Person("홍길동2",20));
		map.put("3", new Person("홍길동3",30));
		map.put("4", new Person("홍길동4",40));
		map.put("5", new Person("홍길동5",50));
		
		
		p1= map.get(number);
		
		if(p1 !=null) {
			res = new ResponseEntity<Person>(p1,HttpStatus.OK);
		}else {
			res = new ResponseEntity<Person>(p1,HttpStatus.BAD_REQUEST);
		}
		
		
		return res;
	}
	

	
	
	
	
	@GetMapping(value="/11/{number}", produces="application/json")
	public ResponseEntity<Map> test3(
			@PathVariable("number") String number){
			ResponseEntity<Map> res = null;
			
			Person p1 = null;
		
		Map<String,Person> map = new HashMap<>();

		map.put("1", new Person("홍길동1",10));
		map.put("2", new Person("홍길동2",20));
		map.put("3", new Person("홍길동3",30));
		map.put("4", new Person("홍길동4",40));
		map.put("5", new Person("홍길동5",50));
		
		
		p1= map.get(number);
		
		Map result = new HashMap();
		
		
		
		if(p1 !=null) {
			result.put("rtcode","00");
			result.put("msg","성공!!");
			result.put("result", p1);
			res = new ResponseEntity<Map>(result,HttpStatus.OK);
		}else {
			result.put("rtcode","01");
			result.put("msg","실패!!");
			res = new ResponseEntity<Map>(result,HttpStatus.BAD_REQUEST);
		}
		
		
		return res;
	}
}
