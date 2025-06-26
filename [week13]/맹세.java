package KB_ITL;

import java.io.*;
import java.util.*;

public class w13_맹세 {
    // 주기율표 심볼(소문자) 집합
    static final String[] ELEMENTS = {
        "h","he","li","be","b","c","n","o","f","ne",
        "na","mg","al","si","p","s","cl","ar","k","ca",
        "sc","ti","v","cr","mn","fe","co","ni","cu","zn",
        "ga","ge","as","se","br","kr","rb","sr","y","zr",
        "nb","mo","tc","ru","rh","pd","ag","cd","in","sn",
        "sb","te","i","xe","cs","ba",
        "la","ce","pr","nd","pm","sm","eu","gd","tb","dy","ho","er","tm","yb","lu",
        "hf","ta","w","re","os","ir","pt","au","hg","tl","pb","bi","po","at","rn",
        "fr","ra",
        "ac","th","pa","u","np","pu","am","cm","bk","cf","es","fm","md","no","lr",
        "rf","db","sg","bh","hs","mt","ds","rg","cn","fl","lv"
    };
    static final Set<String> SYMBOLS = new HashSet<>(Arrays.asList(ELEMENTS));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String str = bf.readLine().trim().toLowerCase();  
            sb.append(canSpell(str) ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    // 문자열이 주기율표 심볼로 분해 가능한지 DP로 확인
    static boolean canSpell(String str) {
        int len = str.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (!dp[i]) continue;
            // 1글자 심볼 체크
            if (SYMBOLS.contains(str.substring(i, i + 1))) {
                dp[i + 1] = true;
            }
            // 2글자 심볼 체크
            if (i + 2 <= len && SYMBOLS.contains(str.substring(i, i + 2))) {
                dp[i + 2] = true;
            }
        }
        return dp[len];
    }
}
