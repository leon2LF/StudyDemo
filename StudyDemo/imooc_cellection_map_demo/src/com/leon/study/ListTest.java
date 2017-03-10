package com.leon.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

/**
 * 备选课程类
 * @author admin
 *
 */
public class ListTest {

	/**
	 * 用于存放备选课程的List
	 */
	public List coursesToSelect;
	
	public ListTest(){
		this.coursesToSelect = new ArrayList();
	}
	
	
	public void testAdd(){
		//创建一个课程对象，并通过调用add方法添加到courseToSelect中去
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
		System.out.println("添加了课程："+ temp.id + ":"+ temp.name);
		
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course) coursesToSelect.get(0);
		System.out.println("添加了课程：" + temp2.id + ":" + temp2.name );
		
		//以下方法会抛出数组小标越界异常：java.lang.IndexOutOfBoundsException
//		Course cr3 = new Course("3", "TEST");
//		coursesToSelect.add(4, cr3);
		
		Course[] course = {new Course("3", "离散数据"),new Course("4", "汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2);
		Course temp4 = (Course) coursesToSelect.get(3);
		System.out.println("添加了两门课程：" + temp3.id + ":" + temp3.name
				+ "," + temp4.id + ":" + temp4.name);

		Course[] course2 = {new Course("5", "高等数据"),new Course("6", "大学英语")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2);
		Course temp6 = (Course) coursesToSelect.get(3);
		System.out.println("添加了两门课程：" + temp5.id + ":" + temp5.name
				+ "," + temp6.id + ":" + temp6.name);
		
		Course cr3 = new Course("1", "数据结构");
		coursesToSelect.add(cr3);
		Course temp7 = (Course) coursesToSelect.get(6);
		System.out.println("添加了课程："+ temp7.id + ":"+ temp7.name);
	}
	
	
	/**
	 * 获取List中的元素；
	 */
	public void testGet(){
		System.out.println("\n有如下课程备选：");
		for(int i=0;i<coursesToSelect.size();i++){
			Course temp = (Course) coursesToSelect.get(i);
			System.out.println(temp.id + ":" + temp.name);
		}
	}
	
	
	/**
	 * 使用迭代器遍历list元素
	 * 迭代器是依赖某个集合存在的，只提供元素遍历，不存储数据，相当于for each的简写
	 * @param args
	 */
	public void testIterator(){
		Iterator it = coursesToSelect.iterator();
		System.out.println("\n有如下课程备选（迭代器选择）：");
		while(it.hasNext()){
			Course cr = (Course) it.next();
			System.out.println(cr.id+":" + cr.name );
		}
	}
	
	
	public void testForEach(){
		System.out.println("\n有如下课程备选（for each）：");
		for(Object obj :coursesToSelect){
			Course cr = (Course) obj;
			System.out.println(cr.id+":" + cr.name );
		}
	}
	
	////////////////////////////////////////////////////
	public void testModify() {
		System.out.println("测试修改----\n");
		Course cr = (Course) coursesToSelect.get(6);
		System.out.println("修改前，第7个元素为："+ cr.name);
		coursesToSelect.set(6, new Course("7", "软件工程"));
		testForEach();
	}
	
	
	/**
	 * 删除课程
	 * @param args
	 */
	public void testRemove(){
		Course cr = (Course) coursesToSelect.get(6);
		System.out.println("\n我是第7个元素"+ cr.id + cr.name + "即将被删除");
		coursesToSelect.remove(6);
		System.out.println("删除成功 ！！");
		testForEach();
		
		System.out.println("\n即将删除第5个和第6个元素！！\n ------");
		Course[] coures = {(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(coures));
		testForEach();
	
	}
	
	
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
//		lt.testGet();
//		lt.testIterator();
		lt.testForEach();
		lt.testModify();
		lt.testRemove();
	}
	
	
}
