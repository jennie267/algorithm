package programmers.dfsbfs.word;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		String[][] tickets2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },	{ "ATL", "SFO" } };
		System.out.println(tickets2.toString());
		Arrays.sort(tickets2, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
		});
		System.out.println(tickets2.toString());

	}
	
	static void sort(String[][] tickets) {
		
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				System.out.println("얍 : " +o1[1].contentEquals(o2[1]));
				if (o1[1].contentEquals(o2[1])) {
					System.out.println("숫자 : " +o1[1].compareTo(o2[1]));
					return o1[1].compareTo(o2[1]);
				} else {
					return -1;
				}
			}
		});
		
	}

}
