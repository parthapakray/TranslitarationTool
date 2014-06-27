import java.io.*;
/**
 * @(#)TU.java
 *
 *
 * @author 
 * @version 1.00 2009/8/27
 */

public class TU {
        
    /**
     * Creates a new instance of <code>TU</code>.
     */
    public TU() {
    }
    
    public static void file_update(String path,String txt) 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
			bw.write(txt);
			bw.flush();
			fos.close();
		}catch(IOException f){}	
	}
    
    public static String[] split_tu(String txt) 
	{
		int tu_count=0;
		String[] tu=new String[tu_count];
		String tmp="";
		
		
		txt=txt.toLowerCase();
		
		System.out.println();
		System.out.print(txt+"-->");
		
		for(int i=0;i<txt.length();i++)
		{
			char ch=txt.charAt(i);
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				tmp+=ch;
				System.out.print(tmp+"***");
				tmp="";
			}
			else
			{
				tmp+=ch;
			}
		}
		//tu[0]="fff";
		System.out.print("\tlast**"+tmp+"***");
		return tu;
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StringBuffer str=new StringBuffer("");
        StringBuffer out=new StringBuffer("");
        String eng="",bng="";
        
        try
		{
			FileInputStream fis = new FileInputStream("Data\\Chinese\\NEWS09_train_EnCh_31961.xml\\Extracted_Chinese.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				String kk[]=split_tu(line.substring(0,line.indexOf("\t")));
			}
			fis.close();
		}catch(IOException f){}
		file_update("Data\\Chinese\\NEWS09_train_EnCh_31961.xml\\TU_Extracted_Chinese.txt",str.toString());
    }
}
