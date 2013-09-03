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
			{'X','X','X','X','X'}, 
			{'O','O','O','X','X'},
			{'X','O','X','O','X'}, 
			{'X','X','X','X','X'}
		};

		SurrendedRegions sr = new SurrendedRegions();
		sr.solve(board);
	}

	public void solve(char[][] board) {
		Iterator<Area> it;
		Area area;
		Boolean find_match;
		ArrayList<Area> areas = new ArrayList<Area>();
		for(int i=0; i<board.length; i++) {
			for(int j=0;j<board[i].length;j++){
				if( board[i][j] == 'O' ) {
					find_match = false;
				    it = areas.iterator();
					while(it.hasNext()){
					    area = it.next();
					    if(area.isAdjacent(i,j)){
					    	area.addNode(i,j);
					    	find_match = true;
							if(i==0||i==board.length-1||j==0||j==board[i].length-1){
								area.setNearBorder(true);
							}
					    	break;
					    }
					}

					if( !find_match ){
						area = new Area();
						area.addNode(i,j);
						areas.add(area);
						if(i==0||i==board.length-1||j==0||j==board[i].length-1){
							area.setNearBorder(true);
						}
					}
				}
			}
		}


		it = areas.iterator();
		while(it.hasNext()){
			area = it.next();
			if( !area.isNearBorder() ){
				ArrayList<Node> nodes = area.getNodes();
				Iterator<Node> itn = nodes.iterator();
				while(itn.hasNext())
				{
				    Node node = itn.next();
				    board[node.x][node.y] = 'X';
				}
			}
		}

		for(int i=0; i<board.length; i++) {

			String line = "";

			for(int j=0;j<board[i].length;j++){
				line += " " + board[i][j];
			}

			System.out.println(line);
		}
		
    }
}

class Area {
	private ArrayList<Node> nodes;
	private Boolean isNearBorder;
	public Area(){
		this.nodes = new ArrayList<Node>();
		this.isNearBorder = false;
	}

	public Boolean isAdjacent(int x,int y){
	    if(nodes.size()>0){
	    	Iterator<Node> it = this.nodes.iterator();
			while(it.hasNext())
			{
			    Node node = it.next();
			    if(node.isAdjacent(x,y)){
			    	return true;
			    }
			}
	    }
	    return false;
	}

	public void addNode(int x,int y){
		this.nodes.add( new Node(x,y) );
	}

	public ArrayList<Node> getNodes(){
		return this.nodes;
	}

	public int getSize(){
		return this.nodes.size();
	}

	public void setNearBorder( Boolean isNearBorder ){
		this.isNearBorder = isNearBorder;
	}

	public Boolean isNearBorder(){
		return this.isNearBorder;
	}

	public void print(){
	    if(nodes.size()>0){
	    	System.out.println( "area begins" );

	    	Iterator<Node> it = this.nodes.iterator();
			while(it.hasNext())
			{
			    Node node = it.next();

			    System.out.println( node.x + "             "+ node.y );
			}

			System.out.println( "area ends" );
	    }
	}
}

class Node {
	public int x;
	public int y;

	public Node( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public Boolean isAdjacent(int x,int y){
		if(Math.abs(this.x-x)==1&&y==this.y){
			return true;
		}
		else if(Math.abs(this.y-y)==1&&x==this.x){
			return true;
		}
		else{
			return false;
		}
	}
}