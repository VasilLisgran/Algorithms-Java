import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class Naiarana {
    public static Scanner in  = new Scanner(System.in);

    public static void main(String[] args) {

        //Ввод числа элементов массива
        int n = in.nextInt();



        int factorial = 1;

        int count = 0;

        //Создаём массив
        int[] elements = new int[n];

        //Заполняем массив элементами от 1 до n
        for (int i = 0; i < n; i++) {
            elements[i] = i+1;
        }

        System.out.println(Arrays.toString(elements));

        for (int k = 1; k <= n; k++) {
            factorial*=k;
        }

        for (int r = 0; r < factorial; r++) {

            //Индексы, которые обращаются к элементам для сравнения алгоритмом Найараны
            int indexI = -1;
            for (int i = n-2; i >= 0; i--) {
                if(elements[i] < elements[i+1]){
                    indexI = i;
                    break;
                }
            }

            if (indexI == -1)
                break;

            int indexJ = 0;
            for(int j = n-1; j > indexI; j--){
                if(elements[j] > elements[indexI]){
                    indexJ = j;
                    break;
                }
            }

            int temp = elements[indexI];
            elements[indexI] = elements[indexJ];
            elements[indexJ] = temp;

            reverse(elements, indexI+1, n-1);

            count++;
            System.out.println(Arrays.toString(elements));
        }
    }

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
