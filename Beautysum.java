class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++){
             int freq[]= new int[26]; // for every ssubstring make a frequency array 
            for(int j=i;j<n;j++){
                char ch= s.charAt(j); 
                freq[ch-'a']++;  // update the frequency array for the particular substring 
                    int largest=Integer.MIN_VALUE; // find max and min freq
                    int smallest=Integer.MAX_VALUE;
                    for(int z=0;z<26;z++){
                        if(freq[z]>0){  // consider only if freq>0 
                        largest=Math.max(largest,freq[z]);
                        smallest=Math.min(smallest,freq[z]);
                        }
                    }
                    int beauty=largest-smallest;
                    sum+=beauty; 
                }
            }

        
        return sum;

        
    }

}