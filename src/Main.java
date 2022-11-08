import java.util.Arrays;
import java.util.StringJoiner;

public class Main {

  public static void main(String[] args) {
    testNullMatrix();
    testEmptyMatrix();
    test1x1Matrix();
    test3x4Matrix();
    test4x3Matrix();
    test4x4Matrix();
  }

  public static String clockwiseMatrix(int[][] input) {
    if (input == null) {
      return "";
    }
    
    if(input.length == 1 && input[0].length == 1) {
       return String.valueOf(input[0][0]);
    }
    
    StringJoiner output = new StringJoiner(", ");
    int startRow = 0;
    int endRow = input.length - 1;
    int startColumn = 0;
    int endColumn = input[0].length - 1;
    
    while (startRow <= endRow && startColumn <= endColumn) {
      for (int column = startColumn; column < endColumn; column++) {
        output.add(String.valueOf(input[startRow][column]));
      }
      for (int row = startRow; row < endRow; row++) {
        output.add(String.valueOf(input[row][endColumn]));
      }
      for (int column = endColumn; column > startColumn; column--) {
        output.add(String.valueOf(input[endRow][column]));
      }
      for (int row = endRow; row > startRow; row--) {
        output.add(String.valueOf(input[row][startColumn]));
      }
      startRow++;
      endRow--;
      startColumn++;
      endColumn--;
    }
    return output.toString();
  }

  public static void testNullMatrix() {
    int[][] input = null;
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }
  
  public static void testEmptyMatrix() {
    int[][] input = new int[3][4];
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }

  public static void test1x1Matrix() {
    int[][] input = {{1}};
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }

  public static void test3x4Matrix() {
    int[][] input = {
        {2, 3, 4, 8}, 
        {5, 7, 9, 12}, 
        {1, 0, 6, 10}};
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }

  public static void test4x3Matrix() {
    int[][] input = {
        {2, 3, 4},
        {5, 7, 9},
        {1, 0, 6},
        {8, 10, 11}};
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }

  public static void test4x4Matrix() {
    int[][] input = {
        {2, 3, 4, 8},
        {5, 7, 9, 12},
        {1, 0, 6, 10},
        {11, 13, 14, 15}};
    String output = clockwiseMatrix(input);
    printTest(input, output);
  }
  
  public static void printTest(int[][] input, String output) {
    System.out.println("Input");
    if (input != null) {
      Arrays.stream(input).map(Arrays::toString).forEach(System.out::println);
    }
    System.out.println("Output:" + output);
  }
}
