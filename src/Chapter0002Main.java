import java.util.Scanner;

/**
 *  [Q]
 *  N x N 개의 수가 N x N 크기의 표에 채워져있다.
 *  표안의 수중 (X1, Y1) 부터 (X2, Y2) 까지의 합을 구하는 프로그램을 작성하시오.
 *  X 는 행 Y 는 열을 의미한다.
 *  [입력]
 *  1번째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.(1 <= N <= 1024, 1 <= M <= 100,000)
 *  2번째 줄부터 N개의 줄에는 표에 채워져있는 수가 주어진다.
 *  다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2 가 주어지며, (X1, Y1) 부터 (X2, Y2) 까지의 합을 구해야 한다.
 *  표에 채워져 있는 수는 1,000 보다 작거나 같은 자연수이다.(X1 <= X2, Y1 <= Y2)
 *  [출력 예시]
 *  4 3         =>  4 x 4 크기의 표에 대한 합을 3번 구해야 한다.
 *  1 2 3 4     =>  1 2 3 4 (1번째 줄)
 *  2 3 4 5     =>  2 3 4 5 (2번째 줄)
 *  3 4 5 6     =>  3 4 5 6 (3번째 줄)
 *  4 5 6 7     =>  4 5 6 7 (4번째 줄)
 *  2 2 3 4     =>  2 2 3 4 (2행 2열부터 3행 4열까지의 합) : 결과 27
 *  3 4 3 4     =>  3 4 3 4 (3행 4열부터 3행 4열까지의 합) : 결과 6
 *  1 1 4 4     =>  1 1 4 4 (1행 1열부터 4행 4열까지의 합) : 결과 64
 */
public class Chapter0002Main {
    /**
     * [슈도 코드]
     * String sizeAndQuestionCount = 입력 받은 1번째 줄 값
     * int n = sizeAndQuestionCount.split(" ")[0]
     * int m = sizeAndQuestionCount.split(" ")[1]
     * int[][] table = new int[n + 1][n + 1]
     * long[][] sumTable = new long[n + 1][n + 1]
     * for(n) {
     *     String row = 입력 받은 n번째 줄 값
     *     table[n] = row.split(" ")
     *     for(table[i].length) {
     *      sumTable[i][j] = sumTable[i][j-1] + sumTable[i-1][j] - sumTable[i-1][j-1] + table[i][j]
     * }
     * for(m) {
     *   String question = 입력 받은 m번째 줄 값
     *   int x1 = question.split(" ")[0]
     *   int y1 = question.split(" ")[1]
     *   int x2 = question.split(" ")[2]
     *   int y2 = question.split(" ")[3]
     *   long result = sumTable[x2][y2] - sumTable[x1-1][y2] - sumTable[x2][y1-1] + sumTable[x1-1][y1-1]
     * }
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sizeAndQuestionCount = sc.nextLine();
        int n = Integer.parseInt(sizeAndQuestionCount.split(" ")[0]);
        int m = Integer.parseInt(sizeAndQuestionCount.split(" ")[1]);
        int[][] table = new int[n + 1][n + 1];
        long[][] sumTable = new long[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            String row = sc.nextLine();
            table[i] = new int[n + 1];
            String[] rowArray = row.split(" ");
            for(int j = 1; j <= n; j++) {
                table[i][j] = Integer.parseInt(rowArray[j - 1]);
                sumTable[i][j] = sumTable[i][j - 1] + sumTable[i - 1][j] - sumTable[i - 1][j - 1] + table[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            String question = sc.nextLine();
            int x1 = Integer.parseInt(question.split(" ")[0]);
            int y1 = Integer.parseInt(question.split(" ")[1]);
            int x2 = Integer.parseInt(question.split(" ")[2]);
            int y2 = Integer.parseInt(question.split(" ")[3]);
            long result = sumTable[x2][y2] - sumTable[x1 - 1][y2] - sumTable[x2][y1 - 1] + sumTable[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}