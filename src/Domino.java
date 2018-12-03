package application;

import java.util.ArrayList;
import java.util.HashMap;



public class Domino {
	private int id;
	private int leftLandId;
	private int rightLandId;
	private int[] nbCrowns = new int[2]; // nbCrowns[0] = 0,1,2,3 (nb of crowns) and nbCrowns[1] = 0,1  (0 for the crowns in the left and 1 for the crown in the right)
	private ArrayList<Point> coord;
	
	HashMap<Integer,String> mapping = new HashMap<Integer,String>() {
		{
			put(0,"champs");
			put(1,"forêt");
			put(2,"mer");
			put(3,"prairie");
			put(4,"mine");
			put(5,"montagne");
		}
	};
	
	
	
	public Domino(int id) {
		switch (id) {
			case 1:
				leftLandId = 0;
				rightLandId = 0;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 2:
				leftLandId = 0;
				rightLandId = 0;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 3:
				leftLandId = 1;
				rightLandId = 1;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 4:
				leftLandId = 1;
				rightLandId = 1;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 5:
				leftLandId = 1;
				rightLandId = 1;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 6:
				leftLandId = 1;
				rightLandId = 1;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 7:
				leftLandId = 2;
				rightLandId = 2;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 8:
				leftLandId = 2;
				rightLandId = 2;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 9:
				leftLandId = 2;
				rightLandId = 2;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 10:
				leftLandId = 3;
				rightLandId = 3;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 11:
				leftLandId = 3;
				rightLandId = 3;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 12:
				leftLandId = 4;
				rightLandId = 4;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 13:
				leftLandId = 0;
				rightLandId = 1;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 14:
				leftLandId = 0;
				rightLandId = 2;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 15:
				leftLandId = 0;
				rightLandId = 3;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 16:
				leftLandId = 0;
				rightLandId = 4;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 17:
				leftLandId = 1;
				rightLandId = 2;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 18:
				leftLandId = 1;
				rightLandId = 3;
				nbCrowns[0] = 0;
				nbCrowns[1] = 0;
				break;
			case 19:
				leftLandId = 0;
				rightLandId = 1;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 20:
				leftLandId = 0;
				rightLandId = 2;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 21:
				leftLandId = 0;
				rightLandId = 3;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 22:
				leftLandId = 0;
				rightLandId = 4;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 23:
				leftLandId = 0;
				rightLandId = 5;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 24:
				leftLandId = 1;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 25:
				leftLandId = 1;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 26:
				leftLandId = 1;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 27:
				leftLandId = 1;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 28:
				leftLandId = 1;
				rightLandId = 2;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 29:
				leftLandId = 1;
				rightLandId = 3;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 30:
				leftLandId = 2;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 31:
				leftLandId = 2;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 32:
				leftLandId = 2;
				rightLandId = 1;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 33:
				leftLandId = 2;
				rightLandId = 1;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 34:
				leftLandId = 2;
				rightLandId = 1;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 35:
				leftLandId = 2;
				rightLandId = 1;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 36:
				leftLandId = 0;
				rightLandId = 3;
				nbCrowns[0] = 1;
				nbCrowns[1] = 1;
				break;
			case 37:
				leftLandId = 2;
				rightLandId = 3;
				nbCrowns[0] = 1;
				nbCrowns[1] = 1;
				break;
			case 38:
				leftLandId = 0;
				rightLandId = 4;
				nbCrowns[0] = 1;
				nbCrowns[1] = 1;
				break;
			case 39:
				leftLandId = 3;
				rightLandId = 4;
				nbCrowns[0] = 1;
				nbCrowns[1] = 1;
				break;
			case 40:
				leftLandId = 5;
				rightLandId = 0;
				nbCrowns[0] = 1;
				nbCrowns[1] = 0;
				break;
			case 41:
				leftLandId = 0;
				rightLandId = 3;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 42:
				leftLandId = 2;
				rightLandId = 3;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 43:
				leftLandId = 0;
				rightLandId = 4;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 44:
				leftLandId = 3;
				rightLandId = 4;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 45:
				leftLandId = 5;
				rightLandId = 0;
				nbCrowns[0] = 2;
				nbCrowns[1] = 0;
				break;
			case 46:
				leftLandId = 4;
				rightLandId = 5;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 47:
				leftLandId = 4;
				rightLandId = 5;
				nbCrowns[0] = 2;
				nbCrowns[1] = 1;
				break;
			case 48:
				leftLandId = 0;
				rightLandId = 5;
				nbCrowns[0] = 3;
				nbCrowns[1] = 1;
				
				
		}
	}
	
}
