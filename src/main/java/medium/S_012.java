package medium;

public class S_012 {
    public String intToRoman(int num) {
        String[][] items = {
                {"", "M", "MM", "MMM"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "X", "XX", "XXX", "XL","L", "LX", "LXX", "LXXX", "XC"},
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
        };

        int[] facts = {1000, 100, 10, 1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < facts.length; i++) {
            sb.append(items[i][num / facts[i]]);
            num %= facts[i];
        }
        return sb.toString();
    }

    public void testIntToRoman() {
        System.out.println(intToRoman(4));
    }
}
