package rsa;

import java.math.BigInteger;
import java.util.Scanner;

public class rsa {
	public static void main(String args[]){
		Scanner scr=new Scanner(System.in);
		System.out.println("½Ð¿é¤J¤å¦r");
		String x=scr.nextLine();
		System.out.println("p=");
		BigInteger p=scr.nextBigInteger();		
		System.out.println("q=");
		BigInteger q=scr.nextBigInteger();		
		System.out.println("e=");
		BigInteger e=scr.nextBigInteger();		
		BigInteger n=p.multiply(q);
		BigInteger N=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		BigInteger d=e.modInverse(N);
		System.out.println("p="+p);
		System.out.println("q="+q);
		System.out.println("e="+e);
		System.out.println("n="+n);
		System.out.println("d="+d);
		System.out.println("plain text="+x);	
		System.out.print("M=");
		int l,k=0;
		if(x.length()%2==0)
			l=x.length()/2;
		else
			l=(x.length()/2+1);
		String a[]=new String[l];
		if(x.length()%2==0)
		{			
			for(int i=0;i<x.length()-1;i+=2)
			{
				if(x.charAt(i)==' '&&x.charAt(i+1)!=' '){
					a[k]="26"+(x.charAt(i+1)-'A');	
				if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'==0)	
					a[k]="26"; //EX:A BBBB
				else if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'!=0)
					a[k]=x.charAt(i)-'A'+"26"; //EX:A BBBB
				if(x.charAt(i+1)-'A'==0)	
					a[k]+="0"; 			
				System.out.print(" "+a[k]);
				k++;
				}
				else 
				{
					if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i+1)-'A'<10&&x.charAt(i+1)-'A'>0)
						a[k]=(x.charAt(i)-'A')+"0"+(x.charAt(i+1)-'A');
					else if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i)-65!=0)
						a[k]=(x.charAt(i)-'A')+""+(x.charAt(i+1)-'A');
					else if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i)-'A'==0)
						a[k]=(x.charAt(i+1)-'A')+"";
					if(x.charAt(i+1)-'A'==0)
						a[k]+="0";
					if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'==0)	
						a[k]="26"; //EX:A BBBB
					else if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-65!=0)
						a[k]=x.charAt(i)-'A'+"26"; //EX:A BBBB
					System.out.print(" "+a[k]);
					k++;
				}			
			}
		}
		else
		{ 
			k=0;
			for(int i=0;i<x.length()-1;i+=2)
			{
				if(x.charAt(i)==' '&&x.charAt(i+1)!=' '){
					a[k]="26"+(x.charAt(i+1)-'A');	
				if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'==0)	
					a[k]="26"; //EX:A BBBB
				else if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'!=0)
					a[k]=x.charAt(i)-'A'+"26"; //EX:A BBBB
				if(x.charAt(i+1)-'A'==0)	
					a[k]+="0"; 			
				System.out.print(" "+a[k]);
				k++;
				}
				else 
				{
					if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i+1)-'A'<10&&x.charAt(i+1)-'A'>0)
						a[k]=(x.charAt(i)-'A')+"0"+(x.charAt(i+1)-'A');
					else if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i)-65!=0)
						a[k]=(x.charAt(i)-'A')+""+(x.charAt(i+1)-'A');
					else if(x.charAt(i)!=' '&&x.charAt(i+1)!=' '&&x.charAt(i)-'A'==0)
						a[k]=(x.charAt(i+1)-'A')+"";
					if(x.charAt(i+1)-'A'==0)
						a[k]+="0";
					if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-'A'==0)	
						a[k]="26"; //EX:A BBBB
					else if(x.charAt(i)!=' '&&x.charAt(i+1)==' '&&x.charAt(i)-65!=0)
						a[k]=x.charAt(i)-'A'+"26"; //EX:A BBBB
					System.out.print(" "+a[k]);
					k++;
				}			
			}
			a[k]=x.charAt(x.length()-1)-'A'+"26";
			System.out.print(" "+a[k]);
		}
		System.out.println();
		String C="";
		C=new BigInteger(a[0]+"").modPow(e,n)+"";
		System.out.println("C= "+C);
		for(int i=1;i<a.length;i++)
		{
			C=C+" "+new BigInteger(a[i]+"").modPow(e,n);
			System.out.println("\n"+new BigInteger(a[i]).modPow(e,n));
		}
		
		String[] c=C.split(" ");
		String ad="";
		ad=new BigInteger(c[0]+"").modPow(d,n)+"";
		for(int i=1;i<c.length;i++)
		{
			ad=ad+" "+new BigInteger(c[i]+"").modPow(d,n);
		}
		System.out.println("After decoding: "+ad);	
	}
}
