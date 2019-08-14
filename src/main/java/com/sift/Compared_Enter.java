package com.sift;

import java.io.File;
import java.io.IOException;

public class Compared_Enter {
	
	private String path;
	
	private String savepath;
	private int type;
	
	public static void main(String[] argv) {
		
		String path2="C:\\Users\\22682\\Desktop\\图片测试\\wszz201804013.pdf_14.jpg";
		String path3="C:\\Users\\22682\\Desktop\\组图特征点";
		String path4="D:\\testmaven\\照片1特征点";
		String path  ="C:\\Users\\22682\\Desktop\\图片测试"
				+ "\\wszz201804013.pdf_13.jpg";
		String resultpath="C:\\Users\\22682\\Desktop\\结果.jpg";
		File file=new File(resultpath);
		
		/*if(!file.exists()) {
			
			file.mkdirs();
		}*/
		
		try {
			Main.contrast_Two(path, path2, resultpath);
			//Main.ExistPic(path2, path, path3, resultpath);
			//Main.FilesFeatureRequest(path, resultpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
