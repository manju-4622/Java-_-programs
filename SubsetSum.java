import java.util.Arrays;
public class SubsetSum{
    public static boolean isSubsetSum(int[] arr,int n, int target){
        if(n==0){
            return false;
        }
        if(target==0){
            return true;
        }
        if(arr[n-1]>target){
            return isSubsetSum(arr,n-1,target);
        }
        return isSubsetSum(arr,n-1,target)|| isSubsetSum(arr,n-1,target-arr[n-1]);
    }
    public static void main(String[] args){
        int[] arr={3,34,4,12,5,2};
        int target=9;
        int n=arr.length;
        boolean result=isSubsetSum(arr,n,target);
        System.out.println("Subset with given sum exists:"+result);
    }

}