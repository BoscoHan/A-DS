class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        
        List<List<Integer>> list = new ArrayList();
        if (arr.length == 0) 
            return list;
        
        Arrays.sort(arr);
        
        for (int i = 1; i < arr.length; i++) {
            //if new diff found
            if (minDiff > Math.abs(arr[i] - arr[i-1])) {
                minDiff = Math.abs(arr[i] - arr[i-1]);
                list.clear();
            }
            if (minDiff == Math.abs(arr[i] - arr[i-1])) {
                list.add(new ArrayList(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        
        return list;
    }
}