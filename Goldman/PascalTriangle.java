class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) {
            return triangle;
        }
        List<Integer> initial = new ArrayList<>();
        initial.add(1);
        triangle.add(initial);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = triangle.get(triangle.size() - 1);
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int j = 1; j < numRows; j++) {
                line.add(line.get(line.size() - 1) + prev.get(j - 1));
            }
            triangle.add(line);
        }
        return triangle;
    }
}