class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList();

        for (int i = 1; i < 9; i++) {
            //try starting with each number first
            //eg: 1, 12, 123, 1234, 12345...
            // 2, 23, 234, 2345 ...
            // 3, 34, 345, 3456 ...
            generateNext(i, low, high, list);
        }
        
        Collections.sort(list);
        return list;
    }
    
    private void generateNext(int curr, int low, int high, List<Integer> list) {
        if (curr >= low && curr <= high) {
            list.add(curr);
        }
        
        int lastDigit = curr % 10;
        int nextNum = curr * 10 + lastDigit + 1;
        
        if (nextNum <= high && lastDigit < 9)
            generateNext(nextNum, low, high, list);
        
    }
}