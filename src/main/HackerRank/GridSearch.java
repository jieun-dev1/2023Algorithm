package main.HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

/**
 * 2시간 소요함.
 * 참고 코드: https://pink-rabbit.tistory.com/5
 */
class Result {

  /*
   * Complete the 'gridSearch' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY G
   *  2. STRING_ARRAY P
   */

  public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
    // G.size() == R, G[0].length() == C
    // P.size() == r, P[0].length() == c
    String answer = "NO"; //DEFAULT IS NO;

    for (int i = 0; i <= G.size() - P.size(); i++) {
      if (G.get(i).indexOf(P.get(0)) > -1) {
        //k will move G.column - P.column
        //substring(int begin Index) == substring(begin index, end of the string)
        for (int k = 0; k <= G.get(i).length() - P.get(0).length(); k++) {
          int chk = G.get(i).substring(k).indexOf(P.get(0));
          //when k==0 & if chk == -1, the string does not include the P.get(0) at all.
          //when k ==0 & chk != -1, string includes P.get(0) somewhere.
          //Therefore, needs to search the next Line
          if (chk == -1) {
            break;
          } else {
            int cnt = 0;
            //search the range of P size in G.
            //will exit this loop and increase k if !GStr.equals
            for (int j = 0; j < P.size(); j++) {
              String Gstr = G.get(i + j).substring(k, k + P.get(j).length());
              if (Gstr.equals(P.get(j))) {
                cnt++;
              }
            }
            if (cnt == P.size()) {
              answer = "YES";
              return answer;
            }

          }
        }
      }
    }
    return answer;
  }


  public static void main(String[] args) {
    Result T = new Result();
    List<String> list = Arrays.asList(
        new String[]{"7283455864", "6731158619", "8988242643", "3830589324",
            "2229505813",
            "5633845374",
            "6473530293",
            "7053106601",
            "0834282956",
            "4607924137"});

    List<String> target = Arrays.asList(new String[]{"9505", "3845", "3530"});
    System.out.println(T.gridSearch(list, target));
  }
}

class Solution {
//  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(("C:\\Users\\USER\\Desktop\\develop\\2023JavaAlgorithm\\test\\answer.txt")));
//
//    int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//    IntStream.range(0, t).forEach(tItr -> {
//      try {
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int R = Integer.parseInt(firstMultipleInput[0]);
//
//        int C = Integer.parseInt(firstMultipleInput[1]);
//
//        List<String> G = IntStream.range(0, R).mapToObj(i -> {
//              try {
//                return bufferedReader.readLine();
//              } catch (IOException ex) {
//                throw new RuntimeException(ex);
//              }
//            })
//            .collect(toList());
//
//        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int r = Integer.parseInt(secondMultipleInput[0]);
//
//        int c = Integer.parseInt(secondMultipleInput[1]);
//
//        List<String> P = IntStream.range(0, r).mapToObj(i -> {
//              try {
//                return bufferedReader.readLine();
//              } catch (IOException ex) {
//                throw new RuntimeException(ex);
//              }
//            })
//            .collect(toList());
//
//        String result = Result.gridSearch(G, P);
//        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//      } catch (IOException ex) {
//        throw new RuntimeException(ex);
//      }
//    });
//
//    bufferedReader.close();
//    bufferedWriter.close();
//  }
}
