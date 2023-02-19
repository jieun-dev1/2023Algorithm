package main.DataStructure;


/**
 * UpperBound
 */
public class BinarySearch {

  /**
   * target이 몇 번째 인덱스에 위치할까?
   *
   * arr: 탐색할 arr
   * target: 목표
   * start: 시작점
   * end: 끝점
   *
   * 시작점 - 끝점의 중간점을 찾고, 중간점이 target 보다 크다면, 왼쪽 (중간점 - 맨 끝은 볼 필요가 없다)
   * 끝점 = mid - 1
   * 중간점이 target 보다 작다면, 오른쪽을 탐색한다.
   * 시작점 = mid + 1
   *
   * 궁금한 것: start<end인 경우?
   */
  public static int binarySearch(int[]arr, int target, int start, int end){
    while(start<=end){
      int mid = (start+end)/2;
      //찾은 경우 중간점 인덱스 반환
      if(arr[mid] == target) return mid;
      //중간 값이 target보다 클 때, 왼쪽 확인.
      else if(arr[mid]>target) end = mid-1;
      //중간 값이 target보다 작을 때, 오른쪽 확인
      //arr[mid]<target
      else start = mid+1;
    }
    return -1;
  }

  /**
   * Upper Bound를 key보다 큰 첫번째 값이라고 하는 경우도 있고 -> 탐색 범위를 제한 하기 위함 (아래 예시)
   * key가 나타난 인덱스 중 가장 마지막이라고 하는 경우도 있음. -> goal이 array의 target element가 나타나는 수를 재고자 하는 것일 떄.
   */
  public static int upperBound(int[]arr, int target){
    int start = 0;
    int end = arr.length-1;
    while(start<end){
      int mid = (start+end)/2;
      //arr[mid]가 target보다 작거나 같다면, 계속 위의 값을 탐색해 봐야 함.
      if(arr[mid]<=target) start = mid + 1;
      //arr[mid]가 target보다 크거나 같다면, 아래 값을 탐색해야 함.
      else end = mid; //원래 이진 탐색에서는 mid-1을 했지만, Upper/LowerBound에서는 mid 를 포함해서 변경한다. 그렇게 해야, 결과값이 end 근처에 위치하게 되서 return end가 가능하다.
    }
    return end;
  }

  public static int lowerBound(int[]arr, int target){
    int start = 0;
    int end = arr.length-1;
    while(start<end){
      int mid = (start+end)/2;
      //arr[mid]가 target보다 작다면, 계속 위의 값을 탐색해 봐야 함.
      if(arr[mid]<target) start = mid + 1;
        //arr[mid]가 target보다 크거나 같다면, 아래 값을 탐색해야 함.
      else end = mid; //원래 이진 탐색에서는 mid-1을 했지만, Upper/LowerBound에서는 mid 를 포함해서 변경한다. 그렇게 해야, 결과값이 end 근처에 위치하게 되서 return end가 가능하다.
    }
    return end;
  }

  public static void main(String[] args) {
    System.out.println(binarySearch(new int[]{1,3,5,7,9,11,13,15,17,19}, 11, 0, 9));
    System.out.println(upperBound(new int[]{1,4,5,10,10,10,12}, 10));
    System.out.println(lowerBound(new int[]{1,4,5,10,10,10,12}, 10));
  }
}
