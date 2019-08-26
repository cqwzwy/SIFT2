package com.SIFTresult;

public class Result {
	
	public static void Collection(String name,String img,String path,double re,int Haming) {
		if(AList.containIndex(name)==-1) {
			PDFEntry e=new PDFEntry();
			e.setImgBest(img);
			img=img+"&";
			e.setImgName(img);
			e.setName(name);
			e.setRe(re);
			e.setHaming(Haming);
			e.setPath(path);
			AList.add(e);
		}else {
			int index=AList.containIndex(name);
			PDFEntry e=AList.get(index);
			
			if(Haming<e.getHaming()) {
				e.setImgBest(img);
				e.setRe(re);
				e.setHaming(Haming);
				e.setPath(path);
			}
			img=e.getImgName()+img+"&";
			e.setImgName(img);
			AList.set(index, e);
		}
	}
	
	
	
}
