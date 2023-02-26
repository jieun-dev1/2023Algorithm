package main.Baekjoon.DP;


import java.util.Scanner;

/**
 * 배열로 구현 후, 배열 위치와 비교하는 부분에서 막힘. 소요: 1시간 40분
 */
public class Triangle {

  //초기화를 -1로 해두기. 5x5 배열로 만들지만, -1이면 읽을 수 없음

  static int[][] arr;
  static int n;

  public static void solution() {

    //O(N^2)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        //양 옆이 모두 있을 경우.
        if (i - 1 >= 0 && j - 1 >= 0 && j <= i - 1) {
          arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
          continue;
        }

        //왼쪽만 가능할 겨웅
        if (i - 1 >= 0 && j == i && j > i - 1) {
          arr[i][j] += arr[i - 1][j - 1];
          continue;
        }

        //대각선 오른쪽만 가능할 경우 (가장자리에 있음)
        if (i - 1 >= 0 && j - 1 < 0 && j == 0) {
          arr[i][j] += arr[i - 1][j];
          continue;
        }

      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];

    //O(N^2)
    //outerloop: 0 - n-1 == n
    //innerloop: i+1
    //총 1+2+3+4+...+n; n*(n+1)/2 이지만, 상수 시간 1/2은 무시됨.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    solution();

    int answer = 0;
    //O(N) - 고려되지 않음.
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, arr[n - 1][i]);
    }

    System.out.println(answer);
  }
}
