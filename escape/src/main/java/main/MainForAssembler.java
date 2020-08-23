package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import member.exception.AlreadyExistingMemberException;
import member.exception.IdPasswordNotMatchingException;
import member.exception.MemberNotFoundException;
import member.service.ChangePasswordService;
import member.service.MemberRegisterService;
import member.vo.RegisterRequest;

public class MainForAssembler {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("��ɾ �Է��ϼ���:");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("�����մϴ�.");
				break;
			}
			if(command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("��ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.\n");
			return;
		}
		
		try {
			regSvc.regist(request);	// ���� ó�� ���ߴµ��� �����Ѵ�?
			System.out.println("����߽��ϴ�.\n");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("�̹� �����ϴ� �̸����Դϴ�.\n");
		}
	}
	
	private static void processChangeCommand(String[] args) {
		if(args.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
		
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);	// ���� ó�� ���ߴµ��� �����Ѵ�?
			System.out.println("��ȣ�� �����߽��ϴ�.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("�������� �ʴ� �̸����Դϴ�.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("�̸��ϰ� ��ȣ�� ��ġ���� �ʽ��ϴ�.\n");
		}
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("�߸��� ����Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("��ɾ� ����:");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� ������ ������");
		System.out.println();
	}
}
