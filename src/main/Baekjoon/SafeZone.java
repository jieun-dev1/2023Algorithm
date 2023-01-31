package main.Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class SafeZone {
  static int answer = 0;
  static ArrayList<Integer> answerList;
  static int N;;//arr와 같은 크기로 ch 배열
  static int[][] arr;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};

  public void solution(int N, int[][] arr, int min, int max){
    //높이가 1이상 100이하의 정수이지만, 해당 배열에서의 최소, 최대 수를 찾을 필요가 있다.
    //최소~최대 수 -1 까지 탐색
    //N도 100이기 때문에 3중 for 문 가능
    for(int k=min;k<max;k++){
      int count = 0;
      boolean[][] ch = new boolean[N][N];
      for(int i=0;i<N;i++){
        for(int j=0;j<N;j++) {
          if(arr[i][j]>k && ch[i][j]==false) {
            ch[i][j]=true;
            DFS(i, j, k, ch);
            count++;
          }
        }
      }
      //k를 돌때마다 answer를 더해준다.
      answerList.add(count);
    }
  }

  public void DFS(int x, int y, int k, boolean[][] ch){
    for(int i=0;i<4;i++){
      int nx = dx[i]+x;
      int ny = dy[i]+y;
      if(nx>=0&&nx<N&&ny>=0&&ny<N&&ch[nx][ny]==false&&arr[nx][ny]>k){
        //dfs 를 할 때는 꼭 방문 체크를 해줘야, 무한 루프 돌지 않는다.
        ch[nx][ny]=true;
        DFS(nx, ny, k, ch);
      }
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    //N이 정해진 후에 CHECK 배열을 초기화 해준다. 아니면 n이 이전에 0이었기 때문에 INVALID ARRAY RANGE 발생
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    arr = new int[N][N];
    for(int i=0;i<N;i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
        min = Math.min(arr[i][j], min); //최소 값을 찾기
        max = Math.max(arr[i][j], max); //최소 값을 찾기
      }
    }
    answerList = new ArrayList<>(); //min- (max-1) 까지 순회하면서, answer를 찾는다. 따라서 max-min 갯수 만큼 만들어짐. 높이가 1인 경우는 고려 x.
    SafeZone T = new SafeZone();
    T.solution(N, arr, min, max);
    //answerList 에 등록된 count 중 가장 큰 값 찾기
    for(int i=0;i<answerList.size();i++){
      answer = Math.max(answerList.get(i), answer);
    }
    System.out.println(answer);

  }
}
