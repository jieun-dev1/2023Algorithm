package main.Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 참고: https://velog.io/@jaehe0413/%EB%B0%B1%EC%A4%80-118405-%EA%B2%BD%EC%9F%81%EC%A0%81-%EC%A0%84%EC%97%BC-java
 * <p>
 * 시험관의 크기 N: 최대 200 바이러스 번호 K: 최대 1000 시간 S초: 0-10000
 */

class Node implements Comparable<Node> {

  int num;
  int x;
  int y;

  Node(int num, int x, int y) {
    this.num = num;
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Node o) {
    return this.num - o.num; //num 오름차 순으로 정렬 확인.
  }
}


class Infection {

  static int N;
  static int K;
  static int[][] arr;
  static int S;
  static int X;
  static int Y;
  static Queue<Node> queue = new LinkedList<>();
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};


  public void solution() {
    int time = 0;
    while (!queue.isEmpty()) {
      if (time == S) { //queue를 도는 횟수와 주어진 S가 일치할 때 탈출.
        return; //0초라면, 탐색 없이 바로 exit 할 것이다.
      }
      int size = queue.size();
      //아래를 queue.size()로 하면, queue다 동적으로 증가
      for (int i = 0; i < size; i++) {
        Node current = queue.poll();
        for (int j = 0; j < 4; j++) {
          int nx = current.x + dx[j];
          int ny = current.y + dy[j];
          if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            if (arr[nx][ny] == 0) {
              arr[nx][ny] = current.num; //현재 뽑은 원소의 사방 탐색을 하는 것이고, num 과 같은 숫자로 전염되니까.
              queue.offer(new Node(arr[nx][ny], nx, ny));
            }
          }
        }
      }
      time++;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Infection T = new Infection();
    N = sc.nextInt();
    K = sc.nextInt();
    arr = new int[N][N]; //인덱스로 찾기 위해 1개 더 만들어줌.
    List<Node> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
        //0이 아니라면 더해줄 것.
        if (arr[i][j] > 0) {
          list.add(new Node(arr[i][j], i, j));
        }
      }
    }

    S = sc.nextInt();
    X = sc.nextInt();
    Y = sc.nextInt();

    Collections.sort(list);
    queue.addAll(list);
    T.solution();
    System.out.println(arr[X-1][Y-1]);
  }
}
