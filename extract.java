import java.io.*;
/**
 * @(#)extract.java
 *
 *
 * @author 
 * @version 1.00 2009/4/9
 */

public class extract {
        
    /**
     * Creates a new instance of <code>extract</code>.
     */
    public extract() {
    }
    
    /**
     * @param args the command line arguments
     */
     
     
     
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
	
    public static void main(String[] args) {
        // TODO code application logic here
        
        StringBuffer str=new StringBuffer("");
        StringBuffer out=new StringBuffer("");
        String eng="",bng="";
        
        try
		{
			//FileInputStream fis = new FileInputStream("F:\\Research\\Conferences\\NEWS\\2010\\Dev\\NEWS10_dev_EnHi_1974.xml");
			FileInputStream fis = new FileInputStream("NEWS10_test_EnHi_1000.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				//System.out.println(line);
				if(line.trim().startsWith("<Name"))
				{
					line = br.readLine();
					System.out.println(line);
					eng=line.substring(line.indexOf("<SourceName>")+"<SourceName>".length(),line.indexOf("</SourceName>"));
					//line = br.readLine();
					System.out.println(line);
					//bng=line.substring(line.indexOf("<TargetName ID=\"0\">")+"<TargetName ID=\"0\">".length(),line.indexOf("</TargetName>"));
					//System.out.println("***"+eng+"***"+bng+"***");
					//str.append(eng+"\t"+bng+"\n");
					//out.append(eng.trim().replace(" ","\n")+"\n");
					
					str.append(eng.trim().toLowerCase()+"\n");
				}
				else
				{
					//System.out.println(line);	
				}
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}
		file_update("F:\\Research\\Conferences\\NEWS\\2010\\Test\\Hnd_Test_Eng.txt",str.toString());
		//file_update("Test_Hindi_Single.txt",out.toString());
    }
}
