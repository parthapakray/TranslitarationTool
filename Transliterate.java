//package Program;

import java.io.*;
/**
 * @(#)Transliterate.java
 *
 *
 * @author 
 * @version 1.00 2009/3/25
 */

public class Transliterate {
        
    /**
     * Creates a new instance of <code>Transliterate</code>.
     */
    public Transliterate() {
    }
    public static void file_update(String path,String txt) 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
			bw.write(txt);
			System.out.println(txt);
			bw.flush();
			fos.close();
		}catch(IOException f){}	
	}
	
	public static String TransHndToBng(String hindi) 
	{
		//String[] hnd=new String[]{"0901","0921","093c","0922","093c","0902","0903","0905","0906","0907","0908","0909","090a","090b","090f","0910","0913","0914","0915","0916","0917","0918","0919","091a","091b","091c","091d","091e","091f","0920","0921","0922","0923","0924","0925","0926","0927","0928","092a","092b","0935","092c","092d","092e","095f","0930","0932","0936","0937","0938","0939","093c","093e","093f","0940","0941","0942","0943","0947","0948","094b","094c","094d","092f"};
		//String[] bng=new String[]{"0981","09a1","09bc","09a2","09bc","0982","0983","0985","0986","0987","0988","0989","098a","098b","098f","0990","0993","0994","0995","0996","0997","0998","0999","099a","099b","099c","099d","099e","099f","09a0","09a1","09a2","09a3","09a4","09a5","09a6","09a7","09a8","09aa","09ab","09ac","09ac","09ad","09ae","09df","09b0","09b2","09b6","09b7","09b8","09b9","09bc","09be","09bf","09c0","09c1","09c2","09c3","09c7","09c8","09cb","09cc","09cd","09af"};
		
		int[] hnd=new int[]{65279,2305,2337,2364,2338,2364,2306,2307,2309,2310,2311,2312,2313,2314,2315,2319,2320,2323,2324,2325,2326,2327,2328,2329,2330,2331,2332,2333,2334,2335,2336,2337,2338,2339,2340,2341,2342,2343,2344,2346,2347,2357,2348,2349,2350,2399,2352,2354,2358,2359,2360,2361,2364,2366,2367,2368,2369,2370,2371,2375,2376,2379,2380,2381,2351,10};
		int[] bng=new int[]{65279,2433,2465,2492,2466,2492,2434,2435,2437,2438,2439,2440,2441,2442,2443,2447,2448,2451,2452,2453,2454,2455,2456,2457,2458,2459,2460,2461,2462,2463,2464,2465,2466,2467,2468,2469,2470,2471,2472,2474,2475,2476,2476,2477,2478,2527,2480,2482,2486,2487,2488,2489,2492,2494,2495,2496,2497,2498,2499,2503,2504,2507,2508,2509,2479,10};
		
		String bengali="";
		
		for(int i=0;i<hindi.length();i++)
		{
			char ch=hindi.charAt(i);
			if(ch==',' || ch==' ' || ch=='-')
				bengali+=ch;
			else
			{
				int k=(int)ch;
				//String s="0"+Integer.toHexString(k);
				for(int j=0;j<bng.length;j++)
				{
					if(bng[j]==k)
					{
						//System.out.println("Match   " +hnd[j]+"    "+bng[j]);
						
						
						String v=Character.toString((char)(hnd[j]));
						//String v=Character.toString((char)(bng[j]));
						bengali+=v;
						//System.out.println(Character.toChars(bng[j]));
					}
				}
			}
		}
		return bengali;
	}
   
    public static void main(String[] args) {
       
        OnTransliterationBangla3 bb=new OnTransliterationBangla3();
      // file_update("testHind122.txt",TransHndToBng(bb.GetString("once upon a time")));
        
        StringBuffer str=new StringBuffer("");
        String eng="",bng="";
        
      
		
	
		String lan="Hnd";
		
		
		try
		{
			FileInputStream fis = new FileInputStream(lan+"_Test_Eng.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				//str.append(TransHndToBng(bb.GetString(line.trim()))+"\n");
				//str.append(bb.GetString(line.trim())+"\n");
				file_update(lan+"_Test_JSC_Bng.txt",TransHndToBng(bb.GetString(line.trim()))+"\n");
			}
			fis.close();
		}catch(IOException f){}
		
		//file_update("Test_our.txt",str.toString());
    }
    
}
