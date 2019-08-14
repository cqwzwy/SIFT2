package com.test;

public class ArrayList {
	
	public static java.util.List<Info> list=new java.util.ArrayList<Info>();
	
	
	
	
	public static Info[] getAllList() {
		
		Info[] info=new Info[list.size()];
		for(int i=0;i<list.size();i++) {
			
			info[i]=list.get(i);
			
		}
		
		
		return info;
	}


	public static void setElement(Info info,int index) {
		list.set(index, info);
	}
	public static void addElement(Info info,int index) {
		list.add(index, info);
	}
	
	public static Info getInfo(int index) {
		return list.get(index);
	}

	public boolean containE(String in) {
		Info info=new Info();
		for(int i=0;i<list.size();i++) {
			
			info=list.get(i);
			if(info.getName().equals(in)) {
				return true;
			}
			
		}
		return false;
		
	}

	public int containIndex(String in) {
		Info info=new Info();
		for(int i=0;i<list.size();i++) {
			
			info=list.get(i);
			if(info.getName().equals(in)) {
				return i;
			}
			
		}
		return -1;
		
	}

	class Info{
		
		String name;
		String filename;
		String data;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		
		
	}
	
	
	
}
