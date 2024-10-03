import java.util.Scanner;

/**
 * [Q]
 * N 개의 수 A1, A2, ..., AN 이 주어졌을 때 연속된 부분의 합이 M으로 나누어 떨어지는 구간의 개수를 구하시오.
 * Ai + ... + Aj(i <= j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구하시오.
 * [입력]
 * 1번째 줄에 N과M(1 <= N <= 106, 2 <= M <= 103)이 주어진다.
 * 2번째 줄에 N개의 수가 주어진다. 수는 109보다 작거나 같은 자연수이다.
 * [출력]
 * 5 3          => N = 5, M = 3
 * 1 2 3 1 2    => 주어진 수 : 결과 7
 */
public class Chapter0003Main {
    /**
     * [슈도 코드]
     * N = 입력(수의 개수)
     * M = 입력(나누는 수)
     * int[] A = new int[N] 입력(수의 배열)
     * long[] S = new long[N] 입력(수의 합배열)
     * int zeroCount = 0 (나머지가 0인 경우 카운트)
     * int[] mod = new int[N] (나머지 배열)
     * for(i -> 0 ~ N) {
     *   if(i == 0) {
     *      S[i] = A[i]
     *      continue
     *   }
     *   S[i] = S[i - 1] + A[i]
     * }
     * for(i -> 0 ~ N) {
     *   int m = S[i] % M
     *   if(m == 0) zeroCount++
     *   mod[m]++
     * }
     * for(i -> 0 ~ M) {
     *   if(mod[i] > 1) {
     *      zeroCount += mod[i] * (mod[i] - 1) / 2
     *   }
     * }
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int modValue = sc.nextInt();

        long[] sumData = new long[numCount];
        sumData[0] = sc.nextInt();
        for (int i = 1; i < numCount; i++) {
            sumData[i] = sumData[i - 1] + sc.nextInt();
        }

        int zeroCount = 0;
        int[] modData = new int[numCount];
        for(int i = 0; i < numCount; i++) {
            int mod = (int) (sumData[i] % modValue);
            if(mod == 0) zeroCount++;
            modData[mod]++;
        }

        for(int i = 0; i < modValue; i++) {
            if(modData[i] > 1) {
                zeroCount += modData[i] * (modData[i] - 1) / 2;
            }
        }
        System.out.println("result value => " + zeroCount);
    }
}
