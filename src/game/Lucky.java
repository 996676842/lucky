package game;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
	static int count = 0;
	static int i;
	static int number = 0;
	static boolean status = false;
	static int[] luckyNumber = new int[10];;
	static String[] name = new String[10];
	static String[] password = new String[10];

	public static void main(String[] args) {
		int key = 0;
		while (true) {
			key = showMenu();
			switch (key) {
			// ע��
			case 1:
				register();
				break;
			// ��½
			case 2:
				login();
				break;
			// �齱
			case 3:
				lottery();
				break;
			default:
				System.out.println("�������");
				break;
			}
			if (count >= 3) {
				System.out.println("�������������࣬���������");
				break;
			}
			boolean toExit = verifyExit();
			if (toExit) {
				break;
			}

		}
	}

	private static boolean verifyExit() {
		System.out.println("�Ƿ������Y/N");
		return "N".equalsIgnoreCase(new Scanner(System.in).next().trim());
	}

	// ���˵�
	public static int showMenu() {
		System.out.println("*********��ӭ���뽱�͸���ϵͳ**********");
		System.out.println("1.ע��");
		System.out.println("2.��½");
		System.out.println("3.�齱");
		System.out.println("*********************************");
		System.out.println("��ѡ��˵���");
		Scanner input = new Scanner(System.in);
		return input.nextInt();

	}

	// ע��
//	 public static void register() {
//	 boolean k=true;
//	 int a=1;
//	 System.out.println("[���͸���ϵͳ > ע��]");
//	 status = false;
//	 while(k){
//	 Scanner input = new Scanner(System.in);
//	 System.out.println("����д������Ϣ��");
//	 System.out.println("�û���");
//	 name[i] = input.nextLine();
//	 System.out.println("����");
//	 password[i] = input.nextLine();
//	 for (int j = 0; j < i; j++) {
//	 if (name[i].equals(name[j])) {
//	 System.out.println("�û��Ѵ��ڣ�������ע�ᣡ");
//	 a=a+1;
//	 }
//	 }
//	 if((a==1&&i!=0)||i==0){
//	 luckyNumber[i] = new Random().nextInt(9) + 1;
//	 System.out.println("���ס�����������");
//	 System.out.println("�û���" + name[i]);
//	 System.out.println("����" + password[i]);
//	 System.out.println("��������" + luckyNumber[i]);
//	 i=i+1;
//	 a=0;
//	 k=false;
//	 }
//	 }
//	 }
	public static void register() {
		boolean flag=true;
	     //boolean f1=true;
		//int a=0;
		while(flag){
		System.out.println("ע��");
		System.out.println("�����������Ϣ��");
		Scanner input = new Scanner(System.in);
		System.out.println("�������û���");
		System.out.println("����������");
		name[i] = input.next();
		
		password[i] = input.next();
		for (int j = 0; j <i; j++) {
			if (name[i].equals(name[j])) {
				System.out.println("�û��˺��Ѿ����ڣ�������ע��");
				flag=false;
				//a++;
				//f1=false;
			}
		}
		if(flag==true)
		//if(f1==true&&flag==true)
		//if((a==0&&i!=0)||i==0)
		{
		System.out.println("���ס�����������");
		System.out.println("�û���" + name[i]);
		 System.out.println("����" + password[i]);
		 System.out.println("��������" + luckyNumber[i]);
		i++;
		flag=false;
	 
		}}
	}

	// ��½
	public static void login() {

		System.out.println("[���͸���ϵͳ > ��½]");
		System.out.println("�������û�������");
		System.out.println("�������û����룺");
		Scanner input = new Scanner(System.in);
		String name1 = input.nextLine();
		String password1 = input.nextLine();
		for (int i = 0; i < 10; i++) {
			if (name1.equals(name[i]) && password1.equals(password[i])) {
				System.out.println("��ӭ����" + name1);
				status = true;
				number = luckyNumber[i];
			}
		}
		if (status == false) {
			System.out.println("�����������˻�������");
			count = count + 1;
		}
	}

	public static void lottery() {

		if (status == true) {
			int[] luckyyNum = new int[5];
			System.out.println("���Ļ�Ա���ǣ�" + number);
			System.out.println("��������������:");
			for (int i = 0; i < luckyyNum.length; i++) {
				luckyyNum[i] = new Random().nextInt(9) + 1;
				for (int j = 0; j < i; j++) {
					if (luckyyNum[i] == luckyyNum[j]) {
						luckyyNum[i] = new Random().nextInt(9) + 1;
					}

				}
				System.out.print(luckyyNum[i] + "\t");
			}
			if (luckyyNum[i] == number) {
				System.out.println("�����ˣ����Ϊ����������û���");
			} else {
				System.out.println("���ź���");
			}

		} else {
			System.out.println("���¼");
		}

	}

}
