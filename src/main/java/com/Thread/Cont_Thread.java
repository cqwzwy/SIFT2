package com.Thread;
import java.io.*;
import java.util.*;

import com.sift.Compared_Enter;
public class Cont_Thread {
	public static void FileReq(String path,String imgDaoPath,String DaoPath,String HamingPath,String result) {
		File fs=new File(path);
		if(fs.isDirectory()) {
			File[] files=fs.listFiles();
			for(File f:files) {
				if(f.getName().contains(".jpg")) {
					Compared_Enter.Start(f.getAbsolutePath(), imgDaoPath, DaoPath, HamingPath
							,result+"\\"+ f.getName().substring(0, f.getName().lastIndexOf(".")));
				}
			}
		}else if(fs.isFile()) {
			if(fs.getName().contains(".jpg")) {
				Compared_Enter.Start(fs.getAbsolutePath(), imgDaoPath, DaoPath, HamingPath
						,result+"\\"+ fs.getName().substring(0, fs.getName().lastIndexOf(".")));
			}
		}
	}
	public static void main(String[]argv) {
		String path="D:\\字2";
		String imgDaoPath="D:\\Canny";
		String DaoPath="D:\\CannySIFT";
		String HamingPath="D:\\CannyHash";
		String result="D:\\印刷结果\\字2";
		FileReq(path,imgDaoPath,DaoPath,HamingPath,result);
		
		path="D:\\字1";
		imgDaoPath="D:\\细化数据";
		DaoPath="D:\\数据SIFT";
		HamingPath="D:\\数据哈希";
		result="D:\\印刷结果\\字1";
		FileReq(path,imgDaoPath,DaoPath,HamingPath,result);
	}
}
