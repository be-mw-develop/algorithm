import java.util.Scanner;

/**
 *  [Q]
 *  어떠한 자연수 N 은 몇 개의 연속된 자연수의 합으로 나타낼수 있다.
 *  어떤 자연수 (N <= 1 <= 10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 구하는 프로그램을 작성 하시오
 * 
 *  [입력]
 *  1번째 줄에 정수 N 이 주어 진다 (합 의 값)
 * 
 *  [출력]
 *  15      => 결과 : 4 (1+2+3+4+5, 4+5+6, 7+8, 15)
 */
public class Chapter0004Main {
    /**
     *  [슈도 코드]
     *  N = 입력된 정수
     *  C = 1 (연속된 값의 합이 입력한 정수가 최는 가짓수| 자기 자신의 수를 포함 하기에 1로 초기화)
     *  S = 1 (연속 된 값의 합 | 시작 수는 1부터 시작하기 때문에 1로 초기화)
     *  END_IDX = 1 (끝점 포인터)
     *  START_IDX = 1 (시작점 포인터)
     *  while(END_IDX != N) {
     *      if(S == N) C += 1
     *      if(S > N) S -= START_IDX, 시작점 포인터 1이동
     *      if(S < N) S += END_IDX
     *  }
     *  print(결과 = C)
     */
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            long number = sc.nextInt();
            int count = 1;
            long sum = 1;

            long startIndex = 1;
            long endIndex = 1;

            while (endIndex != number) {
                if (sum == number) {
                    count++;
                    endIndex++;
                    sum = sum + endIndex;
                    continue;
                }

                if (sum > number) {
                    sum = sum - startIndex;
                    startIndex++;
                    continue;
                }

                if (sum < number) {
                    endIndex++;
                    sum = sum + endIndex;
                    continue;
                }
            }
            System.out.print("result => " + count);
        }
    }
}
