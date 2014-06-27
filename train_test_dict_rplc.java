import java.io.*;
/**
 * @(#)train_test_dict_rplc.java
 *
 *
 * @author 
 * @version 1.00 2009/4/11
 */

public class train_test_dict_rplc {
        
    /**
     * Creates a new instance of <code>train_test_dict_rplc</code>.
     */
    public train_test_dict_rplc() {
    }
    static String eng[]=new String[20000];
    static String bng[]=new String[20000];
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
	
	
	
	
	public static void read_dict(String lan) 
	{
		try
		{
			FileInputStream fis = new FileInputStream("Tranin Analysis\\Train_Single.txt");
			//FileInputStream fis = new FileInputStream(lan+"_Dev_Single.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				eng[count]=line.substring(0,line.indexOf("\t")).trim().toLowerCase();
				bng[count]=line.substring(line.indexOf("\t")+1,line.length()).trim();
				count++;
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}	
			
		/*try
		{
			FileInputStream fis = new FileInputStream("Tranin Analysis\\Hnd_Dev_Single.txt");
			//FileInputStream fis = new FileInputStream(lan+"_Dev_Single.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				eng[count]=line.substring(0,line.indexOf("\t")).trim().toLowerCase();
				bng[count]=line.substring(line.indexOf("\t")+1,line.length()).trim();
				count++;
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}*/	
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuffer str=new StringBuffer("");
        
        int n=0;
        
        String lan="Hnd";
        
        read_dict(lan);
        /*for(int i=0;i<count;i++)
        {
        	str.append(eng[i]+"*****"+bng[i]+"****\n");
        }
        file_update("Read_Testing.txt",str.toString());*/
        
        
        
        
        
        try
		{
			FileInputStream fis = new FileInputStream(lan+"_Test_Eng.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				line=line.toLowerCase();
				String xxx=find_dict(line.trim());
				if(xxx.length()>0)
					n++;
				str.append(xxx+"\n");
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}	
		file_update(lan+"_Test_Set_By_Dev.txt",str.toString());
		System.out.println("Matches\t"+n);
    }

	/**
	 * Method find_dict
	 *
	 *
	 * @param word
	 *
	 * @return
	 *
	 */
	public static String find_dict(String word) {
		// TODO: Add your code here
		word=word.toLowerCase();
		String bng_word="";
		
		for(int i=0;i<count;i++)
        {
        	if(word.trim().equalsIgnoreCase(eng[i].trim()))
        	{
        		bng_word=bng[i];
        	}
        }
        return bng_word;
	}
}
