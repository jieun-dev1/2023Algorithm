package main.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
참고: 이코테 강의
 */
class Node implements Comparable<Node> {

  private int index;
  private int distance;

  public Node(int index, int distance){
    this.index = index;
    this.distance = distance;
  }

  public int getIndex(){
    return this.index;
  }

  public int getDistance(){
    return this.distance;
  }
  //거리(비용) 짧은 것이 높은 우선순위
  //현재 노드의 distance가 비교 대상 노드의 distance보다 작다면,-1 리턴
  // -> 이는 현재 노드는 other 노드보다 작다고 인식해서 이 기준으로 정렬함
  // (compareTo는 기본적으로 ascending이기 때문에, 이렇게 ascending으로 정렬됨됨

  @Override
  public int compareTo(Node other) {
    if(this.distance < other.distance) {
      return -1;
    }
    return 1;
  }
}

class Dijkstra {
  public static final int INF = (int) 1e9; //무한을 의미하는 값으로 10억 설정
  //노드의 개수 N, 간선 개수 m, 시작 노드 번호 (start)
  //노드의 개수는 최대 100,000개.
  public static int n, m, start;
  //각 노드에 연결되어 있는 노드에 대한 정보 담는 배열
  public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  //최단 거리 테이블 만들기 - 인덱스는 0부터 시작이지만, 1부터 시작하기 위해 100000+1 만큼 만들어준다.
  public static int[] d = new int [100001];

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    //시작 노드로 가기 위한 최단 경로는 0임 (시작 노드 - 시작 노드), 큐에 삽입.
    pq.offer(new Node(start, 0));
    d[start] = 0;
    while(!pq.isEmpty()){
      //큐가 비어있지 않는 동안 while 문.
      //가장 최단거리가 짧은 노드 정보 꺼내기.
      Node node = pq.poll();
      int now = node.getIndex(); //현재 노드
      int dist = node.getDistance(); //현재 노드까지의 비용
      //현재 노드가 이미 처리된 적 있는 노드라면 무시
      if(d[now]<dist) continue;
      //즉 시작 노드의 경우도 아래 노드 확인을 거침. 모두 INF 로 초기화 되어 있기 때문이다.
      //현재 노드의 인접리스트 (다른 연결된 노드 모두 확인 위해) 훑기
      for(int i=0;i<graph.get(now).size();i++){
        int cost = d[now] + graph.get(now).get(i).getDistance();
        //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
        if(cost < d[graph.get(now).get(i).getIndex()]){
          d[graph.get(now).get(i).getIndex()] = cost;
          pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
        }
      }
    }
  }

  //1. 받은 정보를 노드에 세팅
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //노드의 개수 n을 입력 받는다.
    n = sc.nextInt();
    //간선의 개수 m을 입력 받는다.
    m = sc.nextInt();
    //시작 노드 번호를 입력 받는다.
    start = sc.nextInt();

    //그래프 초기화 - 인덱스를 노드 번호로 하고 싶기 때문에 n+1개 만큼 넣기.
    for(int i=0;i<=n;i++) {
      graph.add(new ArrayList<Node>());
    }

    //모든 간선 정보 입력. a 노드에서 b로 가는 비용 c
    for(int i=0;i<m;i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      graph.get(a).add(new Node(b, c));
    }
    // 최단 거리 테이블을 무한으로 초기화.
    Arrays.fill(d, INF);
    // 다 익스트라 알고리즘 수행
    dijkstra(start);

    //모든 노드로 가기 위한 최단 거리 출력
    for(int i=1;i<=n;i++){
      //도달할 수 없는 경우 무한 (INF)이라고 출려 ㄱ
      if(d[i] == INF) {
        System.out.println("INFINITY");
      }
      //도달할 수 있는 경우 거리를 출력
      else {
        System.out.println(d[i]);
      }
    }
  }

}
