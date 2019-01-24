package com.rms.subex;

public class DecimalToFloat
{

	public static void main( String[] args )
	{
		 int n;
		    int i;
		    float d=0;
		    float m=0;
		    float y=( float ) 8.5;
		    try
		    {
		    	Float.parseFloat( "75.999999999" );
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Please enter valid float number");
		    }
		    System.out.println("enter any number:");
		    n=( int ) y;
		    y=y-n;
		    for(i=15;i>=0;i--)
		    System.out.print((n>>i)&1);
		    System.out.print(".");
		    for(i=1;i<=10;i++)
		    {
		     d=( float ) ( d+Math.pow( 2, -i ) );
		     if(d>y)
		     {
		      d=m;
		      System.out.print("0");
		     }
		     else
		     {
		      m=d;
		      System.out.print("1");
		     }
		     
		    }
		    
//		    StringBuilder s;
//		    s.in
//		    String str="000001112323.111";
//		     System.out.println("\n"+str.substring( str.indexOf('1' ) ));
//		 

	}

}
