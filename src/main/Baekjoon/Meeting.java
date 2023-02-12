package main.Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {

  int start;
  int end;

  Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(Meeting o) {
    if (this.end == o.end) {
      return this.start - o.start;
    } else {
      return this.end - o.end;
    }
  }
}

class Room {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Meeting> list = new ArrayList<>();
    for(int i=0;i<n;i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      list.add(new Meeting(start, end));
    }
    Collections.sort(list);

    //답을 찾는 부분.
    int temp = list.get(0).end; // 현재 끝나는 시간이 가장 빠른 노드의 (정렬 첫 번쨰 순서) 끝나는 시간. 이는 계속 갱신되는 값.
    int answer = 0; //한 번의 순회를 통해서 얻어진 값.
    for(int i=0;i<list.size();i++){
      int count = 1; // count는 i마다 건다.
      for(int j=i+1;j<list.size();j++){
        if(list.get(j).start>=temp){ //현재 노드가 끝나는 시간보다, 다음 노드의 시작 시간이 빠르거나 같을 때.
          temp = list.get(j).end;
          count++;
        }
      }
      answer = Math.max(count, answer); // 큰 값으로 업데이트.
    }
    System.out.println(answer);
    }
  }
