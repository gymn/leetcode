package greedy;

import org.junit.Test;

import java.util.Arrays;

public class S_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five >= 1) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            }

            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] bills = {10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
