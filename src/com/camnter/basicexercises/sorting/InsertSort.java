package com.camnter.basicexercises.sorting;

/**
 * 插入排序
 *
 * @author CaMnter
 */
public class InsertSort {
    /**
     * 插入排序
     * <p/>
     * 插入排序的基本思想是在遍历数组的过程中，假设在序号 i 之前的元素即
     * [0..i-1] 都已经排好序，本趟需要找到 i 对应的元素 x 的正确位置 k ，
     * 并且在寻找这个位置 k 的过程中逐个将比较过的元素往后移一位，为元素 x
     * “腾位置”，最后将 k 对应的元素值赋为 x ，插入排序也是根据排序的特性来
     * 命名的。
     * <p/>
     * 以下是一个实例，红色 标记的数字为插入的数字，被划掉的数字是未参与此次
     * 排序的元素，红色 标记的数字与被划掉数字之间的元素为逐个向后移动的元素
     * 比如第二趟参与排序的元素为 [11, 31, 12] ，需要插入的元素为 12 ，但是
     * 12 当前并没有处于正确的位置，于是我们需要依次与前面的元素 31 、 11 做
     * 比较，一边比较一边移动比较过的元素，直到找到第一个比 12 小的元素 11 时
     * 停止比较，此时 31 对应的索引 1 则是 12 需要插入的位置。
     * <p/>
     * 1.	初始：    [11, 31, 12, 5, 34, 30, 26, 38, 36, 18]
     * 2.
     * 3.	第一趟： [11, 31 , 12, 5, 34, 30, 26, 38, 36, 18] （无移动的元素）
     * 4.
     * 5.	第二趟： [11, 12 , 31, 5, 34, 30, 26, 38, 36, 18] （ 31 向后移动）
     * 6.
     * 7.	第三趟： [5 , 11, 12, 31, 34, 30, 26, 38, 36, 18] （ 11, 12, 31 皆向后移动）
     * 8.
     * 9.	第四趟： [5, 11, 12, 31, 34 , 30, 26, 38, 36, 18] （无移动的元素）
     * 10.
     * 11.	第五趟： [5, 11, 12, 30 , 31, 34, 26, 38, 36, 18] （ 31, 34 向后移动）
     * 12.
     * 13.	第六趟： [5, 11, 12, 26 , 30, 31, 34, 38, 36, 18] （ 30, 31, 34 向后移动）
     * 14.
     * 15.	第七趟： [5, 11, 12, 26, 30, 31, 34, 38 , 36, 18] （无移动的元素）
     * 16.
     * 17.	第八趟： [5, 11, 12, 26, 30, 31, 34, 36 , 38, 18] （ 38 向后移动）
     * 18.
     * 19.	第九趟： [5, 11, 12, 18 , 26, 30, 31, 34, 36, 38] （ 26, 30, 31, 34, 36, 38 向后移动）
     * <p/>
     * 插入排序会优于选择排序，理由是它在排序过程中能够利用前部分数组元素已经排好序的一个优势，
     * 有效地减少一些比较的次数，当然这种优势得看数组的初始顺序如何，最坏的情况下（给定的数组
     * 恰好为倒序）插入排序需要比较和移动的次数将会等于 1 + 2 + 3… + n = n * (n + 1) / 2 ，
     * 这种极端情况下，插入排序的效率甚至比选择排序更差。因此插入排序是一个不稳定的排序方法，
     * 插入效率与数组初始顺序息息相关。一般情况下，插入排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1) 。
     *
     * @param array
     * @param <T>
     */
    public <T extends Comparable<T>> T[] insertSorting(T[] array) {
        int len = array.length;
        // 每个元素选取出来作为插入元素
        for (int i = 0; i < len; i++) {
            T toInsert = array[i];
            int j = i;
            for (; j > 0; j--) {
                /**
                 * 原来顺序系列里从最大的数开始  和 现在选择的比较
                 * 如果找到比选择的数小的 break
                 * 此时已经记下了 坐标 保存到 j 中
                 */
                if (array[j - 1].compareTo(toInsert) <= 0) {
                    break;
                }
                /**
                 * 如果一直没找到j的位置 那么就是 选择到的元素一直比较小
                 * 那么一直腾位置
                 */
                array[j] = array[j - 1];
            }
            //如果此时 j = 0 说明了 顺序序列里没有比选择元素小的
            array[j] = toInsert;
            System.out.print("i = " + i + "  array = ");
            for (T data : array) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }
        return array;
    }

    public static void main(String args[]) {
        /**
         * 插入排序
         */
        InsertSort insertSort = new InsertSort();
        System.out.println("\n插入排序\n");
        Integer[] object = {11, 31, 12, 5, 34, 30, 26, 38, 36, 18};
        Integer[] result = insertSort.insertSorting(object);
        System.out.println("");
        System.out.println("\n插入排序\n");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("\n插入排序\n");
    }
}
