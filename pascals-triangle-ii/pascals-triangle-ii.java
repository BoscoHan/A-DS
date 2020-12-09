class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList();
        if (rowIndex == 0) 
            return Collections.singletonList(1);
        
        triangle.add(new ArrayList());      
        triangle.get(0).add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            
            List<Integer> currList = new ArrayList();
            
            currList.add(1);            
            for (int j = 1; j < i; j++) {
                currList.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            currList.add(1);
            triangle.add(currList);
        }
        
        return triangle.get(rowIndex);
    }
}
