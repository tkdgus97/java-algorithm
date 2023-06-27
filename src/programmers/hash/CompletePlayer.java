package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * programmers - 완주하지 못한 선수(해시)
 */
public class CompletePlayer {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        //sort와 Loop를 이용한 해결법
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        int i = 0;
//        for (; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i])) {
//                break;
//            }
//        }
//        return participant[i];

        //Hash를 이용한 해결법
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion){
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for (String k: hashMap.keySet()) {
            if (hashMap.get(k) != 0) {
                answer = k;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] strArr = {"mislav", "stanko", "mislav", "ana", "ana"};
        String[] strArr2 = {"stanko", "ana", "mislav", "mislav"};

        System.out.println(solution(strArr, strArr2));
    }
}
