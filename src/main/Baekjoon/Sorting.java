package main.Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

class Person {

  String name;
  int kor;
  int eng;
  int math;

  Person(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

}


class Sorting {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    ArrayList<Person> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String name = sc.next();
      int kor = sc.nextInt();
      int eng = sc.nextInt();
      int math = sc.nextInt();
      list.add(new Person(name, kor, eng, math));
    }

    list.sort((p1, p2) -> {
          if (p1.kor == p2.kor) {
            if (p1.eng == p2.eng) {
              if (p1.math == p2.math) {
                return p1.name.compareTo(p2.name); //수학 같다면 이름 순.
              }
              return p2.math - p1.math; //영어 같으면 수학 DESC
            }
            return p1.eng - p2.eng;  // 영어가 같지 않다면, 영어 ASC
          }
          return p2.kor - p1.kor;
        }
    );
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).name);
    }
  }
}
