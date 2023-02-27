package main.Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 221. 개미전사
 */
public class Ant {
  static int[] arr;
  static int[] dp;
  static int N;
  public static void solution(){
      dp[0] = arr[0];
      dp[1] = Math.max(arr[0], arr[1]); //첫번째 창고를 털거나 털지 않거나.
      //2부터 N까지는 DP 로 계산
    for (int i = 2; i < N; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]); //바로 전 값을 약탈하는 경우 혹은 전전 값+ 현재 값을 취하는 경우
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽을 수 있는 라인 추가
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    dp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    solution();

    System.out.println(dp[N-1]);
  }
}
