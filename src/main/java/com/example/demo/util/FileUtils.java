package com.example.demo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	public static void main(String[] args) {
		String fileName = "testFile.txt";//表示文件名称
		String filePath = "D:/test/file/";//表示文件路径
		try {
			File faliPaths = new File(filePath);//通过文件路径初始化一个文件对象（只是包含目录，不包含文件）
			if(!faliPaths.exists())faliPaths.mkdirs();//判断文件目录是否存在，不存在就创建目录
			
			String completeFilePath = filePath + fileName;//表示文件的完整路径包括文件名称
			File file = new File(completeFilePath);//通过完整的文件路径（包括文件名称）再初始化一个文件对象
			if(!file.exists())file.createNewFile();//判断这个文件是否存在，不存在就创建一个文件
			
			//写入数据到文件
			writeToString(file);//调用写入文件的方法（方式一）
//			writeFile(file);//调用写入文件的方法（方式二）
			
			//从文件中读取数据
			readToString(file);//调用读取文件的方法（方式一）
//			readFile(file);//调用读取文件的方法（方式二）
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	 读入TXT文件
     */
	public static void writeFile(File file) {
        try {
        	String content = "这是需要写入到文件中的数据字节串------1";//这是需要写入到文件中的内容
        	FileWriter reader = new FileWriter(file);//通过文件对象初始化一个文件写入对象
        	BufferedWriter br = new BufferedWriter(reader);//再通过将文件写入对象初始化一个缓冲区写入对象
        	br.write(content);//通过缓冲区写入对象将数据写入到缓冲区中
        	br.append("这是需要写入到文件中的数据字节串------1.5");//这里可以在已经写入数据到缓冲区的数据后面再追加数据
        	br.flush();//清空缓冲区
        	br.close();//关闭缓冲区
        	
        	//注意：初始化的流对象，在使用结束必须先清空流中的数据，然后再关闭流
        	System.out.println("写入文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 *	 通过输出流将内容写入到文件中(常用)
	 * @param file
	 */
	public static void writeToString(File file) {
		try {
			FileOutputStream os = new FileOutputStream(file);//通过文件对象初始化一个文件输出流对象
			String content = "这是需要写入到文件中的数据字节串------2";//这是需要写入到文件中的内容
			byte[] contentInBytes = content.getBytes();//将内容转成Byte数组（字节数组）
			os.write(contentInBytes);//这里利用文件输出流对象中  write方法将转成的Byte数组（字节数组）写入到文件输出流中
			os.flush();//表示清空输出流中的数据
			os.close();//表示关闭输出流

			//注意：初始化的流对象，在使用结束必须先清空流中的数据，然后再关闭流
			System.out.println("写入文件成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     *	 读取TXT文件
     */
    public static void readFile(File file) {
    	try {
    		FileReader reader = new FileReader(file);//通过文件对象初始化一个文件读取对象
    		BufferedReader br = new BufferedReader(reader);//再通过将文件读取对象初始化一个缓冲区读取对象
    		String content;
    		while ((content = br.readLine()) != null) {//这里通过缓冲区对象中  readLine  方法读取缓冲区中的内容(这里是一行一行的读取)
    			System.out.println("读取文件中内容：------>" + content);//打印从文件读取到的内容
    		}
    		br.close();//缓冲区读取对象
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * 	使用输入流读取文件中的内容 (常用)
     * @param file
     */
    public static void readToString(File file) {  
        Long filelength = file.length();//获取文件文件长度
        byte[] filecontent = new byte[filelength.intValue()];//通过文件长度初始化一个Byte数组（字节数组）
        try {  
            FileInputStream in = new FileInputStream(file);//通过文件对象初始化一个输入流对象  
            in.read(filecontent);//将输入流中的内容读取到Bype数组（字节数组）中 
            in.close();//关闭输入流
            System.out.println("读取文件中内容：------>" + new String(filecontent));//打印从文件读取到的内容
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
}
