package programmers.hash;


import java.util.HashMap;

public class Pokemon {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        //1. 키 값
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 1) + 1);
        }

        for (String k : clothesMap.keySet()) {
            answer *= clothesMap.get(k);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
    }
}
