package com.SIFTresult;

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
	public static void ForEach_Limit() {
		if(array.size()>=10) {
			for(int i=0;i<15;i++) {
			PDFEntry e=array.get(i);
			System.out.println(
					"PDF文件名称： "+e.getName()
					+"        最高相关度："+e.getRe()+"  对应照片 ："+e.getImgBest()+"  Haming : "+e.getHaming()+"  图片路径："+e.getPath());
			ImgList.copy(e.getPath()+"\\"+e.getImgBest()+".jpg", "C:\\Users\\22682\\Desktop\\结果数据1\\"+e.getImgBest()+".jpg");
			
			}
		}else {
			for(PDFEntry e:array) {
				System.out.println(
						"PDF文件名称： "+e.getName()
						+"        最高相关度："+e.getRe()+"  对应照片 ："+e.getImgBest()+"  Haming : "+e.getHaming()+"  图片路径："+e.getPath());
				
				ImgList.copy(e.getPath(), "C:\\Users\\22682\\Desktop\\结果数据1\\"+e.getImgBest()+".jpg");
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
	
	
	public static void SortLimit() {
		double[] re=new double[array.size()];
		for(int i=0;i<array.size();i++) {
			PDFEntry e=array.get(i);
			re[i]=e.getHaming();
		}
		
		for(int i=0;i<re.length;i++) {
			for(int j=i+1;j<re.length;j++) {
				if(re[i]>re[j]) {
					double n=re[i];
					re[i]=re[j];
					re[j]=n;
					PDFEntry temp=array.get(i);
					PDFEntry temp2=array.get(j);
					array.set(i, temp2);
					array.set(j, temp);
				}
			}
		}
	}
	
}
