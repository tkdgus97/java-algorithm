package programmers.lv1;


public class CardBundle {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int c1 = cards1.length;
        int c2 = cards2.length;
        int n1 = 0;
        int n2 = 0;

        for (int i = 0; i < goal.length; i++) {
            if (n1 < c1 && cards1[n1].equals(goal[i])) {
                n1++;
                continue;
            } else if (n2 < c2 && cards2[n2].equals(goal[i])) {
                n2++;
                continue;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CardBundle M = new CardBundle();

        M.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
    }
}
