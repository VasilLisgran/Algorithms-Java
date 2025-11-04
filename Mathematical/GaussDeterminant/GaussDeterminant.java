package GaussDeterminant;

import java.util.Arrays;
import java.util.Scanner;

public class GaussDeterminant {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        // Объявление размера матрицы. В методе Гаусса матрица должна быть квадратной
        // Declaring matrix size. It has to be a square matrix
        int n = in.nextInt();


        // Инициализация переменных / Initialize variables
        int count = 0;        // Счётчик нулей в столбце / Counting zeroes in the column
        double multiplier;    // Множитель для опорной строки / Multiplier for the pivot row
        double support;       // Опорный элемент / Pivot element
        double det = 1;       // Определитель / Determinant
        int detSign = 1;      // Знак определителя / Determinant sign


        double[][] matrix = new double[n][n]; //Объявление матрицы / Declaring a matrix (2-D Array)

        //Заполнения матрицы элементами / Filling the matrix with elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = in.nextInt();
                matrix[i][j] = element;
            }
        }

        /**
         * Меняем местами первую строку (если первый её элемент 0) и первую найденную строку без первого нуля
         *  Если первый столбец нулевой. По свойству определителя такой определитель ноль
         *  Swapping first row (if the first element is 0) and the first found row without first 0
         *  If the first column is full of 0. This determinant is 0 (property)
         */

        if(matrix[0][0] == 0){
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] !=0){
                    SwapRows(matrix, 0, i);
                    // Меняем знак определителя при перестановке / Changing the sign of the determinant
                    detSign *= (-1);
                    break;
                }
                else {
                    count++;
                }
            }
            if (count == n) {
                System.out.println(0);
            }
        }

        // Начинаем проход по столбцам / Going by columns
        for (int j = 0; j < n; j++) {

            // Опорный (pivot) элемент / Pivot element
            support = matrix[j][j];

            // Если он ноль, то пропускаем, чтобы не делить на ноль / Skip if not 0, to avoid division by 0
            if (Math.abs(support) < 1e-10) {
                continue;
            }

            // По строкам / By rows
            for (int i = j+1; i < n; i++){

                // Множитель для строки i / Multiplier for a row i
                multiplier = -(matrix[i][j])/support;

                // Прибавляем к строке i опорную строку j, умноженную на множитель / Add to row i the pivot row j multiplied by multiplier
                for (int k = j; k < n; k++) {
                    matrix[i][k] += multiplier * matrix[j][k];
                }
            }
        }

        // Вычисление определителя перемножением всех элементов диагонали / Counting a determinant by multiplying all diagonal elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(i == j){
                    det*=matrix[i][j];
                }
            }
        }

        // Выводим полученный определитель / Print the determinant
        System.out.println(Arrays.deepToString(matrix));

        //Если определитель по модулю 0, то выводим 0, чтобы не было проблем с +-0 из-за Double-типа переменной
        //If abs(determinant) is 0 print 0, because double variable has +-0
        if(Math.abs(det*detSign) == 0)
            System.out.println(0);
            //Иначе выводим наш определитель / Else print our determinant
        else
            System.out.printf("%.0f", det*detSign);
    }

    //Метод перестановки двух строк / Swapping two rows method
    public static void SwapRows(double[][] matrix, int row1, int row2){
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;

    }
}
