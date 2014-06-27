import java.io.*;
/**
 * @(#)make_back.java
 *
 *
 * @author 
 * @version 1.00 2009/4/10
 */

public class make_back {
        
    /**
     * Creates a new instance of <code>make_back</code>.
     */
    public make_back() {
    }
    
    static String bng[]=new String[1000];
    static int count=0;
    
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        read();
        
        StringBuffer str=new StringBuffer("");
        String kk="";
        int n=0;
        
        try
		{
			FileInputStream fis = new FileInputStream("Dev_EnHi_974.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				if(line.startsWith("<Name"))
				{
					kk=line.substring(line.indexOf("<TargetName ID=\"0\">")+"<TargetName ID=\"0\">".length(),line.indexOf("</TargetName>"));
					str.append(line.replace(kk,bng[n].trim())+"\n");
					n++;
				}
				else
				{
					str.append(line+"\n");
				}
			}
			fis.close();
		}catch(IOException f){}
		file_update("Dev_Back.txt",str.toString());
    }

	/**
	 * Method read
	 *
	 *
	 */
	public static void read() {
		// TODO: Add your code here
		
		try
		{
			FileInputStream fis = new FileInputStream("total.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				bng[count]=line;
				count++;
			}
			fis.close();
		}catch(IOException f){}
	}
}
