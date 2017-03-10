package com.leon.study;

import java.util.ArrayList;
import java.util.List;

public class testGeneric {
	
	// 带有泛型的Course类型的list属性
	public List<Course> course;
	
	public testGeneric(){
		this.course = new ArrayList<Course>();
	}
	
	
	public void testAdd(){
		Course cr = new Course("1","大学语文");
		course.add(cr);
		
		Course cr1 = new Course("2","大学英语");
		course.add(cr1);
		/**
		 * 编译报错；
		 * The method add(Course) in the type List<Course> is not applicable for the arguments (String)
		 * 泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则会报错！
		 */
//		course.add("添加字符串看看会发生什么？？");
	}
	
	public void testforEach(){
		for(Course cr :course){
			System.out.println(cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * 泛型集合可以添加泛型子类型的对象
	 */
	public void testChildCourse(){
		ChildCourse ccr = new ChildCourse();
		ccr.id = "3";
		ccr.name = "泛型子类型对象";
		course.add(ccr);
		
	}
	
	
	/**
	 * 泛型不能使用基本类型，可以使用其包装类
	 * Syntax error, insert "Dimensions" to complete ReferenceType
	 * @param args
	 */
	public void testBasetype() {
//		List<int> li = new ArrayList<int>();
		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		System.out.println("我是泛型子类型的对象："+ li.get(0));
	}
	
	
	public static void main(String[] args) {
		testGeneric tg = new testGeneric();
		tg.testAdd();
		tg.testforEach();
		tg.testChildCourse();
		tg.testforEach();
		
		tg.testBasetype();
	}

}
