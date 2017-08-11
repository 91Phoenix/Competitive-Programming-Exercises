package equilibrium_index;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	
	public int solution(int[] A) {
		int inputLength = A.length;
		if(inputLength==1) return 0;
		int[] lowerAccumulator = new int[inputLength];
		int[] higherAccumulator = new int[inputLength];
		// the next conditon stops before the last two
		for (int i = 0; i < inputLength; i++) {
			if (i == 0) {
				lowerAccumulator[i] = A[i];
			} else {
				long result = ((long) lowerAccumulator[i - 1]) + ((long)A[i]);
				if ((result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)) {
					return -1;
				}
				lowerAccumulator[i] =lowerAccumulator[i - 1]+ A[i];
			}
		}
		for (int i = inputLength - 1; i >= 0; i--) {
			if (i == inputLength - 1) {
				higherAccumulator[i] = A[i];
			} else {
				long result = ((long) higherAccumulator[i + 1]) + ((long)A[i]);
				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					return -1;
				}
				higherAccumulator[i] = higherAccumulator[i + 1]+ A[i];
			}
		}
		for (int i = 0; i < inputLength - 1; i++) {
			if ((lowerAccumulator[i] - A[i]) == (higherAccumulator[i] - A[i])) {
				return i;
			}
			if (i == inputLength - 2 && (lowerAccumulator[i] == 0))
				return i;
		}
		return -1;
	}
}