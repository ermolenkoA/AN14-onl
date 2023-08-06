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
        int result = 0;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {

                if(matrix[i][j] == 1) {
                    ++result;
                    int maxSize = Math.min(matrix[i].length - j, matrix.length - i);

                    //Пока возможен квадрат большего размера
                    for (int counter = 1; counter < maxSize; ++counter, ++result){

                        //Проверяем соседние элементы снизу и справа
                        for(int k = 0; k < counter; ++k){
                            if (matrix[i + counter][j+k] != 1 || matrix[i+k][j + counter] != 1) {
                                counter = 0;
                                break;
                            }
                        }

                        //Если в соседняя или диоганальная клетка равна 0 - останавливаем цикл
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