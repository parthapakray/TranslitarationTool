import java.io.*;
/**
 * @(#)get_utf.java
 *
 *
 * @author 
 * @version 1.00 2009/4/8
 */

public class get_utf {
        
    /**
     * Creates a new instance of <code>get_utf</code>.
     */
    public get_utf() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        try
		{
			FileInputStream fis = new FileInputStream("hindi.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"utf-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				for(int i=0;i<line.length();i++)
				{
					char ch=line.charAt(i);
					System.out.print("k=="+(int)ch+" || ");
				}
			}
			fis.close();
		}catch(IOException f){}
    }
}
