import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  Q.
 *  수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램 작성
 *  [입력]
 *  1번째 줄에 수의 개수 N(1 <= N <= 100_000), 합을 구해야 하는 횟수 M(1 <= M <= 100_000),
 *  2번째 줄에 N개의 수, 각 수는 1000 보다 작거나 작은 자연수
 *  3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i 와 j
 *  [입력 ex]
 *  5 3         -> 데이터 수 N , 질의 개수 M
 *  5 4 3 2 1   -> 대상 배열
 *  1 3         -> i, j     => 결과 12
 *  2 4         -> i, j     => 결과 9
 *  5 5         -> i, j     => 결과 1
 *
 */
public class Chapter0001Main {
    /**
     *  [수도 코드]
     *  int n = 입력(데이터 수)
     *  int m = 입력(질의 수)
     *  long[] sumData = new long[데이터수(n) + 1]
     *  (합배열 구하기 반복문 data)
     *      sumData[i] = sumData[i-1] + 입력 받은 수
     *  (질의 반복문 m)
     *      int i = 입력 (시작점)
     *      int j = 입력 (끝점)
     *      출력(sumData[j] - sumData[i-1]) [시작점 ~ 끝점 의 합]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int count = Integer.parseInt(stringTokenizer.nextToken());
        int questionCount = Integer.parseInt(stringTokenizer.nextToken());

        long[] sumData = new long[count + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= count; i++) {
            sumData[i] = sumData[i - 1] + Long.parseLong(stringTokenizer.nextToken());
        }

        for (int q = 0; q < questionCount; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            long result = sumData[j] - sumData[i - 1];
            System.out.println("result = " + result);
        }
    }
}
