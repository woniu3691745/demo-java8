package algorithm;

/**
 * 排序
 *
 * @author 李栋梁
 * @date 2018/6/27 下午9:08
 */
public class Sort {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        int[] arrays = new int[SIZE];
        int i;
        for (i = 0; i < SIZE; i++) {
            arrays[i] = (int) (100 + Math.random() * (100 + 1));
        }
        System.out.print("排序前的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.print("\n");
        bubbleSort(arrays);
//        selectSort(arrays);
        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.print("\n");
    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    private static void bubbleSort(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) { // 将相邻两个数进行比较，较大的数往后冒泡
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.print("第" + i + "步排序结果:");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    private static void selectSort(int[] a) {
        int index, temp;
        for (int i = 0; i < a.length; i++) {
            index = i;
            for (int j = i + 1; j < a.length; j++) {
                // 用第 n+1 个和第 n 比
                if (a[j] < a[index]) {
                    index = j; // 取出最小的
                }
            }
            // 交换两个数
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
            System.out.print("第" + i + "步排序结果：");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }
}
