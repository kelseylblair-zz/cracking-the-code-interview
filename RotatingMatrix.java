// cracking the coding interview, problem 1.6

import java.awt.Color;

public class RotatingMatrix{

    Pixel[][] matrix;

    //create a new square matrix and load each index with random pixels
    public RotatingMatrix(int size) {
        matrix = new Pixel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Pixel();
            }
        }
    }

    //create a new square matrix and load each index with the specified pixel elements
    public RotatingMatrix(int size, byte[][] reds, byte[][] greens, byte[][] blues, byte[][] alphas) {
        Pixel[][] matrix = new Pixel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Pixel(reds[i][j], greens[i][j], blues[i][j], alphas[i][j]);
            }
        }
    }

    //rotate the matrix 90 degrees counterclockwise
    public void rotate90CCW() {

        Pixel temp = new Pixel();
        int start = 0;
        int end = matrix.length - 1;


        //until the counters converge, keep swapping all of the elements at index i
        //in a circular fashion, working from the outer row inwards
        while (start < end) {
            for (int i = 0; i < end - start; i++) {
                temp = matrix[start][start + i];
                matrix[start][start + i] = matrix[start + i][end];
                matrix[start + i][end] = matrix[end][end - i];
                matrix[end][end - i] = matrix[end - i][start];
                matrix[end - i][start] = temp;
            }
            //update the counters to move in to the next circle of rows/cols

            start++;
            end--; //assumes a square
        }
    }

    public Pixel pixelAt(int a, int b) {
        return matrix[a][b]; 
    }

    //create a private pixel class defined by four ints corresponding to color
    private static class Pixel {

        int red, green, blue, alpha;

        //construct a random pixel
        public Pixel() {
            red = (int) (Math.random() * 256);
            green = (int) (Math.random() * 256);
            blue = (int) (Math.random() * 256);
            alpha = 255;
        }

        //construct a pixel using given int values for each color
        public Pixel(int red, int green, int blue, int alpha) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = alpha;
        }

        public Color toColor() {
            return new Color(red, green, blue, alpha);
        }

    }

    public static void main(String args[]) {
        System.out.println("Testing the NxN matrix rotation algorithm...");

        RotatingMatrix tester = new RotatingMatrix(10);  

        //StdDraw
        System.out.println("Drawing the original matrix...");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                StdDraw.setPenColor(tester.pixelAt(i, j).toColor());
                StdDraw.filledSquare((float)i/10+ .05, (float)j/10 + .05, .05);
            }
        }

        tester.rotate90CCW();

        System.out.println("Ready to rotate?");
        StdIn.readString();

        //StdDraw
        System.out.println("Drawing the rotated matrix...");
        StdDraw.clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                StdDraw.setPenColor(tester.pixelAt(i, j).toColor());
                StdDraw.filledSquare((float)i/10+ .05, (float)j/10 + .05, .05);
            }
        }   

    }
}