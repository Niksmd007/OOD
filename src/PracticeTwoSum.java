public class PracticeTwoSum {
    int [] findTwoIndex(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int currentSum=nums[start]+nums[end];
            if(currentSum==target){
                return new int[] {start+1,end+1};
            }else if(currentSum>target){
                end--;
            }else{
                start++;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        PracticeTwoSum solution =new PracticeTwoSum();
        int[] nums={2,7,11,15};
        int target=9;
        int[] index =solution.findTwoIndex(nums,target);
        System.out.println("first index: "+index[0]+" second index: "+index[1]);
    }
}

