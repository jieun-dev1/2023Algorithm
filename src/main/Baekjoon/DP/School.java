package main.Baekjoon.DP;

//풀이 참고: https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8
class School {

  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    //n = row
    //m = col
    //지역 격자의 초기화
    //좌표 상에서는 [0][0]에서 시작해서 [n-1][m-1] 값을 찾아보기
    int[][] dp = new int[n][m];

    for (int[] puddle : puddles) {
      dp[puddle[1] - 1][puddle[0] - 1] = -1;
    }

    //O(MN) == O(10000)
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        //처음은 -1 임
        if (row == 0 && col == 0) {
          dp[row][col] = 1;
          continue;
        }
        //물 웅덩이라면 무시하기
        if (dp[row][col] == -1) {
          dp[row][col] = 0;
          continue;
        }

        //위쪽에서만 탐색할 경우 (맨 앞일 때)
        if (row != 0) {
          dp[row][col] += dp[row - 1][col] % 1000000007;
        }

        //왼쪽만 탐색 가능한 경우 (맨 윗줄일 때)
        if (col != 0) {
          dp[row][col] += dp[row][col - 1] % 1000000007;
        }

      }
    }

    answer = dp[n - 1][m - 1] % 1000000007;

    return answer;
  }


  public static void main(String[] args) {
    School T = new School();
    System.out.println(T.solution(4, 3, new int[][]{{2, 2}}));
  }
}