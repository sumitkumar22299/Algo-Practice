class Solution {
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        int numsSize = nums.length;

        if(nums.length < 2){
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < numsSize ; i++){
            minValue = (minValue < nums[i]) ? minValue : nums[i];
            maxValue = (maxValue > nums[i]) ? maxValue : nums[i];
        }        

        int numberOfBuckets = numsSize-1;
        int bucketSize = (int)Math.ceil((double)(maxValue - minValue)/numberOfBuckets);
        int[] minValueBucket = new int[numberOfBuckets];
        Arrays.fill(minValueBucket, Integer.MAX_VALUE);
        int[] maxValueBucket = new int[numberOfBuckets];
        Arrays.fill(maxValueBucket, Integer.MIN_VALUE);

        for(int i =0 ; i <= numberOfBuckets ; i++){
            if(nums[i] == minValue || nums[i] == maxValue){
                continue;
            }
            int bucketIndex = (nums[i] - minValue)/(bucketSize);
            minValueBucket[bucketIndex] = (minValueBucket[bucketIndex] < nums[i]) ? minValueBucket[bucketIndex] : nums[i];
            maxValueBucket[bucketIndex] = (maxValueBucket[bucketIndex] > nums[i]) ? maxValueBucket[bucketIndex] : nums[i];
        }
        for(int i = 0 ; i < numberOfBuckets ; i++){
            if(maxValueBucket[i] == Integer.MIN_VALUE || minValueBucket[i] == Integer.MAX_VALUE){
                continue;
            }
            int currMin = minValueBucket[i];
            maxGap = Math.max(maxGap , currMin - minValue);
            minValue = maxValueBucket[i];
        }
        return (maxGap > (maxValue - minValue)) ? maxGap : (maxValue - minValue);
    }
}
