class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int i = 1;
        while(i < nums.length && nums[i] == nums[i-1]){
            i++;
        }

        boolean flag = false;
        if(i < nums.length && nums[i] > nums[i-1]){
            flag = true;
        }


        for(; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            } 
            if(flag == true){
                if(nums[i] < nums[i-1]){
                    return false;
                }
            } else if(flag == false){
                if(nums[i] > nums[i-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
