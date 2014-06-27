import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 * @(#)ECI.java
 *
 *
 * @author 
 * @version 1.00 2010/3/17
 */

public class ECI {
        
    /**
     * Creates a new instance of <code>ECI</code>.
     */
    public static String getNames(String word)
    {
    	Properties prop=new Properties();
        prop.put("charSet","utf-8");
    	Connection con;
    	String bng="";
        try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}catch(ClassNotFoundException e){}
		try
		{
			
			con = DriverManager.getConnection("jdbc:odbc:news",prop);
			con.setAutoCommit(true);
			java.sql.Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//ResultSet rs=stmt.executeQuery("select * from DB where nameE='"+word+"' ORDER BY freq DESC"); 
			//ResultSet rs=stmt.executeQuery("select * from total where eng='"+eng+"'"); 
			ResultSet rs=stmt.executeQuery("select * from Hnd where nameE='"+word+"' ORDER BY freq DESC"); 
			while(rs.next())
			{
				String nn=rs.getString("nameH");
				String freq=rs.getString("freq");
				System.out.println(word+"\t"+freq);
				if(bng.indexOf("/"+nn+"/")>0 || bng.indexOf(nn+"/")==0)
				{
				}
				else
				{
					bng+=nn+"/";
				}
			}
			con.close();
		}
		catch (SQLException sqle){System.out.println(sqle);}
		if(bng.length()>0)
		{
			return bng;
		}
		else
		{
			return "";
		}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void file_update(String path,String txt) 
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path,true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));
			bw.write(txt);
			bw.flush();
			fos.close();
		}catch(IOException f){}	
	}
    public static void main(String[] args) 
    {
        // TODO code application logic here
        try
		{
			FileInputStream fis = new FileInputStream("Hnd_Test_Eng.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
			String line;
			while((line = br.readLine())!=null)
			{
				System.out.println(getNames(line.trim().toUpperCase()));
				file_update("Hnd_Test_ECI.txt",getNames(line.trim().toUpperCase())+"\n");
			}
			fis.close();
		}catch(IOException f){}
    }
}
