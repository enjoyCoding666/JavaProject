package com.example.collection;

public class ArrayTest {
	public static void main(String args[])
	  {int i,j;
	   int intArray[]={20,1,-3,30,50};
	   int len=intArray.length;      //��ȡ���鳤��
	   for(i=1;i< len;i++)                //ð�ݷ�����������³�
	     for(j=0;j<=len-i-1;j++)
	       if(intArray[j]>intArray[j+1])
	         {int t=intArray[j];
	          intArray[j]=intArray[j+1];
	          intArray[j+1]=t;
	         }
	   for(i=0;i< len;i++)
	     System.out.println(intArray[i]+" ");
	  }
}
