package easy;

/**
 * Created by ad on 2017/8/8.
 */
public class S_013 {
    public static int romanToInt(String s) {
        if(s==null||s.length()==0)
            return 0;

        int[] romap = new int[24];
        romap['I'-'A'] = 1;
        romap['V'-'A'] = 5;
        romap['X'-'A'] = 10;
        romap['L'-'A'] = 50;
        romap['C'-'A'] = 100;
        romap['D'-'A'] = 500;
        romap['M'-'A'] = 1000;

        char[] ca = s.toCharArray();
        int sum = romap[ca[0]-'A'];

        for(int i=1;i<ca.length;i++){
            sum+=romap[ca[i]-'A'];
            if(romap[ca[i]-'A']>romap[ca[i-1]-'A'])
                sum -= romap[ca[i-1]-'A']*2;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("CCXIII"));
    }
}
