# @param {Integer} s
# @param {Integer[]} nums
# @return {Integer}
def min_sub_array_len(s, nums)
    
    i, j = 0, 0
    sum, minLength = 0, nums.length+1
    
    while j < nums.length do
        sum += nums[j]
        j+=1
        
        while sum >= s do
            minLength = [minLength, j-i].min
            sum -= nums[i]
            i += 1
        end
    end 
        
    return minLength == nums.length+1 ? 0: minLength
    
end
