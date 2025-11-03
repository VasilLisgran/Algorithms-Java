package GaussDeterminant;

import java.util.Arrays;
import java.util.Scanner;

public class GaussDeterminant {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        //Объявление размера матрицы. В методе Гаусса она должна быть квадратной
        //Declaring matrix size. It has to be a square matrix
        int n = in.nextInt();

        //Счётчик нулей в столбце
        //Counting zeroes in the column
        int count = 0;

        //Множитель для опорной строки
        //Multiplier for the pivot row
        double multiplier;

        //Опорный элемент
        //Pivot element
        double support;

        //Определитель
        //Determinant
        double det = 1;


        //Знак определителя
        //Determinant sign
        int detSign = 1;

        //Объявление матрицы (двумерного массива)
        //Declaring a matrix (2-D Array)
        double[][] matrix = new double[n][n];

        //Заполнения матрицы элементами
        //Filling the matrix with elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = in.nextInt();
                matrix[i][j] = element;
            }
        }

        //Проверка, если первый столбец нулевой. По свойству определителя такой определитель ноль
        //Меняем местами первую строку (если первый её элемент 0) и первую найденную строку без первого нуля
        //Checking if the first column is full of 0. This determinant is 0 (property)
        //Swapping first row (if the first element is 0) and the first found row without first 0
        if(matrix[0][0] == 0){
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] !=0){
                    SwapRows(matrix, 0, i);
                    detSign *= (-1);
                    break;
                }
                else {
                    count++;
                }
            }
            if (count == n) {
                System.out.println('0');
            }
        }

        //Начинаем проход по столбцам
        //Going by columns
        for (int j = 0; j < n; j++) {
            //Опорный (pivot) элемент
            //Pivot element
            support = matrix[j][j];

            //Если он ноль, то пропускаем, чтобы не делить на ноль
            //Skip if not 0, so as not to divide by 0
            if (Math.abs(support) < 1e-10) {
                continue;
            }
            //По строкам
            //By rows
            for (int i = j+1; i < n; i++){
                //Множитель для строки, чтобы прибавить i строку и первую и получить нулевой элемент
                //Multiplier for a row to add i-row and first row and get zero element
                multiplier = -(matrix[i][j])/support;

                //Множим все элементы строки
                //Multiply all elements of the row
                for (int k = j; k < n; k++) {
                    matrix[i][k] += multiplier * matrix[j][k];
                }
            }
        }

        //Вычисление определителя перемножением всех элементов диагонали
        //Counting a determinant by multiplying all diagonal elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(i == j){
                    det*=matrix[i][j];
                }
            }
        }

        //Выводим полученный определитель
        //Print the determinant
        System.out.println(Arrays.deepToString(matrix));

        //Если определитель по модулю 0, то выводим 0, чтобы не было проблем с +-0 из-за Double-типа переменной
        //If abs(determinant) is 0 print 0, because double variable has +-0
        if(Math.abs(det*detSign) == 0)
            System.out.println(0);
            //Иначе выводим наш определитель
            //Else print our determinant
        else
            System.out.printf("%.0f", det*detSign);
    }

    //Метод перестановки двух строк
    //Swapping two rows method
    public static void SwapRows(double[][] matrix, int row1, int row2){
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;

    }
}