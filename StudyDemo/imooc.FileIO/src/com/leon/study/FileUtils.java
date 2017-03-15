package com.leon.study;

import java.io.File;
import java.io.IOException;

// 列出file类的一些常用操作，不如过滤、遍历等操作
public class FileUtils {
	public static void listDirectory(File dir) throws IOException{
		// exists()方法用于判断文件或目录是否存在
		if(!dir.exists()){
			throw new IllegalArgumentException("目录：" + dir + "不存在");	
		}
		// isDirectory()方法用于判断File类的对象是否是目录
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir + "不是目录");
			
		}
		// list方法用于列出当前目录下的子目录和文件
		/*String[] filenames = dir.list(); // 返回的是字符串数组 直接子的名称 不包含子目录下的内容
		for (String string : filenames) {
			System.out.println(dir + ":\\" + string);
		}*/
		// 如果要遍历子目录下的内容就需要构造成File对象做递归操作，File提供了返回File对象的API
		File[] files = dir.listFiles(); // 返回的是直接子目录（文件）的抽象
		//for (File file : files) {
			//System.out.println(file);
		if(files!=null && files.length > 0){
			for (File file : files) {
				if(file.isDirectory()){
					// 递归
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
		
	}

	

}