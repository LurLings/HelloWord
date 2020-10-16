package test;
import java.io.File;

public class util {
	/**
	 * 用于将文件名按照指定数字往后排
	 * @param startNum
	 * @param url
	 */
	public static void sort(int startNum,String url) {
		 File file = new File(url);
		 File[] list = file.listFiles();
		 String newName=null;
		// 如果目录下文件存在
	        if (file.exists() && file.isDirectory())
	        {
	            for (int i = 0; i < list.length; i++)
	            {
	                //取文件名子存入name中
	                String name = list[i].getName();
	                int lo=name.indexOf(".");
	               String lastName=name.substring(lo,name.length());
	               String forNeName=String.valueOf(startNum);
	               startNum++;
	                //重命名
	               newName=forNeName+lastName;
	                File dest = new File(url + "/" + newName);
	                list[i].renameTo(dest);
	                System.out.println(dest.getName());
	            }
	        }
	}
	/**
	 * 用于将文件名编制为七位，不够的用0来补充
	 * @param url
	 */
	public static void reName(String url) {
		 File file = new File(url);
		 File[] list = file.listFiles();
		 String newName=null;
		
		// 如果目录下文件存在
	        if (file.exists() && file.isDirectory())
	        {
	            for (int i = 0; i < list.length; i++)
	            {
	                //取文件名子存入name中
	                String name = list[i].getName();
	                int lo=name.indexOf(".");
	                
	               String strName=name.substring(0,lo);
	               String lastName=name.substring(lo,name.length());
	              // System.out.println(lastName);
	               int nameLength=strName.length();
	               System.out.println("nameLength="+nameLength);
	                if(nameLength<7) {
	                	String zeString="";
	                	for(int j=0;j<7-nameLength;j++) {
	                		zeString+="0";
	                		System.out.print(zeString);
	                	}
	                	newName=zeString+strName+lastName;
	                }else {
	                	 newName=name;
	                }
	                
	                //重命名
	                File dest = new File(url + "/" + newName);
	                list[i].renameTo(dest);
	                System.out.println(dest.getName());
	            }
	        }
	}
}