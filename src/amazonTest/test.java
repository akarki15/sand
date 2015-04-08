package amazonTest;

import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;


public class test {
	
	public static void main(String [] args){
//		System.out.println(palindrome1("forgeeksskeegfor"));
////		System.out.println(countZeros(new int []{1, 0, 0, 0, 0}));
//		char [][]grid= new char[][]{{'T','T','P','T'},{'P','P','T','T'},
//				{'T','P','P','P'},{'P','T','P','T'},{'P','P','T','P'},
//				{'P','P','T','P'},{'P','T','T','T'}};
//		findMaxWishes(grid);
		
		printList(insertion(randomList(5000)));
	}
	static int[] randomList(int n){
		int [] l = new int[n];
		for (int i=0;i<n;i++){
			Random r= new Random();
			l[i]= r.nextInt(500);
		}
		
		return l;
	}
	static void printList(int[] l){
		for (int i: l){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	static int findMaxWishes(char[][]grid){
		return 2;
	}
	
	static int [] insertion(int [] l){
		for (int i=0;i<l.length;i++){
			for (int j=i-1;j>=0;j--){
				if (l[j]>l[j+1])
					l=swap(l,j,j+1);
			}
		}
		return l;
	}
	static int [] swap(int [] l,int a, int b){
		int temp = l[a];
		l[a]=l[b];
		l[b]=temp;
		return l;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//--------------------
	static String palindrome1(String s){		
		int len = s.length();		
		if (len==1 || len==0)
			return s;		
		int i=0;
		for (;i<(len/2);i++){
			if (s.charAt(i)!=s.charAt(len-1-i))
				break;				
		}		
		if (i==(int)len/2){
			return s;
		}else {
			String s1= palindrome1(s.substring(0, len-i-1)); // no -1 since end index is non inclusives
			String s2= palindrome1(s.substring(i+1, len));
			return (s1.length()>=s2.length()? s1:s2);
		}	
	}
	
//	Given an array of 1s and 0s which has all 1s first followed by all 0s. Find the number of 0s. Count the number of zeroes in the given array.
//
//	Examples:
//
//	Input: arr[] = {1, 1, 1, 1, 0, 0}
//	Output: 2
//
//	Input: arr[] = {1, 0, 0, 0, 0}
//	Output: 4
//
//	Input: arr[] = {0, 0, 0}
//	Output: 3
//0,0,1,1,1
//	Input: arr[] = {1, 1, 1, 1}
//	Output: 0
	
	static int countZeros(int[] array){
		for (int a : array){
			System.out.print (a+" ,");
		}
		System.out.println();
		int len = array.length;
		// Edge cases
		if (len==0)
			return 0;
		if (len==1)
			return (array[0]==0? 1:0);
		// recursive part
		if (array[(int)len/2]==1){			
			return countZeros(parseArray(array, (int)len/2+1, len-1));
		}else { // it is a 0
			System.out.println(array[(int)len/2]+" "+(int)len/2);
			return (countZeros(parseArray(array, 0, (int)len/2-1)) +1+(int)len/2);
		}
	}
	
	static int[] parseArray(int[]a, int i, int j){	
		int [] b=new int[j-i+1];
		int k=0;
		while(i!=j){				
				b[k++]=a[i];
				i++;
		}
		return b;
	}
	
}
