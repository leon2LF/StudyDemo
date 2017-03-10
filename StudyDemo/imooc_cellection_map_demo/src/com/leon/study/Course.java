package com.leon.study;

/**
 * 课程类
 * @author admin
 *
 */
public class Course {

	public String id;
	public String name;
	
	public Course(String id,String name){
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 在子类childCourse中默认调用父类Coures的无参构造方法，所以需要添加；
	 */
	public Course(){
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * 如何利用contains方法直接判断list中是否存在该名称的课程；
	 * contains的原理是遍历list中的每个元素，再访问元素的 equals方法判断是否相等，返回true，就包含；
	 * 所以来改造该方法以达到 根据课程名来判断是否存在；
	 * 
	 * 以后重写此方法可以参考一下模板；
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		//如果需要判断多个属性值，在这里添加即可
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
