object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        /*
        0: not visited
        1: can Jump from here
        2: can't jump from here
        */
        var cache = new Array[Int](nums.length); 
        cache(nums.length-1) = 1;
        
        return canJumpFromPosition(0, nums, cache);
    }
    
    def canJumpFromPosition(posn: Int, nums: Array[Int], cache: Array[Int]): Boolean = {
        if (cache(posn) != 0)
            return cache(posn) == 1;
        
        var furthest_jump: Int = Math.min(posn + nums(posn), nums.length-1);
        
        for (i <- posn+1 to furthest_jump) 
            if (canJumpFromPosition(i, nums, cache)) {
                cache(posn) = 1;
                return true;
            }
        
        
        cache(posn) = 2;
        return false;
    }
}