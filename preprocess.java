import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import rita.wordnet.RiWordnet;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
import java.util.*;

public class preprocess
{
	RiWordnet wnr ;
	private RiWordnet wordnet_data = new RiWordnet(null); 
	BufferedWriter wf =null;
	FileOutputStream of =null;
	
	public preprocess()
	{
		wnr=new RiWordnet(null);
	}
	public String wordnet_synset(String pp)
	{
		    String word=pp,output="";
			String wordForm =word;
						
			WordNetDatabase database = WordNetDatabase.getFileInstance();
			Synset[] synsets = database.getSynsets(wordForm);
			
			if (synsets.length > 0)
			{
				
				for (int i = 0; i < synsets.length; i++)
				{
					String[] wordForms = synsets[i].getWordForms();
					
					for (int j = 0; j < wordForms.length; j++)
					{
						output +="@"+wordForms[j];
					    
					}

				}
			}
			else
			{
				output="NA";
			}
			return output;
	}

	
	
	
	
	
	
	public void outputformat()
	{
		  try{
			  	BufferedReader r1 =null;
				FileInputStream i1 = new FileInputStream("FIREDevdata/Subtask1_TestData/Hindi_Test.txt");
				r1 = new BufferedReader(new InputStreamReader(i1,"UTF-8"));
				
			  	BufferedReader r2 =null;
				FileInputStream i2 = new FileInputStream("FIREDevdata/Subtask1_TestData/Hnd_Test_JSC_Bng_output.txt");
				r2 = new BufferedReader(new InputStreamReader(i2,"UTF-8"));
				
				of= new FileOutputStream("FIREDevdata/Subtask1_TestData/HindiSystemOut.txt",true);
		  		wf = new BufferedWriter(new OutputStreamWriter(of,"UTF-8"));
				
				
				
				
				 String str1 = "", str2="";
		            
				 while ((str1 = r1.readLine()) != null && (str2 = r2.readLine()) != null ) {
					
					 String ss1[]=str1.split(" ");
					 String ss2[]=str2.split(" ");
					 
					 preprocess prs= new preprocess();
						
						for(int i=0;i<ss1.length;i++)
							
						{
							if(prs.wordnet_synset(ss1[i]).equals("NA")){
								System.out.print(ss1[i]+"\\H="+ss2[i]+" ");
								wf.write(ss1[i]+"\\H="+ss2[i]+" ");
							}
							else{
								
								System.out.print(ss1[i]+"\\E"+" ");
								wf.write(ss1[i]+"\\E"+" ");
							}
								
	
						}
						System.out.println();
						
						wf.write("\n");
					 
				 }
				
				
				wf.close();
				of.close();
				
				
				
				
		  
		  
		  }
		  catch (Exception ex)
		  {
			  ex.printStackTrace();
		  }
	}

	
	
		
	
	public static void main(String args[])
	{
		preprocess pp= new preprocess();
		pp.outputformat();
		
		
	}

}