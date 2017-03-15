package com.leon.study;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

//	public static void main(String[] args) {
//		
//		try {
//			IOUtil.copyFile(new File("E:\\WORK\\workspace\\imooc.FileIO\\demo\\src.txt"), new File("E:\\WORK\\workspace\\imooc.FileIO\\demo\\copy.txt"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}

	public static void main(String[] args) {
		try {
			IOUtil.copyFileByBuffer(new File("demo\\src.txt"), new File("demo\\aa.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
