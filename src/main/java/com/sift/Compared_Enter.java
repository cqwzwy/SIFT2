package com.sift;

import java.io.File;
import java.io.IOException;

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
		/*if(!file2.exists()) {
			
			file2.mkdirs();
		}*/
		try {
			//Main.Files_Img(pic_path, path2);
			//Main.contrast_Two(pic_path, path2, resultpath);
			Main.ExistPic(pic_path, imgDao, Dao, resultpath,Haming);
			//Main.FilesFeatureRequest(imgDao, resultpath,Haming);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("共用时 ："+(System.currentTimeMillis()-current)/1000);
		
		
	}
	
}
