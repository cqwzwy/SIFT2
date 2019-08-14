package com.sift;

public class ResultList {
	
	
	private static java.util.Map map=new java.util.HashMap<String,Info>();
	private static java.util.List<Info> result=new java.util.ArrayList<Info>();
	private static int index=0;
	
	public static Info[] getAllResult() {
		Info[] infos=new Info[result.size()];
		
		for(int i=0;i<result.size();i++) {
			infos[i]=result.get(i);
		}
		
		
		return infos;
	}

	public static void setElement(int index,Info info) {
		result.set(index, info);
	}
	public static void addElement(int index,Info info) {
		result.add(index, info);
	}
	
	public static boolean ContainElement(Info info) {
		
		for(int i=0;i<result.size();i++) {
			if(result.get(i).getName().equals(info.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int ContainIndexElement(Info info) {
		
		for(int i=0;i<result.size();i++) {
			if(result.get(i).getName().equals(info.getName())) {
				return i;
			}
		}
		return -1;
	}
	public static void clear() {
		result.clear();
	}
	class Info{
		
		private String name;   //结果标识名称 PDF名称
		private float sample;	//最高相似度
		private String file;	//所在文件夹
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getSample() {
			return sample;
		}
		public void setSample(float sample) {
			this.sample = sample;
		}
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
		
	}
}
