package main.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 2시간 소요함.
 */
class GridSearch {

  /*
   * Complete the 'gridSearch' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY G
   *  2. STRING_ARRAY P
   */


  public static void main(String[] args) {
    GridSearch T = new GridSearch();
    List<String> list = Arrays.asList(
        new String[]{"7283455864", "6731158619", "8988242643", "3830589324",
            "2229505813",
            "5633845374",
            "6473530293",
            "7053106601",
            "0834282956",
            "4607924137"});

    List<String> list2 = Arrays.asList(
        new String[]{
            "7652157548860692421022503",
            "9283597467877865303553675",
            "4160389485250089289309493",
            "2583470721457150497569300",
            "3220130778636571709490905",
            "3588873017660047694725749",
            "9288991387848870159567061",
            "4840101673383478700737237",
            "8430916536880190158229898",
            "8986106490042260460547150",
            "2591460395957631878779378",
            "1816190871689680423501920",
            "0704047294563387014281341",
            "8544774664056811258209321",
            "9609294756392563447060526",
            "0170173859593369054590795",
            "6088985673796975810221577",
            "7738800757919472437622349",
            "5474120045253009653348388",
            "3930491401877849249410013",
            "1486477041403746396925337",
            "2955579022827592919878713",
            "2625547961868100985291514",
            "3673299809851325174555652",
            "4533398973801647859680907"
        }


    );

    List<String> target = Arrays.asList(new String[]{"9505", "3845", "3530"});
    List<String> target2 = Arrays.asList(new String[]{"5250", "1457", "8636", "7660", "7848"});
//    System.out.println(T.gridSearch(list, target));
    System.out.println(T.gridSearch(list2, target2));

  }


  public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
    // G.size() == R, G[0].length() == C
    // P.size() == r, P[0].length() == c

    int cnt = 0;
    String answer = "NO"; //DEFAULT IS NO;

    //Find where the first string's location of target.
    for (int i = 0; i < G.size(); i++) {
      String s = G.get(i);
      int pLen = P.get(0).length();
      int pLoc = 0;
      String c = P.get(pLoc);
      //nothing was found yet.
      //find the first edge (first String's location - left & right )
      if (cnt == 0 && s.contains(c)) {
        cnt++;
        pLoc++;
        int L = s.indexOf(c);
        //lastIndexOf == the index starting from right; s.length()-R-1. Haven't -1. as it is substring and right edge should be right+1
        int R = L + pLen;
        if (P.size() == cnt) {
          answer = "YES";
          return answer;
        }
        //we need to find first matching line so that we can narrow down the search range with L & R
        for (int k = i + 1; k <= i + P.size() -1 ; k++) {
          //search the P's nextLine;
          String x = G.get(k);
          //search the G's nextLine;
          c = P.get(pLoc);
          if (x.substring(L, R).equals(c)) {
            cnt++;
            pLoc++;
            if (P.size() == cnt) {
              answer = "YES";
              return answer;
            }
          } else {
            break;
          }

        }

      }
    }
    return answer;
  }

}