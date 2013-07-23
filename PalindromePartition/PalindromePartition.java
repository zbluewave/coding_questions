/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

import java.util.*;

class PalindromePartition {

	public static void main(String[] args)
	{
		PalindromePartition pp = new PalindromePartition();

		if( args.length > 0 ) {
			List<String> lists = pp.find_palindromes_partitions( args[0] );
			int size = lists.size();
			for( int i = 0; i < size; i++ ) {
				System.out.println( lists.get( i ) );
		    }
		}
		else {
			System.out.println( "Please provide test string" );
		}
	}

	public List<String> find_palindromes_partitions( String string ){
		List<String> partitions = new ArrayList<String>();

		if( string.length() == 1 ) {
			partitions.add( string );
			return partitions;
		}

		for( int i=1; i<=string.length(); i++ ) {
			String sub_string = string.substring( 0, i );
			if( this.is_palindrome( sub_string ) ) {
				//lists.add( string.substring( 0, i ) );
				if( i<string.length() ){
					List<String> sub_partitions = this.find_palindromes_partitions( string.substring( i ) );
					int size = sub_partitions.size();
					for (int j = 0; j < size; j++ ) {
					    partitions.add( sub_string + " , " + sub_partitions.get( j ) );
				    }
				}
				else{
					partitions.add( sub_string );
				}
			}
		}
		return partitions;
	}

	public boolean is_palindrome( String string )
	{
		if( string.length() == 0 ) {
			return false;
		}
		if( string.length() == 1 ) {
			return true ;
		}
		
		char[] chars = string.toCharArray(); 
		int length   = chars.length;

		for(int i=0;i<length/2;i++){
			if( chars[i] != chars[length-i-1] ){
				return false;
			}
		} 

		return true;
	}
}