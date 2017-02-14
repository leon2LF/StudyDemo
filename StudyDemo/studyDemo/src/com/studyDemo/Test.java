package com.studyDemo;

import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cars []cars ={new Trunk(1,"小货车",1000f,2.3f), new Trunk(2,"大货车",1500f,5.4f),new Coach(3,"轿车",200f,4),new Coach(4,"金蝶",300f,7),new pichuk(5,"皮卡",250f,2.3f,4)};
		System.out.println("欢迎使用达达租车系统-----------\n是否使用租车系统：1，租车\t 2.退出");
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
		if(in == 1){
			System.out.println("序号\t类型\t价格\t载客/载货量\n");
			for(int i=0 ;i<5;i++){
				System.out.println(cars[i]);
			}								
			float sum = 0.0f;
			float capacity1=0.0f;
			int capacity2=0;
			String[] car1=new String[6];
			String[] car2=new String[6];
			for(int i=1;;i++){
				System.out.print("请输入你要购买第"+ i +"辆车的序号:");
				int id=input.nextInt();
				System.out.print("请输入你要租用的数量:");
				int qty=input.nextInt();
				System.out.print("请输入你要租用的天数:");
				int day=input.nextInt();
				switch(id){
				case 1:	sum+=qty*day*cars[0].price;car1[i-1]=cars[0].name;capacity1+=qty*cars[0].carryingCapacity;break;
				case 2: sum+=qty*day*cars[1].price;car1[i-1]=cars[1].name;capacity1+=qty*cars[1].carryingCapacity;break;
				case 3: sum+=qty*day*cars[2].price;car2[i-1]=cars[2].name;capacity2+=qty*cars[2].carryingSeat;break;
				case 4: sum+=qty*day*cars[3].price;car2[i-1]=cars[3].name;capacity2+=qty*cars[3].carryingSeat;break;
				case 5: sum+=qty*day*cars[4].price;car1[i-1]=cars[4].name;car2[i-1]=cars[4].name;capacity1+=qty*cars[4].carryingCapacity;capacity2+=qty*cars[4].carryingSeat;break;
				case 6: sum+=qty*day*cars[5].price;car1[i-1]=cars[5].name;car2[i-1]=cars[5].name;capacity1+=qty*cars[5].carryingCapacity;capacity2+=qty*cars[5].carryingSeat;break;
				default : System.out.print("输入错误,");i--;break;
				}
				
				System.out.println("是否继续租车:1.继续\t2.退出");
				int choose=input.nextInt();
				if(choose==2){
					break;
					}
				}
			System.out.println("--------------------------\n租车成功,您的账单:\n可载货的车:");
			for(int i=0;i<car1.length;i++){
				if(car1[i]==null){
					continue;
					}
				System.out.print(car1[i]+'\t');
				}
			System.out.println("共载货:"+capacity1+"吨\n可载人的车:");
			for(int i=0;i<car2.length;i++){
				if(car2[i]==null){
					continue;
					}
				System.out.print(car2[i]+'\t');
				}
			System.out.println("共载人:"+capacity2+"人\n租车共需付款:"+sum+"元");
		}else{
			System.out.println("已退出哒哒租车系统");
			}
		input.close();
		
	}

}
