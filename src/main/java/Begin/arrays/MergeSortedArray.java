package Begin.arrays;

import java.util.Arrays;


/**
 * Вам даны два целочисленных массива nums1 и nums2, отсортированные в порядке неубывания,
 * и два целых числа m и n, представляющие количество элементов в nums1 и nums2 соответственно.
 *
 * Объедините nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
 *
 * Окончательно отсортированный массив не должен возвращаться функцией, а должен храниться внутри массива nums1.
 * Чтобы учесть это, nums1 имеет длину m + n, где первые m элементов обозначают элементы, которые следует объединить,
 * а последние n элементов имеют значение 0 и их следует игнорировать. nums2 имеет длину n.
 *
 *
 * Пример 1:
 *
 * Ввод: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Выход: [1,2,2,3,5,6]
 * Пояснение: Мы объединяем массивы [1,2,3] и [2,5,6].
 * Результатом слияния является [1,2,2,3,5,6] с подчеркнутыми элементами, взятыми из nums1.
 * Пример 2:
 *
 * Ввод: nums1 = [1], m = 1, nums2 = [], n = 0
 * Выход: [1]
 * Пояснение: Мы объединяем массивы [1] и [].
 * Результат слияния: [1].
 * Пример 3:
 *
 * Ввод: nums1 = [0], m = 0, nums2 = [1], n = 1.
 * Выход: [1]
 * Пояснение: Мы объединяем массивы [] и [1].
 * Результат слияния: [1].
 * Обратите внимание: поскольку m = 0, в nums1 нет элементов.
 * 0 нужен только для того, чтобы результат слияния мог поместиться в nu.
 */

public class MergeSortedArray {

    public static void main(String[] args) {

        //testCase - 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        // testCase - 2
//        int[] nums1 = {0, 0};
//        int m = 0;
//
//        int[] nums2 = {1, 1};
//        int n = 2;



        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
          nums1[k] = nums2[j];
          j--;
          k--;
        }

    }

// простейший способ
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int count = 0;
//        for (int i = m; i < nums1.length; i++) {
//            nums1[i] = nums2[count];
//            count++;
//        }
//        Arrays.sort(nums1);
//    }


}