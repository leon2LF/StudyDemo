package com.leon.study;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//如果该文件不存在，则直接创建，如果存在，删除后创建；
		//如果文件存在，需要追加数据，则使用构造函数 FileOutputStream(File,true);
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		out.write('A');//写出了‘A’的第八位
		out.write('B');//写出了‘B’的第八位
		int a = 10; //write只能写八位，那么写一个int需要写四次
		out.write(a>>>24);
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a);
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		
		out.close();
		
		IOUtil.printHex("demo/out.dat");
	}

}
