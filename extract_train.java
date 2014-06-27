import java.io.*;
/**
 * @(#)extract_train.java
 *
 *
 * @author 
 * @version 1.00 2009/4/11
 */

public class extract_train {
        
    /**
     * Creates a new instance of <code>extract_train</code>.
     */
    public extract_train() {
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StringBuffer str=new StringBuffer("");
        StringBuffer out=new StringBuffer("");
        StringBuffer othr=new StringBuffer("");
        StringBuffer ttl=new StringBuffer("");
        String eng="",bng="",xy="",yx="";
        
        String eng_split[]=new String[100];
        String bng_split[]=new String[100];
        int eng_count=0,bng_count=0;
        
        String tmp="";
        
        try
		{
			FileInputStream fis = new FileInputStream("NEWS10_train_EnBa_11938.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				if(line.trim().startsWith("<Name"))
				{
					line=br.readLine();
					eng=line.substring(line.indexOf("<SourceName>")+"<SourceName>".length(),line.indexOf("</SourceName>"));
					line=br.readLine();
					bng=line.substring(line.indexOf("<TargetName ID=\"1\">")+"<TargetName ID=\"0\">".length(),line.indexOf("</TargetName>"));
					//System.out.println("***"+eng+"***"+bng+"***");
					if(eng.trim().indexOf(" ")>0 && bng.trim().indexOf(" ")>0)
					{
						eng+=" ";
						bng+=" ";
						
						for(int i=0;i<eng.length();i++)
						{
							char ch=eng.charAt(i);
							if(ch==' ')
							{
								eng_split[eng_count]=tmp;
								eng_count++;
								tmp="";
							}
							else
							{
								tmp+=ch;
							}
						}
						
						tmp="";
						
						
						for(int i=0;i<bng.length();i++)
						{
							char ch=bng.charAt(i);
							if(ch==' ')
							{
								bng_split[bng_count]=tmp;
								bng_count++;
								tmp="";
							}
							else
							{
								tmp+=ch;
							}
						}
						
						
						if(eng_count==bng_count)
						{
							//othr.append(eng_split[i]+"\t"+bng_split[i]+"\n");
							for(int i=0;i<eng_count;i++)
							{
								str.append(eng_split[i]+"\t"+bng_split[i]+"\n");
								xy+=eng_split[i]+" ";
								yx+=bng_split[i]+" ";
								//ttl.append(eng_split[i]+"\t"+bng_split[i]+"\n");
							}
							othr.append(xy+"\t"+yx+"\n");
							xy="";
							yx="";
							eng_count=0;
							bng_count=0;
						}
						else
						{
							out.append(eng+"\t"+bng+"\n");
						}
						eng_count=0;
						bng_count=0;
					}
					else
					{
						str.append(eng+"\t"+bng+"\n");
						//ttl.append(eng+"\t"+bng+"\n");
					}
					//out.append(eng.trim().replace(" ","\n")+"\n");
				}
				else
				{
					//str.append(line+"\n");
				}
			}
			fis.close();
		}catch(IOException f){System.out.println(f);}
		file_update("Train_Single.txt",str.toString());
		file_update("Exception_train.txt",out.toString());
		file_update("MWE_train.txt",othr.toString());
		//file_update("Total_train_single.txt",ttl.toString());
    }
}
