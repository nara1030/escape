package member.service.impl;

import java.util.HashMap;
import java.util.Map;

import member.vo.Member;

/*
 * 아직 스프링을 이용해 DB를 연동하는 방법을 배우지 않았으므로,
 * 자바의 Map을 이용해 연동한다.
 */
public class MemberDAO {
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}
