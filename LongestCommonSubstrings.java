public class LongestCommonSubstrings{
    public static int maxCommonstr(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int[][]LCSuf=new int[m+1][n+1];
        int res=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    LCSuf[i][j]=LCSuf[i-1][j-1]+1;
                    res=Math.max(res,LCSuf[i][j]);
                }else{
                    LCSuf[i][j]=0;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s1="abcdxyz";
        String s2="xyzabcd";
        System.out.println(maxCommonstr(s1,s2));
    }
}
