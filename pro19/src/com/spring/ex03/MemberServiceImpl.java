package com.spring.ex03;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	//���̵�� �����ϰ� �����̸� ���� ���� ��� xml�� bean �̸��� memberDAO1�̶�� �� ��쿡��
	// setMemberDAO1 �̶�� ����� �Ѵ�.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMember() {

		memberDAO.listMembers();
	}

	
}
