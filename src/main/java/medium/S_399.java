package medium;

import org.junit.Test;
import util.ShowUtils;

import java.util.*;

public class S_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int index = 0;
        Map<String, Integer> codeMap = new HashMap<>();
        for (List<String> equation : equations) {
            if (!codeMap.containsKey(equation.get(0))) {
                codeMap.put(equation.get(0), index++);
            }
            if (!codeMap.containsKey(equation.get(1))) {
                codeMap.put(equation.get(1), index++);
            }
        }

        double[][] matrix = new double[index][index];
        for (int i = 0; i < index; i++) {
            matrix[i][i] = 1.0;
        }
        for (int i = 0; i < equations.size(); i++) {
            int row = codeMap.get(equations.get(i).get(0));
            int col = codeMap.get(equations.get(i).get(1));
            matrix[row][col] = values[i];
            matrix[col][row] = 1 / values[i];
        }

        for (int k = 0; k < index; k++) {
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index; j++) {
                    if (matrix[i][j] == 0 && matrix[i][k] != 0 && matrix[k][j] != 0) {
                        matrix[i][j] = matrix[i][k] * matrix[k][j];
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!codeMap.containsKey(queries.get(i).get(0)) || !codeMap.containsKey(queries.get(i).get(1))) {
                ans[i] = -1.0;
            } else {
                double value = matrix[codeMap.get(queries.get(i).get(0))][codeMap.get(queries.get(i).get(1))];
                ans[i] = value > 0 ? value : -1.0;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        ShowUtils.show(calcEquation(equations, values, queries));
    }
}
