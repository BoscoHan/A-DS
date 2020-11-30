class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        if (arr.size() == 0) 
            return false;
    
        return jump(arr, start);
    }
    
    bool jump(vector<int>& arr, int index) {
        if (index < 0 || index >= arr.size() || arr[index] < 0) //check if already visited
            return false;
        
        if (arr[index] == 0)
            return true;
        
        //mark as visited:
        arr[index] *= -1;
        
        return jump(arr, index-arr[index]) || jump(arr, index+arr[index]);    
    }
};
