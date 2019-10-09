import java.util.Map;

/*
166. Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"


Summary

This is a straight forward coding problem but with a fair amount of details to get right.
Hints

    No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
    Try a long division on 49\dfrac{4}{9}94​, the repeating part is obvious. Now try 4333\dfrac{4}{333}3334​. Do you see a pattern?
    Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

Solution
Approach 1: Long Division

Intuition

The key insight here is to notice that once the remainder starts repeating, so does the divided result.

egin{array}{rll} 0.16 [-3pt] 6 \enclose{longdiv}{1.00}\kern-.2ex [-3pt] \underline{0\phantom{.00}} [-3pt] 1\phantom{.}0\phantom{0} && \hbox{⇐remainder=1\Leftarrow remainder=1⇐remainder=1, mark 1 as seen at position=0position=0position=0.} [-3pt] \underline{\phantom{0}6\phantom{0}} [-3pt] \phantom{0}40 && \hbox{⇐remainder=4\Leftarrow remainder=4⇐remainder=4, mark 4 as seen at position=1position=1position=1.} [-3pt] \underline{\phantom{0}36} [-3pt] \phantom{00}4 && \hbox{⇐remainder=4\Leftarrow remainder=4⇐remainder=4 was seen before at position=1position=1position=1, so the fractional part which is 16 starts repeating at position=1position=1position=1 ⇒\Rightarrow⇒ 1(6).} \end{array}

**Algorithm**

You will need a hash table that maps from the remainder to its position of the fractional part. Once you found a repeating remainder, you may enclose the reoccurring fractional part with parentheses by consulting the position from the table.

The remainder could be zero while doing the division. That means there is no repeating fractional part and you should stop right away.

Just like the question Divide Two Integers, be wary of edge cases such as negative fractions and nasty extreme case such as −2147483648−1\dfrac{-2147483648}{-1}−1−2147483648​.

Here are some good test cases:
Test case 	            Explanation
0/1 	            Numerator is zero.
1/0 	            Divisor is 0, should handle it by throwing an exception but here we ignore for simplicity sake.
2/1 	            Answer is a whole integer, should not contain the fractional part.
1/2 	            Answer is 0.5, no recurring decimal.
-1/2 	            One of the numerator or denominator is negative, fraction is negative.
-1/-2 	            Both numerator and denominator are negative, should result in positive fraction.
−2147483648/1 	Beware of overflow if you cast to positive.

*/
class FractionToRecurringDecimal {
    //模拟整个除法过程， ／ 记作结果， % 的结果*10 作为下一位结果的被除数
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // covert two input to long to prevent overflow
        long _numerator = Math.abs(Long.valueOf(numerator));
        long _denominator = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(_numerator / _denominator));
        long remainder = _numerator % _denominator;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");

        // map里是被除数 和 这个被除数 ／之后append在fraction的位置
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if (map.containsKey(remainder)){
                // 在循环开始的位置插入(
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                return fraction.toString();
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / _denominator));
            remainder %= _denominator;
        }
        return fraction.toString();
    }
}