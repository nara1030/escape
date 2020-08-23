package member.service;

import java.util.Date;

import member.exception.AlreadyExistingMemberException;
import member.service.impl.MemberDAO;
import member.vo.Member;
import member.vo.RegisterRequest;

public class MemberRegisterService {
	private MemberDAO memberDAO;

	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void regist(RegisterRequest registerRequest) {
		Member member = memberDAO.selectByEmail(registerRequest.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + registerRequest.getEmail());
		}
		Member newMember = new Member(
				registerRequest.getEmail(),
				registerRequest.getPassword(),
				registerRequest.getName(),
				new Date());
		memberDAO.insert(newMember);
	}
}
