class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<>();
        line.add(1);
        if (rowIndex == 0) {
            return line;
        }
        line.add(1);
        if (rowIndex == 1) {
            return line;
        }
        int row = 2;
        while (row <= rowIndex) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    curr.add(1);
                } else {
                    curr.add(line.get(i - 1) + line.get(i));
                }
            }
            curr.add(1);
            line = new ArrayList<>(curr);
            row++;
        }
        return line;
    }
}