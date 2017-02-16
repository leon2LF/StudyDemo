package com.lean.test;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest tct = new TryCatchTest();
//		int result = tct.test();
//		System.out.println("test()方法执行完毕，返回结果result为："+ result);
//		int result2 = tct.test2();
//		System.out.println("test2()执行完毕！！");
		int result = tct.test3();
		System.out.println("test3完事后轮到我登场了,结果result是："+ result);
		
	}
	
	/**
	 * divider(除数):
	 * result(结果):
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result + 100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！” 返回 -1
	 * 否则，返回result
	 */
	public int test(){
		int divider =10;
		int result = 100;
		try{
			while(divider >-1){
				divider--;
				result += 100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环跑出异常了！！");
			return -1;
		}
		
	}
	
	
	/**
	 * divider(除数):
	 * result(结果):
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result + 100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！” 返回 999
	 * 否则，返回result
	 * finally：打印输出“这是finally！！” 同时打印输出resulte 结果
	 */
	public  int test2(){
		int divider =10;
		int result = 100;
		try{
			while(divider >-1){
				divider--;
				result += 100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环跑出异常了！！");
			return result = 999;
		}finally{
			System.out.println("这是finally！！");
			System.out.println("我是result！值为："+result);
		}
		
	}

	
	/**
	 * divider(除数):
	 * result(结果):
	 * try-catch捕获while循环
	 * 每次循环，divider减一，result=result + 100/divider
	 * 如果捕获异常，打印输出“抛出异常了！！” 返回 999
	 * 否则，返回result
	 * finally：打印输出“这是finally！！” 同时打印输出resulte 结果
	 */
	public  int test3(){
		int divider =10;
		int result = 100;
		try{
			while(divider >-1){
				divider--;
				result += 100/divider;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环跑出异常了！！");
			
		}finally{
			System.out.println("这是finally！！");
			System.out.println("我是result！值为："+result);
		}
		System.out.println("我是test3，我运行完毕！！");
		return 1111;
	}
}
