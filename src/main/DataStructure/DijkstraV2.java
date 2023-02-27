package main.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;



public class DijkstraV2 {
  static int n; //노드 개수

  static int m; //간선 개수

  static int start; //시작 점

  static int[] d = new int[100001]; //최대 노드 수.

  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  static Queue<Node> queue = new PriorityQueue<>();

  private static class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node other){
      if(this.distance < other.distance){
        return -1;
      }
      return 1;
    }
  }

  public static void dijkstra(){
    while(!queue.isEmpty()){
      Node temp = queue.poll();
      int now = temp.index; //현재 탐색하는 위치를 now라고 정의

      for(int i=0; i<graph.get(now).size();i++){

        int cost = d[now]+ graph.get(now).get(i).distance; //노드까지 가는 길이 + 현재 점까지의 비용.

        if(cost<d[graph.get(now).get(i).index]){
          d[graph.get(now).get(i).index] = cost;
          queue.offer(new Node(graph.get(now).get(i).index, cost));
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    start = sc.nextInt();

    Arrays.fill(d, (int) 1e9);

    //0부터 n까지 노드가 생성되서, 인덱스를 접근하기 편합니다
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i=0;i<m;i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      int cost = sc.nextInt();
      graph.get(a).add(new Node(b, cost));
    }
    d[start] = 0;
    queue.offer(new Node(start, 0)); // 출발점 - 자기자신까지의 거리는 0이다.
    dijkstra();

    for(int i=1; i<=n;i++){
      System.out.println(d[i]);
    }
  }
}
