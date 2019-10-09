class FindAllPrimeFactors {
    public List<Integer> findAll(int number) {
        List<Integer> res = new ArrayList<>();
        // for 12: 2 * 2 * 3, number 出这个while循环的时候为3
        while( number % 2 == 0) {
            res.add(2);
            number /= 2;
        }

        // // for 12: 2 * 2 * 3, 3 > sqrt(3),它是不会进这个循环的
        for (int i = 3; i <= sqrt(number); i = i + 2) {
            while(number % i == 0) {
                res.add(i);
                number /= i;
            }
        }

        // 处理剩下的数是一个大于2的prime numner
        if (number > 2) {
            res.add(number);
        }
        return res;
    }
}