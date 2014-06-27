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

public class wordnet_feature
{
	RiWordnet wnr ;
	private RiWordnet wordnet_data = new RiWordnet(null); 
	
	
	public wordnet_feature()
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

	
	
		
	
	public static void main(String args[])
	{
		wordnet_feature prs= new wordnet_feature();
		System.out.println(prs.wordnet_synset("ami"));
		
	}

}