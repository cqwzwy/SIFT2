package com.sift;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteMessage {
	
	public static void Writer(KDFeaturePoint[] k1,KDFeaturePoint[] k2,int size) throws IOException {
		
		
		try {
			File files=new File("C:\\Users\\22682\\Desktop\\特征点文件.txt");
			FileOutputStream fos=new FileOutputStream(files);
			
			for(int i=0;i<k1.length;i++) {
				KDFeaturePoint k=k1[i];
				KDFeaturePoint ks=k2[i];
				int dim=k.dim;
				float ora=k.orientation;
				int[] deature=k.descriptor;
				String data="原点 ( "+k.x+" , "+k.y+" ) "+"主方向值："+ora+"   向量维数： "+dim+" 各维数值：\n  ";
				for(int j=0;j<4;j++) {
					for(int x=0;x<4;x++) {
						data=data+" ( ";
						for(int y=0;y<8;y++) {
							
							int number=deature[j*32+x*8+y];
							data=data+number+" , ";
							
							
							
						}
						data=data+" ) ";
					}
					data=data+" \n";
				}
				
				data=data+"   \n";
				
				int dim2=ks.dim;
				float ora2=ks.orientation;
				int[] deature2=ks.descriptor;
				data=data+"对比匹配点( "+ks.x+" , "+ks.y+" )      主方向值："+ora2+"   向量维数： "+dim2+" 各维数值：\n  ";
				for(int j=0;j<4;j++) {
					for(int x=0;x<4;x++) {
						data=data+" ( ";
						for(int y=0;y<8;y++) {
							
							int number=deature2[j*32+x*8+y];
							data=data+number+" , ";
							
							
							
						}
						data=data+" ) ";
					}
					data=data+" \n";
				}
				
				data=data+"   \n";
				
				data=data+"   \n";
				fos.write(data.getBytes());
			}
			
			fos.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
