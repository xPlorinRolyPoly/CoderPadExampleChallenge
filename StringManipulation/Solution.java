import java.io.*;
import java.util.*;

class Solution {
  
  public static TreeMap<String, String> createData(String[] h, String[] v){
    TreeMap<String, String> m = new TreeMap<String, String>();
    for (int i=0; i<h.length; i++){
      m.put(h[i], v[i]);
    }
    return m;
  }
  
  public static void main(String[] args) {
    final String SAMPLE_CSV = "ACCOUNT_NUMBER,ACCOUNT_ID,DATE,SCORE,SCORE_1\n954332033,141310885,09/13/2020,92,84\n954332033,141310885,09/14/2020,74,83\n954332033,141310885,09/15/2020,94,94";
    
    String[] strs = SAMPLE_CSV.split("\n");
    String[] headers = strs[0].split(",");
    ArrayList<TreeMap<String, String>> arrayMap = new ArrayList<TreeMap<String, String>>();
    for (int i=1; i<strs.length; i++){
      String[] vals = strs[i].split(",");
      TreeMap<String, String> map = createData(headers, vals);
      arrayMap.add(map);
    }
    System.out.println(arrayMap);
    
  }
}
