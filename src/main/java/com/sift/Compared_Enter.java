package com.sift;

import java.io.File;
import java.io.IOException;

public class Compared_Enter {
	
	private String path;
	
	private String savepath;
	private int type;
	
	public static void main(String[] argv) {
		long current=System.currentTimeMillis();
		String pic_path="D:\\细化数据\\001000b11235.jpg";
		String Dao="D:\\数据SIFT";
		String path4="D:\\testmaven\\照片1特征点";
		String imgDao  ="D:\\细化数据";
		String resultpath="D:\\数据2";
		String Haming="D:\\数据哈希";
		String path2="C:\\Users\\22682\\Desktop\\ZPBig细化\\甲骨文与圣书字动物字构形比较研究_郑丽娜23.jpg";
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
