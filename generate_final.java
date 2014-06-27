import java.io.*;
/**
 * @(#)generate_final.java
 *
 *
 * @author 
 * @version 1.00 2009/4/14
 */

public class generate_final {
        
    /**
     * Creates a new instance of <code>generate_final</code>.
     */
    public generate_final() {
    }
    
    
    static String ee[]=new String[1005];
    static String bb[][]=new String[1005][150];
    static int bb_count[]=new int[1005];
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
        
        String lan="Bng";
        
        StringBuffer str=new StringBuffer("");
        String eng="",bng="";
        
        
        
        String tmp="";
        
        try
		{
			//FileInputStream fis = new FileInputStream("Results_Standard.txt");
			//FileInputStream fis = new FileInputStream("Results_Non_Standard.txt");
			//FileInputStream fis = new FileInputStream("Results_Non_Standard_Man.txt");
			FileInputStream fis = new FileInputStream(lan+"_Standard.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				eng=line.substring(0,line.indexOf("\t")).trim();
				System.out.println(line+"\n"+eng);
				bng=line.substring(line.indexOf("\t")+1,line.length()).trim();
				System.out.println(eng+"**"+bng+"**");
				
				bng+="\t";
				
				ee[count]=eng;
				for(int i=0;i<bng.length();i++)
				{
					char ch=bng.charAt(i);
					if(ch=='\t' || ch==' ' || ch==',')
					{
						if(tmp.trim().length()>0)
						{
							if(is_exists(tmp,count))
							{
								//bb[count][bb_count[count]]="Common"+tmp;
								//bb_count[count]++;
							}
							else if(tmp.equalsIgnoreCase(eng))
							{
								//bb[count][bb_count[count]]="Eng"+tmp;
								//bb_count[count]++;
							}
							else
							{
								bb[count][bb_count[count]]=tmp;
								bb_count[count]++;
							}
						}
						tmp="";
					}
					else
					{
						tmp+=ch;
					}
				}
				//bb[count]=bng;
				count++;
				
				//str.append(eng+"**"+bng.replace("\t",",")+"**\n");
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}
		
		
		
		//file_update("Final.txt",str.toString());
		
		int n=0;
		
		try
		{
			FileInputStream fis = new FileInputStream("Test_"+lan+".xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				if(line.startsWith("<Name ID=\""+n+"\">"))
				{
					str.append(line+"\n");
					for(int i=0;i<bb_count[n];i++)
					{
						str.append("<TargetName ID=\""+(i+1)+"\">"+bb[n][i]+"</TargetName>");
					}
					n++;
				}
				else
				{
					str.append(line+"\n");
				}
				//str.append(eng+"**"+bng.replace("\t",",")+"**\n");
			}
			fis.close();
		}catch(IOException f){}
		
		
		//file_update("Results_Standard.xml",str.toString());
		//file_update("Results_Non_Standard.xml",str.toString());
		//file_update("Results_Non_Standard_Man.xml",str.toString());
		file_update("Results_"+lan+"_Standard_JU.xml",str.toString());
    }

	/**
	 * Method is_exists
	 *
	 *
	 * @param word
	 *
	 * @return
	 *
	 */
	public static boolean is_exists(String word, int id) {
		// TODO: Add your code here
		boolean flag=false;
		
		for(int i=0;i<bb_count[id];i++)
		{
			if(word.equals(bb[id][i]))
			{
				flag=true;
				break;
			}
		}
		
		return flag;
	}
}
