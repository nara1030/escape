package member.service;

import member.exception.MemberNotFoundException;
import member.service.impl.MemberDAO;
import member.vo.Member;

public class ChangePasswordService {
	private MemberDAO memberDAO;
	
	public ChangePasswordService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDAO.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDAO.update(member);
	}
}
