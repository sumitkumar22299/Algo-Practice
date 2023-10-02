class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int low , high , cut1, cut2, l1 ,l2,r1,r2,medinapos;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        else{
            low = 0 ; 
            high  = m;
            medinapos = (m + n +1)/2;
            while(low <= high){
                cut1 = (low + high)>>1;
                cut2 = medinapos - cut1;
                l1 = (cut1 == 0) ? (Integer.MIN_VALUE) : (nums1[cut1 - 1]);
                l2 = (cut2 == 0) ? (Integer.MIN_VALUE) : (nums2[cut2 - 1]);
                r1 = (cut1 == m) ? (Integer.MAX_VALUE) : (nums1[cut1]);
                r2 = (cut2 == n) ?  (Integer.MAX_VALUE) : (nums2[cut2]);

                if(l1 <= r2 && l2 <= r1){
                    if(((m + n)%2) == 0){
                        return (double)(Math.max(l1, l2) + Math.min(r1,r2))/2;
                    }
                    else{
                        return (double)Math.max(l1, l2);
                    }
                }
                else if(l1 > r2){
                    high = cut1-1;
                }
                else{
                    low  = cut1 + 1;
                }
            }
        }
        return -1;

    }
}
