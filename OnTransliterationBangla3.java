//package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class OnTransliterationBangla3
{
		static ResultSet res,ress;
	    static Connection conn;
     	static Statement stat;
	    static String od;
     	static String tnn;    
	
 public static String GetString(String lower)
 {
 	    char a,e,i,o,u,x;
		char array[]=new char[20];
		char zzz[]=new char[20];
		String pices[]=new String[20];
		String arr[]=new String[20];
		String cc[]=new String[20];
		String fcc[]=new String[20];
		String strr9[]=new String[20];
		String strr11[][]=new String[500][3];
		String strr12[][]=new String[200][6];
		int m=0,j,n=0,y=0,p=0,p1=0,p22=0,p33=0,k1=0,flaag2=0,mm=0,nn=0;
		int as=0,i2=0;
		String s="";
		String st3="";
		String st5="";
		String s1="";
		String str4="";
		String str5="";
		String strr10="";
		String s3="";
		String strrr="";
		String strrr3="";
		String strrr6="";
		String strrr4="";
		String zz2="";
		String zz3="";
		String sttt="";
		String sttt1="",t1="";
		int ii,i3;
		char zz1,ch1;
		String zzz1="";
		String zzz2="";
		String line="";
		int flaag3=0,n1,n2=0,x1,x2=0,x3=0,x4=0;
		strr10=lower;
		
		/*ss c=new ss();
		conn=c.getConnection("ss");*/
		/*try{*/
		
		while(p1!=-1 || p22!=-1 || p33!=-1)
		{
			//System.out.println(lower);
			p1=lower.indexOf(" ");
			p22=lower.indexOf("-");
			p33=lower.indexOf("_");
			
			//if(p1)
			
			
			
			if(p1!=-1 && (p1<p22 || p22==-1) && (p1<p33 || p33==-1))
			{
			    p1=lower.indexOf(" ");
			  	strr9[k1]=lower.substring(0,p1);
				zzz[mm]=lower.charAt(p1);
				zzz1+=zzz[mm];
				lower=lower.substring(p1+1);
				mm++;k1++;
			  
			  	
			}
			
			if(p22!=-1 && (p22<p1 || p1==-1) && (p22<p33 || p33==-1))
			{
			  p22=lower.indexOf("-");
			  //System.out.println(p22);
			  strr9[k1]=lower.substring(0,p22);
			  zzz[mm]=lower.charAt(p22);
			  lower=lower.substring(p22+1);
			  zzz1+=zzz[mm];
			  k1++;
			  mm++;	
			}
			if(p33!=-1 && (p33<p22 || p22==-1) && (p33<p1 || p1==-1))
			{
			  strr9[k1]=lower.substring(0,p33);
			  zzz[mm]=lower.charAt(p33);
			  lower=lower.substring(p33+1);
			  zzz1+=zzz[mm];
			  k1++;
			  mm++;	
			}
		}
		  strr9[k1]=lower;
		  for(p1=0;p1<=k1;p1++)
		  System.out.println("Word: "+strr9[p1]);	
		  
		/*ss c=new ss();
		conn=c.getConnection("ss");*/
		
		
		try
	{
				 
	BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream("Cons_Lex.txt");			 
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   while((line=br3.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   strr11[x2][x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  //System.out.println(ch1);
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	  strr11[x2][x1]=t1;
      x2++;
   }
			  br3.close();
	}catch(Exception ee) 
	{
		ee.printStackTrace();
	}

		//System.out.println("************"+strr11[1][1]);
		
		
		// for iscii to utf***************
		
			try
	{
				 
	BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream("IsciiUtfMap.txt");			 
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   while((line=br3.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   strr12[x3][x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  //System.out.println(ch1);
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	  strr12[x3][x1]=t1;
      x3++;
   }
			  br3.close();
	}catch(Exception ee) 
	{
		ee.printStackTrace();
	}
		//System.out.println("************"+strr12[1][2]);
		
		for(int k2=0;k2<=k1;k2++)
		{
		  y=0;n=0;p=0;flaag2=0;
		  
		  
		  strr10=strr9[k2];
				
		String str = strr10.toLowerCase();
		
		 System.out.println("Starting........"+str);
		 //System.out.println("Starting........");
	try
	{
		 x1=0;
   BufferedReader br =null;
   FileInputStream fis = new FileInputStream("Exceptions.txt");
   br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
   while((line=br.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  //System.out.println(ch1);
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	 // System.out.println("search is for:"+arr[1]);
      if(arr[1].equals(str))
      {
      	st3=arr[2];
		flaag2=1;
		//System.out.println("Execpton found.."+st3);
		break;
      }
      
      
      	
   	  
   }
      br.close();
	}catch(Exception ex){
					  }
		 
		 
		 
		 
		 
		 
		 
		 
		 if(flaag2==1)
		 {
		 	if(k2<k1)
		    st3+=" ";
		 }
		 
		else
		{
		
		int len=str.length();
		
		int flagg=0,i1;
		int t=0;s="";
		for(j=0;j<len;j++)
		{
			
			x=str.charAt(j);
			if(flagg==1 && x!='a' && x!='e' && x!='i' && x!='o' && x!='u')
			{
				int len2=s.length();
				String s2=s.substring(0,len2-t);
				cc[y]=s2;
				pices[n]=s;
				s="";
				n++;
			    y++;
			    flagg=0;
			    t=0;
			 }
			if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u')
			{
					
				s+=x;
				flagg=1;
				t++;
				
			 }
			 else
			 {
			 	s+=x;
			 	
			 	
			 }
			
			
			
		}
		if(s.equals(""))
		{
		  	
		  	y--;n--;
		}
		else
		{
		  	int len3=s.length();
		  	
		  	if(len3>1)
		  	{
		  	  
		  	  
				
				s3=s.substring(0,len3-t);
				cc[y]=s3;
		  	}
		  	else
		  	cc[y]=s;
		  	pices[n]=s;
		 }
		 
		 for(int k=0;k<=y;k++)
		 {       
		   String str2=cc[k];
		   //System.out.println(str2);
		   int flag=0,flag1=0,flag2=0,fllag=0;
		   int len4=str2.length();
		   if(len4==0)
		   {    fcc[p]=pices[k];
			    p++;
			    continue;
		   }
		   
		   for(int kk1=0;kk1<x2;kk1++)
		   {
		   	  	if(strr11[kk1][0].equals(str2))
			    {
			      	flag=1;
        			fcc[p]=pices[k];
					p++;
					break;
			     }
		   	 
		   }
		   
			 if(flag==1)
			 {
			 	
			 	
			 	
			 }	
					
			 else
			 {
						
						
			   
			   int len1=str2.length();
			   
				
			   String st1=pices[k];
			   
			   
			   for(i1=0;i1<st1.length();i1++)
			  {
			    char sp=st1.charAt(i1);
				if(sp!='a' && sp!='e' && sp!='i' && sp!='o' && sp!='u')
			    {
			       	
				}
				 else
				 {
				 	 st1=st1.substring(i1);
				 	 fllag=1;
				 	break;
				 }
				 
			   }
			   
			   
			   while(as==0 && len1>0)
			   {
				 String z1=str2.substring(0,len1-1);
				 String z=str2.substring(len1-1);
			
				for(int kk1=0;kk1<x2;kk1++)
		        {
		   	 
		   	 	if(strr11[kk1][0].equals(z))
			    {
			      	flag1=1;
        			
			     }
			     if(strr11[kk1][0].equals(z1))
                 {
      	           flag2=1;
		         }
		        if(flag2==1 && flag1==1)
		        {
		      	  break;
		        }
			     
		   	   }
				
				 
				if(flag1==1 && flag2==1)
				{
				  //System.out.println("shibu entered");
				  fcc[p]=z1;
				  if(fllag==1)
				  z+=st1;
				  fcc[++p]=z;as=1;p++;
				} 
						   
				else
				{
				 	len1--;
				}
			}
					
						   
		}
					   
					
		//conn.close();
     /*}
				
	 catch(Exception ee) {}	*/
   }
		       
		      
		       
		       
		       String str10="";
		       String st4="";
		       String st44="";
		       int k;
		       for(k=0;k<p;k++)
		       {
		       	  int k9=0,k12;st44="";
		       	  sps1 v=new sps1();
		       	  String str6=fcc[k];
		       	  String str7=fcc[k+1];
		       	  if(k==0) 
		       	  {
		       	  	k12=k;
		       	  	st44=Integer.toString(k12);
		       	  	//st44="out.txt";
		       	  	//System.out.println(st44+".......................");
		       	  	
		       	  	          st44="";
		       //System.out.println(fcc[k]);
		       
		       //creaton of tube files..............................
		       try
		       {
		       
		       BufferedReader br6 =null;
   FileInputStream fis6 = new FileInputStream("Trigram_BL__L.txt");
   br6 = new BufferedReader(new InputStreamReader(fis6,"UTF-8"));
   while((line=br6.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	  if(arr[2].equals(fcc[k]))
      {
      	st44+=line+"\n";
      }
     
   }
			  
			  
			  try
      	{
      	
      	BufferedWriter wr =null;
        FileOutputStream fos = new FileOutputStream("out.txt");
        wr = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        wr.append(st44);
        wr.close();
      	}catch(Exception ee)
      	{
      	}
		}catch(Exception ee)
		{
			//System.out.println(",........................");
		}
		       	  	
		       	  	
		       	  	st44="out.txt";
		       	  	
		       	  	str10=v.getstring(k,p,null,str6,str7,null,st44);
		       	  	k9=1;
		       	  }
		       	  
		       	  if(k==p-1 && k9!=1) 
		       	  {
		       	  	k12=k;
		       	  	st44=Integer.toString(k12);
		       	  	//st44="out.txt";
		       	  	//System.out.println(st44+".......................");
		       	  	st4=fcc[k-1];
		       	  	
		       	  	
		       	  	          st44="";
		       //System.out.println(fcc[k]);
		       
		       //creaton of tube files..............................
		       try
		       {
		       
		       BufferedReader br6 =null;
   FileInputStream fis6 = new FileInputStream("Trigram_BL__L.txt");
   br6 = new BufferedReader(new InputStreamReader(fis6,"UTF-8"));
   while((line=br6.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	  if(arr[2].equals(fcc[k]))
      {
      	st44+=line+"\n";
      }
     
   }
			  
			  
			  try
      	{
      	
      	BufferedWriter wr =null;
        FileOutputStream fos = new FileOutputStream("out.txt");
        wr = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        wr.append(st44);
        wr.close();
      	}catch(Exception ee)
      	{
      	}
		}catch(Exception ee)
		{
			//System.out.println(",........................");
		}
		       	  	
		       	  	st44="out.txt";
		       	  	str10=v.getstring(k,p,st4,str6,null,str10,st44);
		       	  }
		       	   
		       	  if(k>0 && k<p-1)
		       	  {
		       	   	 k12=k;
		       	  	st44=Integer.toString(k12);
		       	  	//st44="o_"+st44+".txt";
		       	  	//System.out.println(st44+".......................");
		       	   	 st4=fcc[k-1];
		       	   	 
		       	   	 try
		       {
		       
		       BufferedReader br6 =null;
   FileInputStream fis6 = new FileInputStream("Trigram_BL__L.txt");
   br6 = new BufferedReader(new InputStreamReader(fis6,"UTF-8"));
   while((line=br6.readLine())!=null)
   {
   	  x1=0;t1="";n2=0;
   	  n1=line.length();
   	  //System.out.println(line);
   	  while(n2<n1)
   	  {
   	  	ch1=line.charAt(n2);
   	  	if(ch1==',')
   	  	{
   	  	   t1=t1.replaceAll("\"","");
   	  	   arr[x1]=t1;
   	  	   t1="";
   	  	   x1++; 	
   	  	}
   	  	
   	  	else
   	  	t1+=ch1;	
   	  	n2++;
   	  }
   	  
   	  t1=t1.replaceAll("\"","");
   	  arr[x1]=t1;
   	  if(arr[2].equals(fcc[k]))
      {
      	st44+=line+"\n";
      }
     
   }
			  
			  
			  try
      	{
      	
      	BufferedWriter wr =null;
        FileOutputStream fos = new FileOutputStream("out.txt");
        wr = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        wr.append(st44);
        wr.close();
      	}catch(Exception ee)
      	{
      	}
		}catch(Exception ee)
		{
			//System.out.println(",........................");
		}
		       	  	
		       	  	st44="out.txt";
		       	   	 
		       	   	 
		       	   	 str10=v.getstring(k,p,st4,str6,str7,str10,st44);
		       	  }
		       	    
		       	    st3+=str10;
		       	     
		       }
		           if(k2<k1)
		       	    st3+=" ";
		       	    for(k=0;k<p;k++)
		       	    fcc[k]=null;
		       	    
		          
		          
		          
		          }
		          
		          
		          
		          
		          
		          
		          
		          
		          
		}
		//conn.close();          	          
		
	
		
		  int p2=0,k4=0;
		  String st6="";
		  String strrr10[]=new String[20];
		  while(p2!=-1)
		  {
			p2=st3.indexOf(" ");
			
			if(p2!=-1)
			{
			  strrr10[k4]=st3.substring(0,p2);
			  st3=st3.substring(p2+1);
			  k4++;	
			}
			
		  }
		  strrr10[k4]=st3;
		  
		 /* try
		  {*/
		  
		  for(int k5=0;k5<=k4;k5++)
		  {
		  	st3=strrr10[k5];
		  	int kk=st3.length();
		    //System.out.println(st3+"*********"+kk);
		    for(int zz=0;zz<kk;)
		   {
		  	zz2="";flaag3=0;strrr6="";strrr3="";
		  	zz1=st3.charAt(zz);
		  	zz2+=zz1;
		  	zz++;
		  	if(zz<kk)
		  	{
		  	  zz1=st3.charAt(zz);
		  	zz2+=zz1;
		  	zz++;	
		  	}
		  	
		    for(int kk1=0;kk1<x3;kk1++)
		   {
		   	  	strrr3=strr12[kk1][5];
		   	  	if(strr12[kk1][2].equals(zz2))
		        {
		      	  i3=Integer.parseInt(strrr3);
				  char ch2=(char)i3;
				  strrr3="";
				  strrr3+=ch2;
				  st5+=strrr3;
				  flaag3=1;
				//System.out.println("shbi"+flaag3);
				  break;
		       }
		   	 
		   }
		    if(flaag3==0)
		    {
		  	  	//System.out.println("shibu"+flaag3);
		  	  	zz--;
		  	  	int zx=zz2.length();
		  	  	zz3="";
		  	    zz1=zz2.charAt(0);
		  	    zz3+=zz1;
		  	    
			for(int kk1=0;kk1<x3;kk1++)
		   {
		   	  	strrr3=strr12[kk1][5];
		   	  	if(strr12[kk1][2].equals(zz3))
		        {
		      	  i3=Integer.parseInt(strrr3);
		          char ch2=(char)i3;
		          strrr3="";
		          strrr3+=ch2;
		          st5+=strrr3;
	              break;
		       }
		   	 
		   }
		  	  	
		  	}
		  	
		  }
		    
		    if(k5<k4)
		    {
		       zzz2+=zzz1.charAt(nn);
		       st6+=st5+zzz2;
		       zzz2="";nn++;	
		    }
		    
		    else
		    st6+=st5;
		    st5="";
		    
		   } 
		    st3=st6;
		  
		return st3;

          
 }
 }
  class sps1
{
	static ResultSet res,ress;
	    static Connection conn;
     	static Statement stat;
	    static String od;
     	static String tnn;
	
	sps1()
	{
		
	}
	
	
	public static String getstring(int k,int p,String str,String str1,String str2,String str3,String st44)
	{
		String str9="";
		String str12="";
		String strr1="";
		String strr2="";
		String strr3="";
		String strr4="";
		String strr5="";
		String strr6="";
		String strr7="";
		String strr8="";
		String conslex="";
		String vlex="";
		String t11="";
		String line="";
		String strrr33="";
		String arr1[]=new String[20];
		String strr13[][]=new String[4000][7];
		String strr14[][]=new String[500][3];
		String strr15[][]=new String[200][4];
		char ch1;
		int in=0,sp1=0,sp2=0,sp3=0,sp=0,sp4=0,sp5=0,sp6=0,flaggg=0,x11=0,n11,n22=0,hits=0,hits1=0,hits2=0,x4=0,x5=0,x6=0;
		
		
		try
	{
				 
	BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream("Cons_Lex.txt");			 
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   while((line=br3.readLine())!=null)
   {
   	  x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   strr14[x5][x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  //System.out.println(ch1);
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;
   	  strr14[x5][x11]=t11;
      x5++;
   }
			  br3.close();
	}catch(Exception ee) 
	{
		ee.printStackTrace();
	}
               
               
               
          try
	{
				 
	BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream("V_Lex.txt");			 
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   while((line=br3.readLine())!=null)
   {
   	  x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   strr15[x6][x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  //System.out.println(ch1);
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;
   	  strr15[x6][x11]=t11;
      x6++;
   }
			  br3.close();
	}catch(Exception ee) 
	{
		ee.printStackTrace();
	}
     
		
		try{
		if(k==0)
		{
			//System.out.println("sssssssssssssssssssssss");
			flaggg=1;
			
			
				try
	{
				 
	BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream(st44);			 
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   while((line=br3.readLine())!=null)
   {
   	  x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   strr13[x4][x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  //System.out.println(ch1);
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;
   	  strr13[x4][x11]=t11;
      x4++;
   }
			  br3.close();
	}catch(Exception ee) 
	{
		ee.printStackTrace();
	}

			//System.out.println(strr13[1][2]);
			
			  
			  for(int kk1=0;kk1<x4;kk1++)
		     {
		   	  	strrr33=strr13[kk1][5];
		   	  	if(strr13[kk1][1].equals("") && strr13[kk1][2].equals(str1) && strr13[kk1][3].equals(str2) && strr13[kk1][4].equals(""))
			    {
			      	if(hits<Integer.parseInt(strr13[kk1][6]))
			      	{
			      	  str9=strr13[kk1][5];
			      	  hits=Integer.parseInt(arr1[6]);
			      	  in=1;
			      	}
			      	
			     }
		   	 
		    }
		      
		      if(in==0)
		      {
		      	hits=0;hits1=0;hits2=0;
		      
		     for(int kk1=0;kk1<x4;kk1++)
		     {
		   	  	strrr33=strr13[kk1][5];
		   	  	if(strr13[kk1][2].equals(str1) && strr13[kk1][3].equals(str2) && strr13[kk1][4].equals(""))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  strr1=strr13[kk1][5];
      	  strr2=strr13[kk1][6];
      	  hits=Integer.parseInt(strr2);
      	  sp1=1;
      	}
      	
      }
      
      if(strr13[kk1][1].equals("") && strr13[kk1][2].equals(str1) && strr13[kk1][4].equals(""))
      {
      	if(hits1<Integer.parseInt(strr13[kk1][6]))
      	{
      	  strr3=strr13[kk1][5];
      	  strr4=strr13[kk1][6];
      	  hits1=Integer.parseInt(strr4);;
      	  sp2=1;
      	}
      	
      }
      
      if(strr13[kk1][1].equals("") && strr13[kk1][2].equals(str1) && strr13[kk1][3].equals(str2))
      {
      	if(hits2<Integer.parseInt(strr13[kk1][6]))
      	{
      	  strr5=strr13[kk1][5];
      	  strr6=strr13[kk1][6];
      	  hits2=Integer.parseInt(strr6);;
      	  sp3=1;
      	}
      	
      }
		   	 
		    }
		  
		  
		        
		      if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      //System.out.println(sp+".."+sp4+".."+sp5);
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		           hits=0;hits1=0;hits2=0;
		           
		           for(int kk1=0;kk1<x4;kk1++)
		     {
		   	  	strrr33=strr13[kk1][5];
		   	  	if(strr13[kk1][2].equals(str1) && strr13[kk1][3].equals(str2))
      {
      	if(hits<Integer.parseInt(strr13[kk1][6]))
      	{
      	  strr1=strr13[kk1][5];
      	  strr2=strr13[kk1][6];
      	  hits=Integer.parseInt(strr13[kk1][6]);
      	  sp1=1;
      	}
      	
      }
      
      if(strr13[kk1][1].equals("") && strr13[kk1][2].equals(str1))
      {
      	if(hits1<Integer.parseInt(strr13[kk1][6]))
      	{
      	  strr3=strr13[kk1][5];
      	  strr4=strr13[kk1][6];
      	  hits1=Integer.parseInt(strr13[kk1][6]);
      	  sp2=1;
      	}
      	
      }
      
      if(strr13[kk1][2].equals(str1) && strr13[kk1][4].equals(""))
      {
      	if(hits2<Integer.parseInt(strr13[kk1][6]))
      	{
      	  strr5=strr13[kk1][5];
      	  strr6=strr13[kk1][6];
      	  hits2=Integer.parseInt(strr13[kk1][6]);
      	  sp3=1;
      	}
      	
      }
		   	 
		    }
		           
		           
		           
		           if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      
		      
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		        	
			        int len=str1.length();
					int pp=0,flaag=0,flaag1=0;
					int t1=0,m=0;
					char x1;String s3="";
					for(int j=0;j<len;j++)
					{
						
						x1=str1.charAt(j);
						
						if(x1=='a'||x1=='e'||x1=='i'||x1=='o'||x1=='u')
						{
							flaag1=1;
							if(flaag==1)
							{
							  conslex=s3;	
						      s3="";	
						      flaag=0;
							}
							
							s3+=x1;
							
							
						}
						 else
						 {
						 	s3+=x1;
						 	flaag=1;
						 	m++;
						 }
                            
					  }
					        if(flaag1==1)
					        vlex=s3;
					        else
					        conslex=s3;
					        
					        
				   
				   if(conslex!="")	        
				   {
				   	 
                 for(int kk1=0;kk1<x5;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr14[0].equals(conslex))
			      {
			      	strr7=strr14[kk1][1];
					str9+=strr7;
					n22=0;
					break;
			      }
		   	 
		       }
                     
                     
                    //System.out.println(strr14[1][2]+"******shib*"); 
                     
               
              if(n22!=0)
              {
              	     int x12=conslex.length();int x13=0;
              	     //System.out.println(conslex+"..."+x12+"..."+n22);
              	     while(x13<x12)
              	     {
              	     	String cons="";
              	     
              	     char ch11=conslex.charAt(x13);
              	     //System.out.println(ch11);
              	     cons+=ch11;
              	     
			   for(int kk1=0;kk1<x5;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr14[kk1][0].equals(cons))
			      {
			      	strr7=strr14[kk1][1];
					str9+=strr7;
					n22=0;
					break;
			      }
		   	 
		       }
			   
   	          x13++;
              } 	
              }
			  
			           
				   }
				  
		           if(vlex!="")
		           {
			           	           
			           n22=1;
	              for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vlex))
			      {
			      	strr8=strr15[kk1][2];
					str9+=strr8;
					n22=0;
					break;
			      }
		   	 
		       } 
			         
			         if(n22!=0)
                    {
              	     int x13=vlex.length();int x14=0;
              	     //System.out.println(vlex+"..."+x13+"..."+n22);
              	     while(x14<x13)
              	     {
              	     	String vs="";
              	     
              	     char ch12=vlex.charAt(x14);
              	     //System.out.println(ch12);
              	     vs+=ch12;
              	     
			     for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vs))
			      {
			      	strr7=strr15[kk1][2];
					str9+=strr7;
					n22=0;
					break;
			      }
		   	 
		       }
			   
   	          x14++;
              } 	
              }
			         
			         
			           
		           }
		           
		        }
		        
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		          
		           
		               
		           
		               
		        }
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		        
		      
		         
		      
		        		      
		      	
		      	 
		      	 
		      }
		   /*}
		  catch(Exception ee) 
		  {
		  	
		  }*/
		  
		}
		
		
		if(k==p-1 && flaggg!=1)
		{
			try
		   {
			  
			
		      BufferedReader br1 =null;
   FileInputStream fis1 = new FileInputStream(st44);
   br1 = new BufferedReader(new InputStreamReader(fis1,"UTF-8"));
   //System.out.println("Trigram_BL__L starts.............");
   while((line=br1.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[3].equals("") && arr1[4].equals(str3))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  str9=arr1[5];
      	  hits=Integer.parseInt(arr1[6]);
      	  in=1;
      	}
      	
      }
      
   }
			  br1.close();
		      
		      if(in==0)
		      {
		      	hits=0;hits1=0;hits2=0;
		      	 
	try
   {	         
   BufferedReader br2 =null;
   FileInputStream fis2 = new FileInputStream(st44);
   br2 = new BufferedReader(new InputStreamReader(fis2,"UTF-8"));
   //System.out.println("relaxing 1st time............");
   
   
   while((line=br2.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[3].equals(""))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  strr1=arr1[5];
      	  strr2=arr1[6];
      	  hits=Integer.parseInt(strr2);
      	  sp1=1;
      	}
      	
      }
      
      if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[4].equals(str3))
      {
      	if(hits1<Integer.parseInt(arr1[6]))
      	{
      	  strr3=arr1[5];
      	  strr4=arr1[6];
      	  hits1=Integer.parseInt(strr4);;
      	  sp2=1;
      	}
      	
      }
      
      if(arr1[2].equals(str1) && arr1[3].equals(str2) && arr1[4].equals(str3))
      {
      	if(hits2<Integer.parseInt(arr1[6]))
      	{
      	  strr5=arr1[5];
      	  strr6=arr1[6];
      	  hits2=Integer.parseInt(strr6);;
      	  sp3=1;
      	}
      	
      }
      
      
      
   }
			  br2.close();
		     }
		  catch(Exception ee) 
		  {
		  	//System.out.println("not enter..........");
		  } 
		        
		      if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      //System.out.println(sp+".."+sp4+".."+sp5);
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		           hits=0;hits1=0;hits2=0;
		               
		           try
		           {
		           
		           BufferedReader br3 =null;
   FileInputStream fis3 = new FileInputStream(st44);
   br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
   //System.out.println("relaxing 2nd time...........");
   while((line=br3.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[2].equals(str1) && arr1[3].equals(""))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  strr1=arr1[5];
      	  strr2=arr1[6];
      	  hits=Integer.parseInt(arr1[6]);
      	  sp1=1;
      	}
      	
      }
      
      if(arr1[1].equals(str) && arr1[2].equals(str1))
      {
      	if(hits1<Integer.parseInt(arr1[6]))
      	{
      	  strr3=arr1[5];
      	  strr4=arr1[6];
      	  hits1=Integer.parseInt(arr1[6]);
      	  sp2=1;
      	}
      	
      }
      
      if(arr1[2].equals(str1) && arr1[4].equals(str3))
      {
      	if(hits2<Integer.parseInt(arr1[6]))
      	{
      	  strr5=arr1[5];
      	  strr6=arr1[6];
      	  hits2=Integer.parseInt(arr1[6]);
      	  sp3=1;
      	}
      	
      }
      
      
      
   }
		           
			  br3.close();
		           }
		      catch(Exception ee)
		      {
		      	//System.out.println("not shibu");
		      }     
		           
		           
		           if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      
		      
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		        	
			        //System.out.println("relaxing 3rd time...");
			        int len=str1.length();
			        //System.out.println(str1);
					int pp=0,flaag=0,flaag1=0;
					int t1=0,m=0;
					char x1;String s3="";
					for(int j=0;j<len;j++)
					{
                        x1=str1.charAt(j);
						
						if(x1=='a'||x1=='e'||x1=='i'||x1=='o'||x1=='u')
						{
                            flaag1=1;
							if(flaag==1)
							{
							  conslex=s3;	
						      s3="";	
						      flaag=0;
							}
							
							

                             s3+=x1;
							
							
						}
						 else
						 {
						    s3+=x1;
						    flaag=1;
							m++;
						 }
                            
					  }
					        if(flaag1==1)
					        vlex=s3;
					        else
					        conslex=s3;
					        //System.out.println("conslex"+conslex+"...vlex:"+vlex);
					
				   if(conslex!="")	        
				   {
				   	 
                     for(int kk1=0;kk1<x5;kk1++)
		            {
		   	  	  //strrr33=strr14[kk1][5];
			   	  	  if(strr14[kk1][0].equals(conslex))
				      {
				      	strr7=strr14[kk1][1];
						str9+=strr7;
						n22=0;
						break;
				      }
		   	 
		          }
               
              if(n22!=0)
              {
              	     int x12=conslex.length();int x13=0;
              	     //System.out.println(conslex+"..."+x12+"..."+n22);
              	     while(x13<x12)
              	     {
              	     	String cons="";
              	     
              	     char ch11=conslex.charAt(x13);
              	     //System.out.println(ch11);
              	     cons+=ch11;
              	     
			        for(int kk1=0;kk1<x5;kk1++)
		            {
		   	  	  //strrr33=strr14[kk1][5];
			   	  	  if(strr14[kk1][0].equals(cons))
				      {
				      	strr7=strr14[kk1][1];
						str9+=strr7;
						n22=0;
						break;
				      }
		   	 
		          }
			   
   	          x13++;
              } 	
              }
			  
			           
				   }
				   
		           if(vlex!="")
		           {
			           	           
			           //System.out.println(vlex);
			           n22=1;
	
	             for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vlex))
			      {
			      	strr8=strr15[kk1][2];
					str9+=strr8;
					n22=0;
					break;
			      }
		   	 
		       }
			         
			         if(n22!=0)
                    {
              	     int x13=vlex.length();int x14=0;
              	     //System.out.println(vlex+"..."+x13+"..."+n22);
              	     while(x14<x13)
              	     {
              	     	String vs="";
              	     
              	     char ch12=vlex.charAt(x14);
              	     //System.out.println(ch12);
              	     vs+=ch12;
              	     //System.out.println(vs);
              	     
			   for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vs))
			      {
			      	strr7=strr15[kk1][2];
					str9+=strr7;
					n22=0;
					break;
			      }
		   	 
		       }
			   
			   
   	          x14++;
              } 	
              }
			         
			         
			           
		           }
		           
		           
		           
		        }
		        
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		          
		           
		               
		           
		               
		        }
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		        
		      
		         
		      
		        		      
		      	
		      	 
		      	 
		      }
		   }
		  catch(Exception ee) 
		  {
		  	
		  }
		  
		}
		if(k>0 && k<p-1)
		{
			try
		   {
			  
			  //System.out.println("............."+str1); 
		      BufferedReader br1 =null;
   FileInputStream fis1 = new FileInputStream(st44);
   br1 = new BufferedReader(new InputStreamReader(fis1,"UTF-8"));
   //System.out.println("Trigram_BL__L starts.............");
   while((line=br1.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[3].equals(str2) && arr1[4].equals(str3))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  str9=arr1[5];
      	  hits=Integer.parseInt(arr1[6]);
      	  in=1;
      	}
      	
      }
      
   }
			  br1.close();
		      
		      if(in==0)
		      {
		      	hits=0;hits1=0;hits2=0;
		      	 
	try
   {	         
   BufferedReader br =null;
   FileInputStream fis = new FileInputStream(st44);
   br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
   //System.out.println("relaxing 1st time............");
   
   
   while((line=br.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	  //System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[1].equals(str1) && arr1[2].equals(str2) && arr1[3].equals(str3))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  strr1=arr1[5];
      	  strr2=arr1[6];
      	  hits=Integer.parseInt(strr2);
      	  sp1=1;
      	}
      	
      }
      
      if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[4].equals(str3))
      {
      	if(hits1<Integer.parseInt(arr1[6]))
      	{
      	  strr3=arr1[5];
      	  strr4=arr1[6];
      	  hits1=Integer.parseInt(strr4);;
      	  sp2=1;
      	}
      	
      }
      
      if(arr1[1].equals(str) && arr1[2].equals(str1) && arr1[3].equals(str2))
      {
      	if(hits2<Integer.parseInt(arr1[6]))
      	{
      	  strr5=arr1[5];
      	  strr6=arr1[6];
      	  hits2=Integer.parseInt(strr6);;
      	  sp3=1;
      	}
      	
      }
      
      
      
   }
			  br.close();
		     }
		  catch(Exception ee) 
		  {
		  	//System.out.println("not enter..........");
		  } 
		        
		      if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      //System.out.println(sp+".."+sp4+".."+sp5);
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		           hits=0;hits1=0;hits2=0;
		            try
		            {
		               
		           BufferedReader br5 =null;
                  FileInputStream fis5 = new FileInputStream(st44);
		           br5 = new BufferedReader(new InputStreamReader(fis5,"UTF-8"));
   //System.out.println("relaxing 2nd time...........");
   while((line=br5.readLine())!=null)
   {
   	 x11=0;t11="";n22=0;
   	  n11=line.length();
   	 // System.out.println(line);
   	  while(n22<n11)
   	  {
   	  	ch1=line.charAt(n22);
   	  	if(ch1==',')
   	  	{
   	  	   t11=t11.replaceAll("\"","");
   	  	   arr1[x11]=t11;
   	  	   t11="";
   	  	   x11++; 	
   	  	}
   	  	
   	  	else
   	  	t11+=ch1;	
   	  	n22++;
   	  }
   	  t11=t11.replaceAll("\"","");
   	  arr1[x11]=t11;strrr33=arr1[5];
   	  
   	  if(arr1[2].equals(str1) && arr1[3].equals(str2))
      {
      	if(hits<Integer.parseInt(arr1[6]))
      	{
      	  strr1=arr1[5];
      	  strr2=arr1[6];
      	  hits=Integer.parseInt(arr1[6]);
      	  sp1=1;
      	}
      	
      }
      
      if(arr1[1].equals(str) && arr1[2].equals(str1))
      {
      	if(hits1<Integer.parseInt(arr1[6]))
      	{
      	  strr3=arr1[5];
      	  strr4=arr1[6];
      	  hits1=Integer.parseInt(arr1[6]);
      	  sp2=1;
      	}
      	
      }
      
      if(arr1[2].equals(str1) && arr1[4].equals(str3))
      {
      	if(hits2<Integer.parseInt(arr1[6]))
      	{
      	  strr5=arr1[5];
      	  strr6=arr1[6];
      	  hits2=Integer.parseInt(arr1[6]);
      	  sp3=1;
      	}
      	
      }
      
      
      
   }
			  br5.close();
		            }catch(Exception ee)
		            {
		            	//System.out.println("not enteref shiu,,,,,,,,");
		            }
		           
		           
		           if(sp1==1)
		      sp=Integer.parseInt(strr2);
		      
		      if(sp2==1)
		      sp4=Integer.parseInt(strr4);
		      
		      if(sp3==1)
		      sp5=Integer.parseInt(strr6);
		      
		      
		      
		      
		      if(sp>sp4 && sp>sp5)
		      {
		      	str9=strr1;
		      }
		      
		      else if(sp4>sp && sp4>sp5)
		      {
		      	str9=strr3;
		      }
		      
		        else if(sp5>sp && sp5>sp4)
		        str9=strr5;
		        
		        else if(sp1==0 && sp2==0 && sp3==0)
		        {
		        	
			        int len=str1.length();
					int pp=0,flaag=0,flaag1=0;
					int t1=0,m=0;
					char x1;String s3="";
					for(int j=0;j<len;j++)
					{
					   x1=str1.charAt(j);
						
						if(x1=='a'||x1=='e'||x1=='i'||x1=='o'||x1=='u')
						{
							

                            flaag1=1;
							if(flaag==1)
							{
							  conslex=s3;	
						      s3="";	
						      flaag=0;
							}
							
							

                            s3+=x1;
							
							
						}
						 else
						 {
						   s3+=x1;
							flaag=1;
							m++;
						 }
                            
					  }
					        if(flaag1==1)
					        vlex=s3;
					        else
					        conslex=s3;
					        //System.out.println(conslex+"........."+vlex);
					        
				   if(conslex!="")	        
				   {
				   	 
                     for(int kk1=0;kk1<x5;kk1++)
		            {
		   	  	  //strrr33=strr14[kk1][5];
			   	  	  if(strr14[kk1][0].equals(conslex))
				      {
				      	strr7=strr14[kk1][1];
						str9+=strr7;
						n22=0;
						break;
				      }
		   	 
		          }
               
              if(n22!=0)
              {
              	     int x12=conslex.length();int x13=0;
              	     //System.out.println(conslex+"..."+x12+"..."+n22);
              	     while(x13<x12)
              	     {
              	     	String cons="";
              	     
              	     char ch11=conslex.charAt(x13);
              	     //System.out.println(ch11);
              	     cons+=ch11;
              	     
			       for(int kk1=0;kk1<x5;kk1++)
		            {
		   	  	  //strrr33=strr14[kk1][5];
			   	  	  if(strr14[kk1][0].equals(cons))
				      {
				      	strr7=strr14[kk1][1];
						str9+=strr7;
						n22=0;
						break;
				      }
		   	 
		          }
			   
			   
   	          x13++;
              } 	
              }
			  
			           
				   }
				   
		           
		           if(vlex!="")
		           {
			         
			         n22=1;
			     for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vlex))
			      {
			      	strr8=strr15[kk1][2];
					str9+=strr8;
					n22=0;
					break;
			      }
		   	 
		       }
			         
			         
			         if(n22!=0)
                    {
              	     int x13=vlex.length();int x14=0;
              	     //System.out.println(vlex+"..."+x13+"..."+n22);
              	     while(x14<x13)
              	     {
              	     	String vs="";
              	     
              	     char ch12=vlex.charAt(x14);
              	     //System.out.println(ch12);
              	     vs+=ch12;
              	     
			     for(int kk1=0;kk1<x6;kk1++)
		         {
		   	  	  //strrr33=strr14[kk1][5];
		   	  	  if(strr15[kk1][1].equals(vs))
			      {
			      	strr7=strr15[kk1][2];
					str9+=strr7;
					n22=0;
					break;
			      }
		   	 
		       }
			   
			   
   	          x14++;
              } 	
              }
			         
			         
			           
		           }
		           
		           
		        }
		        
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		          
		           
		               
		           
		               
		        }
		          else
		          {
		          	if(sp>sp4)
		          	str9=strr1;
		          	if(sp4>sp5)
		          	str9=strr3;
		          	else
		          	str9=strr5;
		          }
		        
		      
		         
		      
		        		      
		      	
		      	 
		      	 
		      }
		   }
		  catch(Exception ee) 
		  {
		  	
		  } 
		}
		
		//conn.close();
	}
		catch(Exception ee) 
		    {
		        //System.out.println(ee+"eeeeeeeeeeeeeeeeee");	
		    }
		return str9;	
	}
      
}

