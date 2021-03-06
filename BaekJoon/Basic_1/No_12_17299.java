package Basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_12_17299 {
	static StringBuilder sb = new StringBuilder();
	static int[] num ;
	static int[] count;
	static Stack<Integer> list = new Stack<Integer>();
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		
		String input = br.readLine();
		String[] inputSplit = input.split(" ");
		
		num = new int[inputSplit.length];
		answer = new int[num.length];
		
		int max = -1;
		
		for(int i = 0; i < inputSplit.length; i++) {
			num[i] = Integer.parseInt(inputSplit[i]);
			max = max > num[i] ? max : num[i];
		}
		count = new int[max+1];
		
		for(int i = 0; i < num.length; i++) {
			count[num[i]] ++;
		}
		
		solve();
		
		System.out.println(sb);
	}
	
	public static void solve() {
		for(int i = 0; i < num.length; i++) {
			while(!list.empty() && count[num[list.peek()]] < count[num[i]]) {
				answer[list.pop()] = num[i];
			}
			list.push(i);
		}
		
		while(!list.empty()) {
			answer[list.pop()] = -1;
		}
		
		for(int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");
		}
	}
}
