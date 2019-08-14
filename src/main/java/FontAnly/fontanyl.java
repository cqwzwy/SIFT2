package FontAnly;



import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class fontanyl 
{
    public static void main( String[] args )
    {
    	File imageFile = new File("C:\\Users\\22682\\Desktop\\֪��\\ͼƬ_1.jpg");    
        ITesseract instance = new Tesseract();  // JNA Interface Mapping    
        /*
        ������õĲ���ʹ�ð�Ĭ�ϵ�testdata�������һ��һ�д��룺
        instance.setDatapath("D:\\myworks\\BusinessManager\\WebRoot\\tessdata");
        */
//         ITesseract instance = new Tesseract1(); // JNA Direct Mapp
        instance.setLanguage("chi_sim");//��������ֿ�  
        
        try {    
            String result = instance.doOCR(imageFile);    
            System.out.println(result);    
        } catch (TesseractException e) {    
            e.printStackTrace();  
        }
	}
}