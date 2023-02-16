package main.Baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Wifi {

  static int[] arr;
  static int C;
  static int end;

  public static int count(int mid){
    int i=0; int j= i+mid;
    while(j<=end){
      int count;
      int current = arr[i];
      int next = arr[j];
      if(next-current>=mid){
        count++;
      }
    }

  }

  public int binarySearch(){
    //인접한 거리를 탐색하는 중.
    //거리의 범위? 최대 거리는 최소 원소 - 최대 원소의 차이를 넘지 않는다.
    //mid 거리에 대해, 설치 가능한 공유기 개수가 C에 못미치면,
    //-> mid거리를 좁히기 위해, end를 mid-1로 줄인다.
    //C 보다 크거나 같다면, start = mid+1 로 위를 탐색한다.
    int start = 1; //최소거리
    int len = arr.length; //배열의 사이즈
    end = arr[len-1]-arr[0]; //배열의 첫 원소와 마지막 원소가 떨어진 거리 == 즉 최대 길이를 끝점에 두자.

    while(start<end){
      int mid = (start+end)/2;
      if(count(mid)<=C){
        start = mid+1;
      } else {
        end = mid-1;
      }
    }

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Wifi T = new Wifi();
    int N = sc.nextInt();
    C = sc.nextInt();
    arr = new int[N];
    for(int i=0;i<N;i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr); //좌표에서 순차적으로 서있어야 함.
    T.binarySearch();
  }
}
