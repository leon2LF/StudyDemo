package com.leon.study;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException{
	    File demo = new File("demo");
	    if(!demo.exists())
	        demo.mkdir();
	    File file = new File(demo,"raf.dat");
	    if(!file.exists())
	        file.createNewFile();//在项目下新建了demo文件夹，其中有raf.dat文件
	    
	    RandomAccessFile raf = new RandomAccessFile(file,"rw");
	    //指针的位置，写一个字节指针移一位
	    System.out.println(raf.getFilePointer());
	    raf.write('A');//只写了一个字节
	    int i = 0x7fffffff;//用write方法每次只能写一个字节，若要把i写进去就得写4次
	    raf.writeInt(i);
	    String s = "中";
	    byte[] gbk = s.getBytes("gbk");
	    raf.write(gbk);

	    //读文件，必须把指针移到头部
	    raf.seek(0);
	    //一次性读取，把文件中的内容都读到字节数组中
	    byte[] buf = new byte[(int)raf.length()];
	    raf.read(buf);
	    System.out.println(Arrays.toString(buf));
	    for(byte b:buf){
	        System.out.print(Integer.toHexString(b & 0xff)+" ");    
	    }
	}
}
