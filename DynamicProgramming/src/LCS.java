
public class LCS {
    public int getLongestCommonSubsequenceSize(String a, String b) {
        int[][] m = new int[2][b.length()+1];
        for(int i=1; i<=a.length(); i++) {
            for (int j=1; j<=b.length(); j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    m[1][j] = m[0][j-1] + 1;
                } else {
                    m[1][j] = Math.max(m[0][j], m[1][j-1]);
                }
            }
            for(int j=0; j<=b.length(); j++) {
                m[0][j] = m[1][j];
            }
        }
        return m[1][b.length()];
    }

    public String getLongestRepeatingSubsequenceSize(String a) {
        int[][] m = new int[a.length()+1][a.length()+1];
        StringBuilder str = new StringBuilder();
        for(int i=1; i<=a.length(); i++) {
            for(int j=1; j<=a.length(); j++) {
                if(i-1!=j-1 && a.charAt(i-1) == a.charAt(j-1)) {
                    m[i][j] = m[i-1][j-1] + 1;
                } else {
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
        }
        int i=a.length(), j=a.length();
        while(i>0 && j>0) {
            if(m[i][j] == m[i-1][j-1]+1) {
                str.append(a.charAt(i-1));
                i--;j--;
            } else {
                if(m[i][j]==m[i-1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.getLongestCommonSubsequenceSize("AMOL", "LOMA"));
        System.out.println(lcs.getLongestRepeatingSubsequenceSize("AMMool"));

    }
}
