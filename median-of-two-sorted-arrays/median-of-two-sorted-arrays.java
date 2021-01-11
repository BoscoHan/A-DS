class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0;
        int index = 0;
        
        while (i < nums1.length && j < nums2.length && index < merged.length) {
            if (nums1[i] < nums2[j]) {
                merged[index] = nums1[i++];
            } else {
                merged[index] = nums2[j++];
            }
            index++;
        }
        
        while (i < nums1.length) {
            merged[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            merged[index++] = nums2[j++];
        }
        
        int len = merged.length;
        if (len % 2 == 1) 
            return merged[len/2];
        
        int midLeft = merged[len/2 -1];
        int midRight = merged[len/2];
​
        return (midLeft + midRight) /2.0;
    }
}
