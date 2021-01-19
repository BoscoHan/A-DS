# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def max_operations(nums, k)
    map = Hash.new { |map, key|  map[key] = 0 } #set map.getOrDefault(key, 0)
    ans = 0
    
    nums.each do |element|
        if map[k - element] > 0
            ans+=1
            map[k - element] -=1
        else
            map[element] += 1
        end
    end
​
    ans
end
