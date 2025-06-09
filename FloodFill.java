import java.util.Scanner;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        
        dfs(image, sr, sc, originalColor, color);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }
        
        if (image[r][c] != originalColor) {
            return;
        }
        
        image[r][c] = newColor;
        
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main sol = new Main();
        
        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();
        
        int[][] image = new int[m][n];
        
        System.out.println("Enter the image pixels row by row:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter starting row (sr): ");
        int sr = scanner.nextInt();
        System.out.print("Enter starting column (sc): ");
        int sc = scanner.nextInt();
        System.out.print("Enter new color: ");
        int color = scanner.nextInt();
        
        int[][] result = sol.floodFill(image, sr, sc, color);
        
        System.out.println("Resulting image after flood fill:");
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}