/*

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/

import java.util.*;

class SurrendedRegions {
	public static void main(String[] args){
		char[][] board = { 
			{'X','X','X','X'}, 
			{'X','O','O','X'},
			{'X','O','X','X'}, 
			{'X','X','X','O'}
		};

		SurrendedRegions sr = new SurrendedRegions();
		sr.solve(board);
	}

	public void solve(char[][] board) {
		Set<Node> white_block = new HashSet<Node>();
		for(int i=0; i<board.length; i++) {
			if( i==0 || i==board.length-1 ){
				for(int j=0; j<board[i].length; j++) {
					if( board[i][j] == 'O' ) {

					} 
				}
			}
			else{

			}
		}
    }
}

class Board {
	char[][] board;
	public Board( char[][] board ){
		this.board = board;
	}
}

class Node {
	int x;
	int y;

	public Node( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public boolean equals( Node n ){
		if( n.x == this.x && n.y == this.y ){
			return true;
		}
		else{
			return false;
		}
	}
}