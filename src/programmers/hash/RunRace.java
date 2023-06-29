package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RunRace {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
//
//
//        List<String> li = new ArrayList<>(Arrays.asList(players));
//
//        for (int i = 0; i < callings.length; i++) {
//            int now = li.indexOf(callings[i]);
//            Collections.swap(li, now, now-1);
//        }
//
//        return li.toArray(answer);

//        HashMap<String, Integer> rank = new HashMap<>();
//        HashMap<String, Integer> originRank = new HashMap<>();
//
//        for (int i = 0; i < players.length; i++) {
//            rank.put(players[i], i);
//            originRank.put(players[i], i);
//        }
//
//        for (String c : callings) {
//            int now = rank.get(c);
//            rank.put(c, now - 1);
//        }
//
//        for (String s : rank.keySet()) {
//            if (!rank.get(s).equals(originRank.get(s))) {
//                String tmp = players[rank.get(s)];
//                players[rank.get(s)] = s;
//                players[originRank.get(s)] = tmp;
//            }
//        }
//
//        System.out.println("===" + players);

        HashMap<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String c: callings) {
            int oRank = rank.get(c);

            String fPlayer = players[oRank-1];
            int fRank = rank.get(fPlayer);

            players[fRank] = c;
            players[oRank] = fPlayer;

            rank.put(c, fRank);
            rank.put(fPlayer, oRank);
        }

        return players;
    }

    public static void main(String[] args) {

    }

}
