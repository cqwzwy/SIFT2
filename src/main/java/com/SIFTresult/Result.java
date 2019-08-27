package com.SIFTresult;

public class Result {
	
	public static void Collection(String name,String img,String path,double re,int Haming) {
		if(AList.containIndex(name)==-1) {
			PDFEntry e=new PDFEntry();
			e.setImgBest(img);
			e.setName(name);
			e.setRe(re);
			e.setHaming(Haming);
			e.setPath(path+"\\"+img);
			e.setPath2(path+"\\"+img);
			e.setH1(Haming);
			e.setH2(Haming);
			e.setR1(re);
			e.setR2(re);
			img=img+"&";
			e.setImgName(img);
			AList.add(e);
		}else {
			int index=AList.containIndex(name);
			PDFEntry e=AList.get(index);
			
			if(Haming<e.getHaming()) {
				e.setImgBest(img);
				//e.setRe(re);
				e.setHaming(Haming);
				e.setPath(path+"\\"+img);
				e.setH1(Haming);
				e.setR1(re);
			}
			if(re>e.getR1()&&Haming==e.getHaming()) {
				e.setImgBest(img);
				e.setRe(re);
				//e.setHaming(Haming);
				e.setPath2(path+"\\"+img);
				e.setH2(Haming);
				e.setR2(re);
			}
			if(re>e.getRe()) {
				e.setImgBest(img);
				e.setRe(re);
				//e.setHaming(Haming);
				e.setPath2(path+"\\"+img);
				e.setH2(Haming);
				e.setR2(re);
			}
			if(re==e.getRe()&&Haming<e.getH2()) {
				e.setImgBest(img);
				e.setRe(re);
				//e.setHaming(Haming);
				e.setPath2(path+"\\"+img);
				e.setH2(Haming);
				e.setR2(re);
			}
			img=e.getImgName()+img+"&";
			e.setImgName(img);
			AList.set(index, e);
		}
	}
	
	
	
}
