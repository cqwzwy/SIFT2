package com.sift;

import java.io.File;
import java.io.IOException;

public class Compared_Enter {
	
	private String path;
	
	private String savepath;
	private int type;
	
	public static void main(String[] argv) {
		long current=System.currentTimeMillis();
		String pic_path="C:\\Users\\22682\\Desktop\\ZPBig细化\\甲骨文动物字构形模式研究_周梦247.jpg";
		String Dao="C:\\Users\\22682\\Desktop\\图片测试特征点文件细化后";
		String path4="D:\\testmaven\\照片1特征点";
		String imgDao  ="C:\\Users\\22682\\Desktop\\细化结果";
		String resultpath="C:\\Users\\22682\\Desktop\\结果数据1.jpg";
		String Haming="C:\\Users\\22682\\Desktop\\细化哈希";
		String path2="C:\\Users\\22682\\Desktop\\ZPBig细化\\ydxk201302019.pdf_1.jpg";
		//String path2="C:\\Users\\22682\\Desktop\\ydxk201302019.pdf_1.jpg";
		File file=new File(resultpath);
		File file2=new File(Haming);
		/*if(!file.exists()) {
			
			file.mkdirs();
		}*/
		/*if(!file2.exists()) {
			
			file2.mkdirs();
		}*/
		try {
			Main.contrast_Two(pic_path, path2, resultpath);
			//Main.ExistPic(pic_path, imgDao, Dao, resultpath,Haming);
			//Main.FilesFeatureRequest(imgDao, resultpath,Haming);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("共用时 ："+(System.currentTimeMillis()-current)/1000);
		
		
	}
	
}
