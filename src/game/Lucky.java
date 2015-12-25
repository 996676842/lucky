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
			// 注册
			case 1:
				register();
				break;
			// 登陆
			case 2:
				login();
				break;
			// 抽奖
			case 3:
				lottery();
				break;
			default:
				System.out.println("输入错误！");
				break;
			}
			if (count >= 3) {
				System.out.println("输入错误次数过多，程序结束！");
				break;
			}
			boolean toExit = verifyExit();
			if (toExit) {
				break;
			}

		}
	}

	private static boolean verifyExit() {
		System.out.println("是否继续？Y/N");
		return "N".equalsIgnoreCase(new Scanner(System.in).next().trim());
	}

	// 主菜单
	public static int showMenu() {
		System.out.println("*********欢迎进入奖客富翁系统**********");
		System.out.println("1.注册");
		System.out.println("2.登陆");
		System.out.println("3.抽奖");
		System.out.println("*********************************");
		System.out.println("请选择菜单：");
		Scanner input = new Scanner(System.in);
		return input.nextInt();

	}

	// 注册
//	 public static void register() {
//	 boolean k=true;
//	 int a=1;
//	 System.out.println("[奖客富翁系统 > 注册]");
//	 status = false;
//	 while(k){
//	 Scanner input = new Scanner(System.in);
//	 System.out.println("请填写个人信息：");
//	 System.out.println("用户名");
//	 name[i] = input.nextLine();
//	 System.out.println("密码");
//	 password[i] = input.nextLine();
//	 for (int j = 0; j < i; j++) {
//	 if (name[i].equals(name[j])) {
//	 System.out.println("用户已存在，请重新注册！");
//	 a=a+1;
//	 }
//	 }
//	 if((a==1&&i!=0)||i==0){
//	 luckyNumber[i] = new Random().nextInt(9) + 1;
//	 System.out.println("请记住你的幸运数字");
//	 System.out.println("用户名" + name[i]);
//	 System.out.println("密码" + password[i]);
//	 System.out.println("幸运数字" + luckyNumber[i]);
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
		System.out.println("注册");
		System.out.println("请输入个人信息：");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名");
		System.out.println("请输入密码");
		name[i] = input.next();
		
		password[i] = input.next();
		for (int j = 0; j <i; j++) {
			if (name[i].equals(name[j])) {
				System.out.println("用户账号已经存在，请重新注册");
				flag=false;
				//a++;
				//f1=false;
			}
		}
		if(flag==true)
		//if(f1==true&&flag==true)
		//if((a==0&&i!=0)||i==0)
		{
		System.out.println("请记住你的幸运数字");
		System.out.println("用户名" + name[i]);
		 System.out.println("密码" + password[i]);
		 System.out.println("幸运数字" + luckyNumber[i]);
		i++;
		flag=false;
	 
		}}
	}

	// 登陆
	public static void login() {

		System.out.println("[奖客富翁系统 > 登陆]");
		System.out.println("请输入用户姓名：");
		System.out.println("请输入用户密码：");
		Scanner input = new Scanner(System.in);
		String name1 = input.nextLine();
		String password1 = input.nextLine();
		for (int i = 0; i < 10; i++) {
			if (name1.equals(name[i]) && password1.equals(password[i])) {
				System.out.println("欢迎您：" + name1);
				status = true;
				number = luckyNumber[i];
			}
		}
		if (status == false) {
			System.out.println("密码错误或者账户不存在");
			count = count + 1;
		}
	}

	public static void lottery() {

		if (status == true) {
			int[] luckyyNum = new int[5];
			System.out.println("您的会员号是：" + number);
			System.out.println("本日幸运数字是:");
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
				System.out.println("很幸运，你成为今天的幸运用户！");
			} else {
				System.out.println("很遗憾！");
			}

		} else {
			System.out.println("请登录");
		}

	}

}
