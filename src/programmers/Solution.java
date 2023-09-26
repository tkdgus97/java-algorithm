package programmers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        return answer;
    }

    public static void main(String[] args) throws AWTException {
//        Solution M = new Solution();
//        M.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});

        Robot rb = new Robot();

        rb.delay(3000);

        for (int i = 0; i < 5; i++) {
            rb.keyPress(KeyEvent.VK_G);
            rb.keyRelease(KeyEvent.VK_G);
            rb.delay(1000);
        }
    }

}
