package QQ;
import static java.lang.System.*;
import java.io.*;
import java.nio.file.Files;
public class CreateFile {
	static {
		File file=new File("C:\\Users\\22682\\Desktop\\图片测试特征点文件细化后");
		File[] fs=file.listFiles();
		File save=new File("C:\\Users\\22682\\Desktop\\文献数据");
		if(!save.exists()) {
			save.mkdirs();
		}
		new File("C:\\Users\\22682\\Desktop\\结果3.jpg").renameTo(new File("C:\\Users\\22682\\Desktop\\结果4.jpg"));
		for(File f:fs) {
			if(f.getName().contains("哈希")) {
				f.delete();
			}
			/*String name=f.getName().substring(0, f.getName().lastIndexOf("."));
			
			String path=save.getAbsolutePath()+"\\"+name;
			File saveChild=new File(path);
			if(!saveChild.exists()) {
				saveChild.mkdirs();
			}*/
			/*File[] fs1=f.listFiles();
			int index=0;
			for(File f2:fs1) {
				out.println(new File(f2.getParentFile().getAbsoluteFile()+"\\"+f2.getParentFile().getName()+index+f2.getName().substring(f2.getName().lastIndexOf("."))).getAbsolutePath());
				f2.renameTo(new File(f2.getParentFile().getAbsoluteFile()+"\\"+f2.getParentFile().getName()+index+f2.getName().substring(f2.getName().lastIndexOf("."))));
				index++;
				
				
			}*/
		}
	}
	public static void main(String[]a) {
		
	}
}
