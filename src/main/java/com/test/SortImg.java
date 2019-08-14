package com.test;
import java.io.*;

import com.brief.gray;
import com.test.ArrayList.Info;
public class SortImg {
	
	
	public static void SortFiles(String path,String save) {
		
		File[] files=new File(path).listFiles();
		ArrayList list=new ArrayList();
		int index=0;
		for(File f:files) {
			String name=f.getName();
			String parent=name.substring(0, name.lastIndexOf("."));
			if(list.list.size()==0) {
				Info info=new ArrayList().new Info();
				
				info.setName(name);
				info.setFilename(parent);
				info.setData(f.getAbsolutePath()+"&");
				list.addElement(info, index);
				index++;
			}else {
				int n=list.containIndex(name);
				if(n!=-1) {
					
					Info info=list.getInfo(n);
					String data=info.getData();
					data=data+f.getAbsolutePath()+"&";
					info.setData(data);
					list.setElement(info, n);
					
				}else {
					Info info=new ArrayList().new Info();
					
					info.setName(name);
					info.setFilename(parent);
					info.setData(f.getAbsolutePath()+"&");
					list.addElement(info, index);
					index++;
				}	
			}
			
		}
	}
	
	public static void Heavy(String path,String save) throws IOException {
		
		File file=new File(path);
		File[]	files=file.listFiles();
		File file2=new File(save);
		if(!file2.exists()) {
			file2.mkdirs();
		}
		int i=0;
		for(File f:files) {
			String name=f.getName();
			String parent=file.getName();
			name=name.substring(0, name.lastIndexOf("."));
			if(i==0) {
				i++;
				try {
					gray.Writer(f.getAbsolutePath(), save+"\\"+parent+"\\"+name+".txt");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				File[] file3=new File(save+"\\"+parent).listFiles();
				String ar2=gray.getH(f.getAbsolutePath());
				int biaoji=0;
				for(File f2:file3) {
					try {
						String ar1=gray.Reader(f2.getAbsolutePath());
						int n=gray.diff(ar1, ar2);
						if(n>=1) {
							biaoji=1;
							break;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				if(biaoji==0) {
					gray.Writer(f.getAbsolutePath(), save+"\\"+parent+"\\"+name+".txt");
				}
			}
			
			
		}
		
		
		
	}
	
	
	public static void copy(String path,String path2){
		try {
		FileOutputStream fos=new FileOutputStream(path2);
		
		FileInputStream fis=new FileInputStream(path);
		byte[] buf=new byte[1024];
		int len;
		while((len=fis.read(buf))!=-1) {
			fos.write(buf, 0, len);
		}
		
		fis.close();
		fos.close();
		}catch(IOException e) {
			System.err.println("文件复制错误");
		}
	}
	
	
	
}
