package assembler;

import member.service.ChangePasswordService;
import member.service.MemberRegisterService;
import member.service.impl.MemberDAO;

/*
 * 조립기는 객체를 생성하고 의존 객체를 주입해주는 기능을 제공한다.
 * 또한, 특정 객체를 필요로 하는 곳에 객체를 제공한다(getter).
 * 만약 MemberDAO 클래스가 아니라 MemberDAO 클래스를 상속받은 CachedMemberDAO 클래스를 사용해야 한다면,
 * Assembler에서 객체를 초기화해주는 부분의 코드만 변경해주면 된다.
 */
public class Assembler {
	private MemberDAO memberDAO;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDAO = new MemberDAO();
		regSvc = new MemberRegisterService(memberDAO);
		pwdSvc = new ChangePasswordService(memberDAO);
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
	
	
}
