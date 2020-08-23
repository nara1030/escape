package assembler;

import member.service.ChangePasswordService;
import member.service.MemberRegisterService;
import member.service.impl.MemberDAO;

/*
 * ������� ��ü�� �����ϰ� ���� ��ü�� �������ִ� ����� �����Ѵ�.
 * ����, Ư�� ��ü�� �ʿ�� �ϴ� ���� ��ü�� �����Ѵ�(getter).
 * ���� MemberDAO Ŭ������ �ƴ϶� MemberDAO Ŭ������ ��ӹ��� CachedMemberDAO Ŭ������ ����ؾ� �Ѵٸ�,
 * Assembler���� ��ü�� �ʱ�ȭ���ִ� �κ��� �ڵ常 �������ָ� �ȴ�.
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
