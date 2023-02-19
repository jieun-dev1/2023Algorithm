package main.DataStructure;

/**
 * 참고: 이것이 코딩 테스트다.
 */
public class QuickSort {

  public static void quickSort(int[]arr, int start, int end){
    //퀵소트의 종료 조건: 리스트 분할해서 정렬하는 데, 이때 리스트의 원소가 한 개인 경우
    if(start>=end) return; //+start<end일 때만, 아래 로직 수행 가능.
    //호어 정렬: 리스트의 첫 번째 데이터를 피봇으로 설정
    int pivot = start;
    int left = start+1;
    int right = end;
    while(left<=right) {
      //피봇보다 큰 데이터를 찾을 때까지 반복
      while(left<=end&& arr[left]<=arr[pivot]) left++;
      //피봇보다 작은 데이터를 찾을 때까지 반복
      while(right> start && arr[right]>=arr[pivot]) right--; //right>start 를 넣어주지 않을 경우, right이 -1을 가리키는 등 리스트 범위 넘어갈 수 있음.

      //엇갈렸다면, 작은 데이터와 피봇을 교체
      if(left>right){
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
      }
      //엇갈리지 않았다면, 작은 데이터와 큰 데이터를 교체한다.
      else {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
    }
      //분할 이후, 각 왼쪽/오른쪽 분할에서 정렬 수행
    quickSort(arr, start, right-1);
    quickSort(arr, right+1, end);
  }

  public static void main(String[] args) {
    int n = 10;
    int[] arr = {7,5,9,0,3,1,6,2,4,8};
    quickSort(arr, 0, n-1);
    for(int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
