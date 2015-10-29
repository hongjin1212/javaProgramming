package setToZero;

public class SetToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("Please input the number of rows and columns of a matrix");
		}
		int rows = Integer.parseInt(args[0]);
		int cols = Integer.parseInt(args[1]);
		int[][] matrix = new int[rows][cols];
		for(int i = 0; i  < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix[i][j] = (int)(Math.random() * 3);
				System.out.println(matrix[i][j]);
			}
		}
		printMatrix(matrix);
		setZeros(matrix);
		printMatrix(matrix);
		
	}
	
	private static void setZeros(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[] r = new boolean[rows];
		boolean[] c = new boolean[cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 0) {
					r[i] = true;
					c[j] = true;
				}
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(r[i] == true || c[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
		
		
	}
	
	private static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
