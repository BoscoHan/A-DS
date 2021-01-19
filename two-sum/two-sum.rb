# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    map = Hash.new
    
    nums.each_with_index { |val, index|
        if map.key? (target - val)
            return [map[target-val], index]
        end
        map[val] = index
    }
    
end
