package com.leon.study;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 使用缓冲字节流复制确实是最快的方式，但对于小文件10M以下的文件体现不出优势，
 * 对于百兆文件正确使用，时间可以控制到50ms内。视频中的缓冲字节流使用有错误，
 * 复制文件最快的做法是将批量读取到的字节数组使用缓冲写入到文件，在机器性能范围
 * 内字节数组越大越快。在循环写入的过程中不需要使用flush，就像cwt8805说的，
 * 缓冲输入流在关闭的时候会将所有缓冲区的数据全部写入文件，使用flush刷新缓冲就
 * 失去了缓冲的意义。 
 * 循环写入的时候不使用flush的速度远高于适用其的速度。 -- qq_D墨客_0
 * 最后关闭IO流和文件流应该在finally中关闭，
 * 否则IO异常时执行不到close语句，IO流仍然没有关闭。
 * 
 */


public class IOUtil {

	/**
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 */
	public static void printHex(String fileName) throws IOException{
		//把文件作为字节流进行读操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i  = 1 ;
		while((b = in.read())!= -1){
			if(b <= 0xf ){
				//单位数前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if(i++%10 ==0){
				System.out.println();
			}
		}
		in.close();
	}
	
	
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[8 *1024];
		/*从in中批量读取字节，放入到buf着这个字节数组中
		 * 从第0个位置开始放，最多放buf.length个
		 * 返回的是读到的字节个数
		 * 
		 */
		/*int bytes = in.read(buf,0,buf.length);//一次性读完，说明字节数组够大
		int j= 1;
		for(int i =0 ; i< bytes; i++){
			if((buf[i]&0xff) <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i]& 0xff )+ " ");
			if(j++%10 ==0 ){
				System.out.println();
			}
		}*/
		
		int bytes = 0;
		int j =1;
		while((bytes = in.read(buf, 0, buf.length-1))!= -1){
			for(int i = 0;i < bytes; i ++){
				if((buf[i]&0xff) <= 0xf){
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff)+ " ");
				if(j++ %10 == 0)
					System.out.println();
			}
		}
	}
	
	
	/**
	 * 文件拷贝，字节批量读取
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	
	public static void copyFile(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+ srcFile + "不存在");
		}
		
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile +"不是文件");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		
		byte[] buf = new byte[8*1024];
		int b;
		while((b=in.read(buf,0,buf.length) )!= -1){
			out.write(buf, 0, b);
			out.flush();//最好加上
		}
		
		in.close();
		out.close();	
	}
	
	/**
	 * 带缓冲区的文件拷贝
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile,File destFile) throws IOException {
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+ srcFile + "不存在");
		}
		
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile +"不是文件");
		}
		
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int c;
		while((c= bis.read())!= -1){
			bos.write(c);
			
		}
		//依评论，将此执行放在循环外
		bos.flush();//刷新缓冲区，必须写，不然写入不到
		bis.close();
		bos.close();
		
		
	}
	
	/**
	 * 单字节不带缓冲进行文件拷贝
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByByte(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+ srcFile + "不存在");
		}
		
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile +"不是文件");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int c;
		while((c= in.read())!= -1){
			out.write(c);
			out.flush();//刷新缓冲区
		}
		
		in.close();
		out.close();
		
	}
	
	
	
	
}
