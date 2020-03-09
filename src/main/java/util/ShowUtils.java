package util;

/**
 * @author hunan
 * @date 2020-03-01
 * @time 21:21
 */
public class ShowUtils {
    public static void show(Object[][] arr) {
        if (arr == null) {
            return;
        }

        for (Object[] objects : arr) {
            for (Object object : objects) {
                System.out.print(object);
            }
            System.out.println();
        }
    }

    public static void show(char[][] arr) {
        if (arr == null) {
            return;
        }

        for (char[] objects : arr) {
            for (Object object : objects) {
                System.out.print(object);
            }
            System.out.println();
        }
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
    }
}
