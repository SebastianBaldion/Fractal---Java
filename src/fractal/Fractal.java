
package fractal;

/**
 *
 * @author Sebastian Baldion
 */
public class Fractal {

    
    public static void main(String[] args) {
        int n = 100;
        int m[][] = new int[n][n];
        int[] rule = {0, 1, 1, 0, 1, 1, 1, 0};

        for (int j = 0; j < n; j++) {
            m[0][j] = Math.random() < 0.5 ? 0 : 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0) {
                    m[i][j] = rule[(m[i - 1][j] * 2) + (m[i - 1][j + 1] * 1)];

                } else {
                    if (j == n - 1) {
                        m[i][j] = rule[(m[i - 1][j - 1] * 4) + (m[i - 1][j] * 2)];
                    } else {
                        m[i][j] = rule[(m[i - 1][j - 1] * 4) + (m[i - 1][j] * 2) + (m[i - 1][j + 1] * 1)];
                        }
                    }
                    System.out.print(m[i][j] + "|");
                }
                System.out.println("");
            }
        }
}