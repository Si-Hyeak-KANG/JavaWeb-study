package com.spring.ex03;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	//아이디와 동일하게 세터이름 설정 예를 들어 xml에 bean 이름을 memberDAO1이라고 할 경우에는
	// setMemberDAO1 이라고 해줘야 한다.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMember() {

		memberDAO.listMembers();
	}

	
}
