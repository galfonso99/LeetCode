// This is an EASY
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1, 1);
        if (rowIndex == 2) return List.of(1, 2, 1);

        Integer[] currRow = new Integer[rowIndex + 1];
        currRow[0] = 1; currRow[1] = 2; currRow[2] = 1;
        int size = 3;
        for (int i = 3; i <= rowIndex; i++) {
            for (int j = size - 1; j > 0; j--) {
                currRow[j] = currRow[j] + currRow[j-1];
            }
            currRow[size] = 1;
            size++;
        }
        return Arrays.asList(currRow);
    }
}
