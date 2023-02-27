package main.Baekjoon.DP;

import java.util.Scanner;

/**
 * 화폐 단위
 */
public class Unit {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] arr = new int[N]; //화폐 개수 만큼 ARR 배열을 만든다.
    int[] dp = new int[10001];//화폐는 최대 10000까지 주어진다.

    //인덱스는 0-10000개까지 있다. dp의 length는 10001개이므로 한 개 빼줘야 함.
    for(int i=0;i<dp.length;i++){
      dp[i] = 10001; //모두 10001로 초기화 한다.
    }
    dp[0] = 0;
    for(int i=0;i<N;i++){
      arr[i] = sc.nextInt();
    }
    //화폐를 차례로 순회한다.
    for(int i=0;i<arr.length;i++){
      //조사하고자 하는 화폐 가치 까지만 순회하자.
      for(int j = arr[i]; j<=M;j++){
        dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
      }
    }

    int answer = 0;
    if(dp[M]==10001){
      answer = -1;
    } else {
      answer =  dp[M];
    }
    System.out.println(answer);
  }
}
