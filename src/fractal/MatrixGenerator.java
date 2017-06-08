
package fractal;

/**
 *
 * @author Sebastian Baldion
 */
public class MatrixGenerator {
    public MatrixGenerator(){}

	public int[][] generate(int length)
	{
		int[][] matrix = new int[length][length];

		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < length; j++)
			{
				matrix[i][j] = Math.random() < 0.5 ? 0 : 1;
			}
		}
		return matrix;
	}
}

