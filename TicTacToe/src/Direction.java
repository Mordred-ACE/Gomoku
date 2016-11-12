
public class Direction {
	public int[] coordinates= new int[2];
	public int direction;

	public Direction(int d){
		direction = d;
	}
	public int[] change(int xtile, int ytile){
		switch (direction){
			case 0:
				xtile -= 1;
				ytile -= 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
				
			case 1:
				xtile += 0;
				ytile -= 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 2:
				xtile += 1;
				ytile -= 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 3:
				xtile -= 1;
				ytile += 0;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 4:
				xtile += 1;
				ytile += 0;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 5:
				xtile -= 1;
				ytile += 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 6:
				xtile += 0;
				ytile += 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			case 7:
				xtile += 1;
				ytile += 1;
				coordinates[0] = xtile;
				coordinates[1] = ytile;
				return coordinates;
			

		}
		coordinates[0] = xtile;
		coordinates[1] = ytile;
		return coordinates;
		
	}		
}