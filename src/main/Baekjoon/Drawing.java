package main.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
  int x;
  int y;
  Cell(int x, int y){
    this.x = x;
    this.y = y;
  }
}

class Drawing {

  //그림의 개수
  static int cnt;
  static int tempArea;
  //가장 넓은 그림의 넓이
  static int area; //area는 계속 발견한 수만큼 더해가는 것.
  static int[][] arr;
  static boolean[][] flag; //true-false 를 판별하는 flag arr
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static Queue<Cell> queue = new LinkedList<>();

  static int n;
  static int m;

  public void BFS(){
    Cell temp = queue.poll();
    for (int k = 0; k < 4; k++) {
      int nx = temp.x + dx[k];
      int ny = temp.y + dy[k];
      if (nx>=0&&nx<n&&ny>=0&&ny<m&&arr[nx][ny] == 1 && flag[nx][ny] == false) {
          queue.add(new Cell(nx, ny));
        flag[nx][ny] = true;

      }
    }
  }

  public void solution() {
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        //한번도 탐색하지 않은 곳에서 찾아야 함.
        if (arr[x][y] == 1 && flag[x][y] == false) {
          queue.add(new Cell(x, y));
          flag[x][y] = true;
          tempArea = 0;
          while(!queue.isEmpty()){
            BFS();
            tempArea++; //queue가 비어있지 않아서, BFS가 불릴 때마다, CNT가 늘어남.
          }
          cnt++;
          area = Math.max(tempArea, area);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Drawing T = new Drawing();
    n = sc.nextInt();
    m = sc.nextInt();
    arr = new int[n][m];
    flag = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    T.solution();
    System.out.println(cnt);
    System.out.println(area);

  }
}
