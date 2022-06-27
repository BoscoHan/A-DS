class Solution {
    public class Pair {
        int num;
        int index;
        
        public Pair(int n, int idx) {
            num = n;
            index = idx;
        }
    }
    
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.num - b.num);
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));

            if (pq.size() > k) 
                pq.poll();
        }
        
        Set<Integer> idxSet = new HashSet();
        while (!pq.isEmpty())
            idxSet.add(pq.poll().index);
        
        
        int[] ans = new int[k];
        int j = 0;
                
        for (int i = 0; i < nums.length; i++) {
            if (idxSet.contains(i))
                ans[j++] = nums[i];
        }
        
        return ans;
    }
}
