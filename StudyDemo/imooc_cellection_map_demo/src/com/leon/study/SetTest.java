package com.leon.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class SetTest {

	public List<Course> coursesToSelect;
	private Scanner console;
	public Student student;
	
	public SetTest(){
		coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	
	/**
	 * 添加课程
	 */
	public void testAdd(){
		//创建一个课程对象，并通过调用add方法添加到courseToSelect中去
		Course cr1 = new Course("1", "数据结构");
		coursesToSelect.add(cr1);
		
		Course cr2 = new Course("2", "C语言");
		coursesToSelect.add(cr2);
	
		Course[] course = {new Course("3", "离散数学"),new Course("4", "汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));

		Course[] course2 = {new Course("5", "高等数学"),new Course("6", "大学英语")};
		coursesToSelect.addAll(Arrays.asList(course2));

	}
	
	/**
	 * 循环遍历元素
	 * @param args
	 */
	public void testForEach(){
		System.out.println("\n有如下课程备选（for each）：");
		for(Object obj :coursesToSelect){
			Course cr = (Course) obj;
			System.out.println(cr.id+":" + cr.name );
		}
	}
	
	/**
	 * 测试List的contain 方法
	 * @param args
	 */
	public void testListContains(){
		//获取课程列表中的第一个对象
		Course course = coursesToSelect.get(0);
		//输出课程名
		System.out.println("课程名为："+ course.name);
		System.out.println("备选课程中是否包含课程：" + course.name + "," + coursesToSelect.contains(course));
		
		//创建一个同名课程对象
		Course course1 = new Course(course.id,course.name);
		System.out.println("新创建的课程为：" + course1.name );
		System.out.println("备选课程中是否存在该对象，" + course1.name + ","  + coursesToSelect.contains(course1));
		
		
		//提示输入课程名称
		System.out.println("请输入课程名称：");
		String name = console.next();
		//创建一个新的课程，ID和名称，与course相同
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建的课程为：" + course2.name );
		System.out.println("备选课程中是否存在该对象，" + course2.name + ","  + coursesToSelect.contains(course2));
		
		//通过indexOf方法来取得某元素的索引
		if(coursesToSelect.contains(course2))
			System.out.println("课程："+ course2.name +"的索引位置为 " +
					coursesToSelect.indexOf(course2));
		
	}
	
	
	//循环打印Set集
	public void testForEachForSet(Student student){
		//循环打印选择的课程；
		System.out.println("共选择了"+ student.courses.size() + "门课程！");
		for (Course cr : student.courses) {
			System.out.println("您选择了课程"+ cr.id + ":" + cr.name);	
		}
	}

	//创建学生对象并选课
	public void studentAndSelectCourse(){
		student = new Student("1","小明");
		System.out.println("欢迎学生 "+ student.name +"来选课！");
		console = new Scanner(System.in);
		
		for (int i = 0; i <3; i++ ){
			System.out.println("请输入课程ID：");
			String courseId = console.next();
			for (Course cr : coursesToSelect) {
				if(cr.id.equals(courseId)){
					student.courses.add(cr);
					/**
					 * Set中，添加某个对象，无论添加多少次，
					 * 最终只会保留一个该对象（的引用），
					 * 并且，保留的是第一次添加的那一个
					 * 
					 * Set可以添加NULL对象，但一般来说业务上说无意义
					 */
//					student.courses.add(cr);
				}
			}
		}
		
	}
	
	/**
	 * 测试Set的contains方法
	 */
	public void testSetContains(){
		//提示输入课程名称
		System.out.println("请输入学生已选的课程：");
		String name = console.next();
		// 创建一个新的课程对象，ID 和名称，与course一样
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建的课程为：" + course2.name );
//		set的contains原理，当hashCode()与equals()均相同时返回true 
		System.out.println("备选课程中是否存在该对象，" + course2.name + ","  + student.courses.contains(course2));
		
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();

//		st.studentAndSelectCourse();
//		st.testSetContains();
		
//		st.testForEachForSet(student);
//
//		
	}
	

}
