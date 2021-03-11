package in.shahhardik;

public class LongestCommonSequence {
    public static void main(String args[]) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        int lcsNumber = lcs(x.toCharArray(), y.toCharArray(), x.length() , y.length());
        System.out.println("LCS = "+lcsNumber);

        int lcsNumberMatrix = lcsMatrix(x.toCharArray(), y.toCharArray(), x.length() , y.length());
        System.out.println("LCS = "+lcsNumberMatrix);
    }

    static int lcsMatrix(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m+1][n+1];
        for(int i = 0 ; i <= m; i++) {
            for (int j=0; j <= n; j++) {
                if(i==0 || j==0) {
                    L[i][j] = 0;
                }
                else if (X[i-1] == Y[j-1]) {
                    L[i][j] = L[i-1][j-1] + 1;
                }
                else
                    L[i][j] = max(L[i-1][j],L[i][j-1]);
            }
        }
        for(int a=0;a<=m;a++) {
            for(int b=0;b<=n;b++) {
                System.out.print(" | " + L[a][b] + " | ");
            }
            System.out.println("");
        }
    return L[m][n];
    }

    static int lcs(char[] X, char[] Y, int m, int n) {
        if(m ==0 || n == 0) return 0;
        if(X[m-1] == Y[n-1])
            return 1 + lcs(X,Y,m-1,n-1);
        else
            return max(lcs(X,Y,m-1,n) , lcs(X,Y,m,n-1));
    }

    static int max(int x, int y) {
        return ((x > y) ? x : y);
    }
}
