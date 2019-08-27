package com.SIFTresult;

public class PDFEntry {
	private String path;  //最小haming图片路径
	private String path2; //最高相关度图片路径
	private int H1;    //Haming最小图片对应的相关度信息
	private double R1;
	private int H2;   //相关度最大图片对应的Haming信息
	private double R2;
	private int Haming;           //最小Haming值
	private String imgBest;	      //最适合结果
	private String name;   //PDF名称
	public int getH1() {
		return H1;
	}
	public void setH1(int h1) {
		H1 = h1;
	}
	public double getR1() {
		return R1;
	}
	public void setR1(double r1) {
		R1 = r1;
	}
	public int getH2() {
		return H2;
	}
	public void setH2(int h2) {
		H2 = h2;
	}
	public double getR2() {
		return R2;
	}
	public void setR2(double r2) {
		R2 = r2;
	}
	private String imgName;  //图像名称集合
	private double re;		//最高相关度
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath2() {
		return path2;
	}
	public void setPath2(String path2) {
		this.path2 = path2;
	}
	
	public int getHaming() {
		return Haming;
	}
	public void setHaming(int haming) {
		Haming = haming;
	}
	
	public String getImgBest() {
		return imgBest;
	}
	public void setImgBest(String imgBest) {
		this.imgBest = imgBest;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public double getRe() {
		return re;
	}
	public void setRe(double re) {
		this.re = re;
	}
	
	
	
}
