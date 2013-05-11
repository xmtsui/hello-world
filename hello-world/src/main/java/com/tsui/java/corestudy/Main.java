package com.tsui.java.corestudy;

class Main {
	public static void main(String[] args)
	{
		char c = 'A';
		c = (char)(65+26-(c-65+1)+1 - 1);
//		c = (char)65+26-(c-65+1)+1 - 1;
		char a = 1;
		if( 65<=c && c<=90)
			System.out.println(c);
		if( 97<=c && c<=122)
			System.out.println(c);
		
		System.out.println(encrypt("abcd34!z"));
		System.out.println(encrypt("Xyz45@#1bXyz45@#1bXyz45@#1bXyz45@#1bXyz45@#1bXyz45@#1b"));
		System.out.println(StrFMTCmp("wertyb", "w*r"));
		System.out.println(StrFMTCmp("dfgibeg", "*?c"));
		System.out.println(StrFMTCmp("hjkjgb", "*?k"));
			
	}
	public static String encrypt(String input)
	{
		char[] ch = input.toCharArray();
		int len = ch.length;
		for(int i=0; i<len; ++i)
		{
			if(ch[i] <= 90 && ch[i] >= 65)
				ch[i]=(char)(65+26-(ch[i]-65+1)+1 - 1);
			else if(ch[i] <= 122 && ch[i] >= 97)
				ch[i]=(char)(97+26-(ch[i]-97+1)+1 - 1);
			else
				continue;
		}
		return new String(ch);
	}
	
	public static int StrFMTCmp(String strCmp, String strMatch)
	{
		char[] ch1 = strCmp.toCharArray();
		char[] ch2 = strMatch.toCharArray();
		int len1 = ch1.length;
		int len2 = ch2.length;
		
		if( len1 < len2)
			return 0;
		
		for(int i=0; i<len1; ++i)
		{
			for(int j=0; j<len2; ++j)
			{
				if(i+j<len1)
				{
					if(ch2[j] != '*' && ch2[j] !='?')
					{
						if(ch1[i+j] == ch2[j])						
						{
							if(j == (len2-1))
								return 1;
							continue;
						}
						else
							break;
					}
				}
			}
		}
		return 0;
	}
	
}
