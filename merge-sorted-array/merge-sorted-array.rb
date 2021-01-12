# @param {Integer[]} nums1
# @param {Integer} m
# @param {Integer[]} nums2
# @param {Integer} n
# @return {Void} Do not return anything, modify nums1 in-place instead.
def merge(nums1, m, nums2, n)
    if nums2.length == 0
        return nums1
    end
    
    i, j , index = 0, 0, 0
    longArr = nums1.map(&:clone)
    intMax = 1 << 64 # 2^64 to represent Integer.MAX_VALUE
    
    for k in m..nums1.length-1
        longArr[k] = intMax
    end
    
    while index < nums1.length do
        if j >= n || longArr[i] < nums2[j]
            nums1[index] = longArr[i]
            i+=1
            
        else
            nums1[index] = nums2[j]
            j+=1
        end
        
        index+=1         
    end   
end
