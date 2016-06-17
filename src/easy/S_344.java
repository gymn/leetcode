package easy;

public class S_344 {
	public static String reverString(String s) {
		StringBuilder res = new StringBuilder();
		for(int i = s.length() - 1; i >=0; i--){
			res.append(s.charAt(i));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String s = "Hello";
		System.out.println(reverString(s)); 
	}
}
