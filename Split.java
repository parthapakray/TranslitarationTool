import java.io.*;
/**
 * @(#)Split.java
 *
 *
 * @author 
 * @version 1.00 2009/4/8
 */

public class Split {
        
    /**
     * Creates a new instance of <code>Split</code>.
     */
    public Split() {
    }
    
    static String tus[][]=new String[10000][300];
    static int tus_count[]=new int[10000];
    static int count;
    
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
	
	
	public static boolean eng_is_vowel(char k) 
	{
		boolean flag=false;
		if(k=='a' ||k=='e' ||k=='i' ||k=='o' ||k=='u')
		{
			flag=true;
		}
		return flag;
	}
	
	public static boolean hnd_is_vowel(char ch) 
	{
		boolean flag=false;
		int k=(int)ch;
		if(k==2309 || k==2310 || k==2311 || k==2312 || k==2313 || k==2314 || k==2315 || k==2319 || k==2320 || k==2323 || k==2324 || k==2321 || k==2380 || k==2376 || k==2366 || k==2368 || k==2370 || k==2379 || k==2375 || k==2367 || k==2369 || k==2374 || k==2306 || k==2371 || k==2377 || k==2373 || k==2305)
		{
			flag=true;
		}
		return flag;
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        String str="";
        
        
        
        /*String tu="";
        int n=0;
        
        try
		{
			FileInputStream fis = new FileInputStream("Dev_test.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			while((line = br.readLine())!=null)
			{
				//System.out.println(line);
				for(int i=0;i<line.length();i++)
				{
					line=line.toLowerCase();
					
					char ch=line.charAt(i);
					if(eng_is_vowel(ch))
					{
						if(tu.length()>0)
						{
							tu+=ch;
							//System.out.print(n+"{{"+tu+"**");
							tus[count][n]=tu;
							n++;
							tu="";
						}
						else if(n>0)
						{
							tus[count][n-1]+=ch;
							tu="";
						}
					}
					else
					{
						tu+=ch;
					}
				}
				//System.out.print(tu+"**");
				//tu="";
				
				tus[count][n]=tu;
				n++;
				tu="";
							
				//System.out.println("\n########");
				tus_count[count]=n;
				count++;
				n=0;
			}
			fis.close();
		}catch(IOException f){}
		
		
		
		
		for(int i=0;i<count;i++)
		{
			for(int j=0;j<tus_count[i];j++)
			{
				System.out.print(tus[i][j]+"**");
			}
			System.out.println("\n########");
		}
		//file_update("Pinaki_BNG.txt",str.toString());*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String tu="";
        int n=0;
        
        try
		{
			FileInputStream fis = new FileInputStream("Dev_hindi.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				//System.out.println(line);
				for(int i=0;i<line.length();i++)
				{
					line=line.toLowerCase();
					
					char ch=line.charAt(i);
					if(hnd_is_vowel(ch))
					{
						if(tu.length()>0)
						{
							tu+=ch;
							//System.out.print(n+"{{"+tu+"**");
							tus[count][n]=tu;
							n++;
							tu="";
						}
						else if(n>0)
						{
							tus[count][n-1]+=ch;
							tu="";
						}
					}
					else
					{
						tu+=ch;
					}
				}
				//System.out.print(tu+"**");
				//tu="";
				
				tus[count][n]=tu;
				n++;
				tu="";
							
				//System.out.println("\n########");
				tus_count[count]=n;
				count++;
				n=0;
			}
			fis.close();
		}catch(IOException f){}
		
		
		
		
		for(int i=0;i<count;i++)
		{
			for(int j=0;j<tus_count[i];j++)
			{
				//System.out.print(tus[i][j]+"**");
				str+=tus[i][j]+"**";
			}
			//System.out.println("\n########");
			str+="\n########\n";
		}
		file_update("Hindi_Split.txt",str.toString());
    }
}
