package medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/gas-station/
 */
public class S_134 {
    int i = 0;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (; i < gas.length; ) {
            if (canComplete(gas, cost, i)) {
                return i;
            } else {

            }
        }
        return -1;
    }

    private boolean canComplete(int[] gas, int[] cost, int start) {
        int cGas = gas[start];
        if (cGas < cost[start]) {
            i = start + 1;
            return false;
        }
        cGas = cGas - cost[start];

        for (int i = start + 1 >= gas.length ? 0 : start + 1; i != start; i = i + 1 >= gas.length ? 0 : i + 1) {
            cGas += gas[i];
            if (cGas < cost[i]) {
                if (i < start) {
                    this.i = gas.length;
                } else {
                    this.i = i + 1;
                }
                return false;
            }
            cGas = cGas - cost[i];
        }
        return true;
    }

    @Test
    public void test() {
        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
