package ProblemOfSquares;
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1, 1},
            {1, 0, 1, 1},
            {1, 0, 1, 1},
            {1, 0, 1, 1},
            {1, 0, 1, 1}
        };
        System.out.println("Количество квадратов: " + countSquare(matrix));
    }

    public static Integer countSquare(int[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int result = 0;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                int counter = 0;

                if(matrix[i][j] == 1) {
                    while (true) {
                        ++result;
                        ++counter;

                        if(j + counter >= matrix[i].length || i + counter >= matrix.length){
                            break;
                        }

                        for(int k = 0; k < counter; ++k){
                            if (matrix[i + counter][j+k] != 1 || matrix[i+k][j + counter] != 1) {
                                counter = 0;
                                break;
                            }
                        }

                        if (counter == 0 || matrix[i + counter][j + counter] != 1){
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}