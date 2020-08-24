import java.util.*;

public class asdf {

	public static int solution(int[] numbers, int K) {
        int answer = 0;
        
        for(int i = 0; i < numbers.length-1; i++) {
        	for(int j = 1; j < numbers.length; j++) {
        		int gap = numbers[i] - numbers[j];
        		if(gap < 0) {
        			gap = -gap;
        		}
        		System.out.println("gap= " + gap);
        		if(gap > K) {
        			while(gap <= K) {
        				int temp = numbers[j];
        				numbers[j] = numbers[i];
        				numbers[i] = temp;
        				if(gap <= K) {
        					answer++;	
        				}
        			}
        			System.out.println("¹è¿­Àº" + Arrays.toString(numbers));
        		}
        	}
        }
        
        return answer;
    }

		
		
	
    
    public static void main(String args[]) {
    	int[] array = {3, 7, 2, 8, 6, 4, 5, 1};
    	System.out.println(solution(array,3));
    }
}