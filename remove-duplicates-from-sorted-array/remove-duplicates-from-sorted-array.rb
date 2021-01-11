# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(nums)
    if nums.length == 0
        return 0
    end
    
    i = 0
    j = 1
    while j <= nums.length-1 do
        if nums[j] == nums[i]
            nums.delete_at(j)
        elsif nums[j] != nums[i]
            i+=1
            j+=1
        end
    
    end
    return j
end
