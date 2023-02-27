package main.Baekjoon.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle {

  //초기화를 -1로 해두기. 5x5 배열로 만들지만, -1이면 읽을 수 없음

  static int[][] arr;
  static int n;

  public static void solution() {

    //O(N^2)
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        arr[i][j] = Math.max(arr[i-1][j-1]+arr[i][j], arr[i-1][j]+arr[i][j]);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽을 수 있는 라인 추가
    n = Integer.parseInt(st.nextToken()); //한줄에서 공백 단위로 읽음
    arr = new int[n+1][n+1];

    //O(N^2)
    //outerloop: 0 - n-1 == n
    //innerloop: i+1
    //총 1+2+3+4+...+n; n*(n+1)/2 이지만, 상수 시간 1/2은 무시됨.
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine()); //공백단위로 읽을 수 있는 라인 추가
      for (int j = 1; j <= i; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solution();

    int answer = 0;
    //O(N) - 고려되지 않음.
    for (int i = 1; i <=n; i++) {
      answer = Math.max(answer, arr[n][i]);
    }
    System.out.println(answer);
  }
}
