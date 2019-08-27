package com.SIFTresult;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AList {
	
	private static java.util.ArrayList<PDFEntry> array=new java.util.ArrayList<PDFEntry>();
	public static void add(PDFEntry entry) {
		array.add(entry);
		
	}
	public static void set(int index,PDFEntry entry) {
		array.set(index, entry);
		
	}
	public static void ForEach() {
		for(PDFEntry e:array) {
			System.out.println(
					"PDF文件名称： "+e.getName()
					+"     图像名称："+e.getImgName()
					+"        最高相关度："+e.getRe());
			
			
		}
	}
	public static void ForEach_Limit(String path) {
		try {
			System.setOut(new PrintStream(path+"\\"+path.substring(path.lastIndexOf("\\"))+".txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(array.size()>=30) {
			for(int i=0;i<30;i++) {
			PDFEntry e=array.get(i);
			System.out.println();
			System.out.println(
					"PDF文件名称： "+e.getName()
					+"        最高相关度："+e.getRe()+" 最小Haming ："+e.getHaming());
			System.out.println(
					"  Haming对于信息 : "+e.getPath()+" Haming : "+e.getH1()
					+"  Re : "+e.getR1());
			System.out.println(
					"  Re对于信息 : "+e.getPath2()+" Haming : "+e.getH2()
					+"  Re : "+e.getR2());
			ImgList.copy(e.getPath2()+".jpg", path+"\\"
					+e.getPath2().substring(e.getPath2().lastIndexOf("\\"))+".jpg");
			
			}
		}else {
			System.out.println();
			for(int i=0;i<array.size();i++) {
				PDFEntry e=array.get(i);
				System.out.println();
				System.out.println(
						"PDF文件名称： "+e.getName()
						+"        最高相关度："+e.getRe()+" 最小Haming ："+e.getHaming());
				System.out.println(
						"  Haming对于信息 : "+e.getPath()+" Haming : "+e.getH1()
						+"  Re : "+e.getR1());
				System.out.println(
						"  Re对于信息 : "+e.getPath2()+" Haming : "+e.getH2()
						+"  Re : "+e.getR2());
				
				ImgList.copy(e.getPath2()+".jpg", path+"\\"
						+e.getPath2().substring(e.getPath2().lastIndexOf("\\"))+".jpg");
			}
		}
		
	}
	public static PDFEntry get(int index) {
		return array.get(index);
		
	}
	public static boolean contains(PDFEntry entry) {
		return array.contains(entry);
	}
	public static int containIndex(String name) {
		int i=0;
		for(i=0;i<array.size();i++) {
			PDFEntry e=array.get(i);
			if(e.getName().equals(name)) {
				return i;
			}
			
		}
		return -1;
	}
	
	//排序规则
	public static void SortLimit() {
		double[] re=new double[array.size()];
		double[] Haming=new double[array.size()];
		for(int i=0;i<array.size();i++) {
			PDFEntry e=array.get(i);
			re[i]=e.getRe();
			Haming[i]=e.getH2();
			
		}
		
		for(int i=0;i<re.length;i++) {
			for(int j=i+1;j<re.length;j++) {
				if(re[i]<re[j]) {
					double n=re[i];
					re[i]=re[j];
					re[j]=n;
					n=Haming[i];
					Haming[i]=Haming[j];
					Haming[j]=n;
					PDFEntry temp=array.get(i);
					PDFEntry temp2=array.get(j);
					array.set(i, temp2);
					array.set(j, temp);
				}
			}
			
		}
		
		for(int i=0;i<Haming.length;i++) {
			
			for(int j=i+1;j<Haming.length;j++) {
				if(Haming[i]>Haming[j]||(Haming[i]==Haming[j]&&re[i]<re[j])
						) {
					double n=re[i];
					re[i]=re[j];
					re[j]=n;
					n=Haming[i];
					Haming[i]=Haming[j];
					Haming[j]=n;
					PDFEntry temp=array.get(i);
					PDFEntry temp2=array.get(j);
					array.set(i, temp2);
					array.set(j, temp);
				}
				
			}
		}
		for(int i=0;i<Haming.length;i++) {
			
			for(int j=i+1;j<Haming.length;j++) {
				if((Haming[i]>Haming[j]-5&&re[i]*2<re[j])
						) {
					double n=re[i];
					re[i]=re[j];
					re[j]=n;
					n=Haming[i];
					Haming[i]=Haming[j];
					Haming[j]=n;
					PDFEntry temp=array.get(i);
					PDFEntry temp2=array.get(j);
					array.set(i, temp2);
					array.set(j, temp);
				}
				
			}
		}
	}
	
}
