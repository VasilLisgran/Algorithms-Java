import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class Naiarana {
    public static Scanner in  = new Scanner(System.in);

    public static void main(String[] args) {

        // Инициализация переменных / Initialize variables
        int n = in.nextInt(); // Ввод числа элементов массива / Input numbers of elements for permutation
        int factorial = 1;
        int count = 0;

        int[] elements = new int[n]; // Создаём массив / Creating an array

        // Заполняем массив элементами от 1 до n / Filling an array by elements from 1 to n
        for (int i = 0; i < n; i++) {
            elements[i] = i+1;
        }

        System.out.println(Arrays.toString(elements)); // Вывод первой перестановки / Print the first permutation

        // Вычисление факториала / Counting a factorial
        for (int k = 1; k <= n; k++) {
            factorial*=k;
        }

        // Генерация всех n! перестановок / Generating all n! permutations
        for (int r = 0; r < factorial; r++) {
            // По умолчанию индекс i = -1 (значение вне массива) / By default index i = -1 (value out of array)
            int indexI = -1;
            // Шаг 1: Поиск наибольшего индекса i, где elements[i] < elements[i+1]
            // Step 1: Find the largest index i where elements[i] < elements[i+1]
            for (int i = n-2; i >= 0; i--) {
                if(elements[i] < elements[i+1]){
                    indexI = i;
                    break;
                }
            }

            // Если индекс не найден - все перестановки сгенерированы / If index not found - all permutations have been generated
            if (indexI == -1)
                break;

            // Шаг 2: Поиск наибольшего индекса j > i, где elements[j] > elements[i]
            // Step 2: Find the largest index j > i where elements[j] > elements[i]
            int indexJ = 0;
            for(int j = n-1; j > indexI; j--){
                if(elements[j] > elements[indexI]){
                    indexJ = j;
                    break;
                }
            }

            // Шаг 3: Обмен элементов i и j / Step 3: Swap elements i and j
            int temp = elements[indexI];
            elements[indexI] = elements[indexJ];
            elements[indexJ] = temp;

            // Шаг 4: Реверс последовательности после позиции i / Step 4: Reverse sequence after position i
            reverse(elements, indexI+1, n-1);

            count++;
            System.out.println(Arrays.toString(elements));
        }
    }

    /**
     * Reverses elements in array between start and end indices
     * Переворачивает элементы массива между start и end индексами
     *
     * @param arr the array to reverse / массив для переворота
     * @param start starting index / начальный индекс
     * @param end ending index / конечный индекс
     */

    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
