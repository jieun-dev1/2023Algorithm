package main.Baekjoon;

import java.util.Scanner;


class Cutting {

  static int M; //가져가려고 하는 나무 길이
  static int N; //나무의 개수
  static int[] arr;
  int start = 0;
  int end;
  int mid;

  //역할: 주어진 나무 가져갈 수 있는 길이 총합. 100만* 나무 별 높이 최대 10억 이니까. Long으로 준다.
  public static Long calSum(int mid) {
    long sum = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i] > mid) { //실수: mid가 아닌 m과 비교. 여기서 m은 고정값이ㅏㄷ.
        sum += arr[i] - mid;
      }
    }
    return sum;
  }

  /**
   * start<=end인 이유
   */
  public int binarySearch(int start, int end, int[] arr) {
    while (start <= end) {
      mid = (start + end) / 2;
      if (calSum(mid) >= M) {
        start = mid + 1; //더 뒤에 더 큰 mid값이 있는지 계산하기 위함.
      } else {
        end = mid - 1; //mid는 해당이 안되는 값이어서..
      }
    }
    return end;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Cutting T = new Cutting();
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[N];
    int max = -1;
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      //나무를 자를 때는, 가장 큰 나무까지만 자른다. ( 그 이상으로 자르면 자를 수가 없다)
      max = Math.max(max, arr[i]);
    }
    //피봇은 H이다.
    System.out.println(T.binarySearch(0, max, arr)); //끝값이 나무의 가장 큰 높이다.

  }

}

