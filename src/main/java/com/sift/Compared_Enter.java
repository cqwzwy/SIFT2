package com.sift;

import java.io.File;
import java.io.IOException;

import com.SIFTresult.AList;
import com.SIFTresult.ImgList;
import com.Thread.Cont_Thread;

public class Compared_Enter {
	
	
	public static void Start(String path,String imgDaoPath,String DaoPath,String HamingPath,String resultPath) {
		long current=System.currentTimeMillis();
		String pic_path=path;
		String Dao=DaoPath;
		// path4="D:\\testmaven\\照片1特征点";
		String imgDao  =imgDaoPath;
		String resultpath=resultPath;
		String Haming=HamingPath;
		//String path2="D:\\Canny\\001000_b02096_1.jpg";
		//String path2="C:\\Users\\22682\\Desktop\\ydxk201302019.pdf_1.jpg";
		File file=new File(resultpath);
		File file2=new File(Haming);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		if(!file2.exists()) {
			
			file2.mkdirs();
		}
		try {
			//Main.Files_Img(pic_path, path2);
			//Main.contrast_Two(pic_path, path2, resultpath);
			Main.ExistPic(pic_path, imgDao, Dao, resultpath,Haming);
			//Main.FilesFeatureRequest(imgDao, resultpath,Haming);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AList.Delete();
		System.out.println("共用时 ："+(System.currentTimeMillis()-current)/1000);
		
		
	}
	
	/*public static void main(String[]argv) {
		String path="D:\\字2";
		String imgDaoPath="D:\\Canny";
		String DaoPath="D:\\数据3Sift";
		String HamingPath="D:\\数据3Hash";
		String result="D:\\印刷结果\\字3";
		Cont_Thread.FileReq(path,imgDaoPath,DaoPath,HamingPath,result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		File file=new File(result);
		File file2=new File(HamingPath);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		if(!file2.exists()) {
			
			file2.mkdirs();
		}
		File[] fs=new File(imgDaoPath).listFiles();
		int num=0;
		for(File f:fs) {
			String name=f.getName();
			name=name.substring(0, name.lastIndexOf("."));
			String KDName=name+"KD数据.txt";
			String HashName=name+"哈希.txt";
			System.out.println("FileName : "+name+"  SIFTName : "+KDName
					+"  HashName : "+HashName);
			num++;
			ImgList.copy("D:\\CannySIFT\\"+KDName, "D:\\数据3Sift\\"+KDName);
			ImgList.copy("D:\\CannyHash\\"+HashName, "D:\\数据3Hash\\"+HashName);
		}
		System.out.println("总数 ："+num);
	}*/
	
}
