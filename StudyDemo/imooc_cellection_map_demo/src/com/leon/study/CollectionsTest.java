package com.leon.study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 将要完成：
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2.对String泛型的List进行排序
 * 3.对其他类泛型的List进行排序，已Student为例
 * 
 * @author admin
 *
 */


public class CollectionsTest {

	/**
	 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
	 * @param args
	 */
	public void testSort1(){
		List<Integer> integerList = new ArrayList<Integer>();
		//插入是个100以内的不重复的随机整数
		Random random = new Random();
		Integer k;
		for (int i = 0 ; i<10 ;i++){
			do{
				k= random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("添加了整数：" + k);
			
		}
		System.out.println("----------排序前----------");
		for (Integer integer : integerList) {
			System.out.println("元素："+ integer);
		}
		Collections.sort(integerList);
		System.out.println("----------排序后--------");
		for (Integer integer : integerList) {
			System.out.println("元素："+ integer);
		}
		
		
	}
	
	/**
	 * 对String泛型进行排序
	 * @param args
	 */
	public void testSort2(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("----------排序前----------");
		for (String string : stringList) {
			System.out.println("元素："+ string);
		}
		Collections.sort(stringList);
		System.out.println("----------排序后--------");
		for (String string : stringList) {
			System.out.println("元素："+ string);
		}
		
		
	}
	
	/** * 对String类型的List进行排序 
	    * 1、创建玩List<String>之后，往其中添加十条随机字符串 
	    * 2、每条字符串的长度为10以内的随机整数 
	    * 3、每条字符串的每个字符为随机生成的字符，字符可以重复 
	    * 4、每条随机字符串不可重复 
	*/
	 public void testStringSort(){
	     String s="1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"; 
	     StringBuffer sb=new StringBuffer();
	     List<String> stringList =new ArrayList<String>();
	     Random random=new Random(); 
	     String st="";
	     for(int i=0;i<10;i++){ 
	        do{
	           int sort=random.nextInt(10)+1; 
	           for(int f=0;f<sort;f++){ 
	             char a=s.charAt(random.nextInt(s.length())); 
	             st = st + a; 
	           } 
	        }while(stringList.contains(st));
	        stringList.add(st); System.out.println("成功创建字符串："+"'"+st+"'"); st=""; } 
	     System.out.println("------排序前------");
	      for (String string : stringList) { 
	          System.out.println("元素有："+string);
	      }
	      System.out.println("------排序后-------"); 
	      Collections.sort(stringList);
	      for (String string : stringList) { 
	        System.out.println("元素有："+string); 
	     } 
	  }
	/**
	 * 对其他类型泛型的List进行排序，以Student为例；
	 * 
	 * @param args
	 */
	 public void testSort3(){
		 List<Student> studentList = new ArrayList<Student>();
		 Random random = new Random();
		 studentList.add(new Student(random.nextInt(1000)+"","lucy"));
		 studentList.add(new Student(random.nextInt(1000)+"","Mike"));
		 studentList.add(new Student(random.nextInt(1000)+"","Leon"));
		 System.out.println("-------排序前-------");
		 for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":"+ student.name);
		}
		Collections.sort(studentList); 
		System.out.println("--------排序后--------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":"+ student.name);
		}
		Collections.sort(studentList,new StudentComparator());
		System.out.println("-------按照姓名排序后--------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":"+ student.name);
		}
		
		
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testStringSort();
		ct.testSort3();
	}

}
