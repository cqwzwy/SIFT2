package com.SIFTresult;
import java.io.*;
import java.nio.file.Files;
public class ImgList {
	
	public static void copy(String path,String save) {
		File f1=new File(path);
		File f2=new File(save);
		try {
			FileInputStream fis=new FileInputStream(f1);
			FileOutputStream fos=new FileOutputStream(f2);
			byte[] buf=new byte[1024];
			int len;
			while((len=fis.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
