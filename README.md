Onsite:
第一轮：三哥加国人哥：问简历，然后利口 爸气留 寺尔 幺灵幺
第二轮：三哥 利口 伞伞 伞尔尔变种
第三轮：白人哥加国人小姐姐 一道很简单的b‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌inary search 一道很简单的DP  利口 漆爸  还有一道system design，应该是一个他们真的在用的系统，听不太懂需求是什么
第四轮：纯BQ聊天


（1）纽约的两个中国人面的bq， 狂问简历和工作经验

（2）LC 4 median of two sorted array

(3) design ticketmaster, 问的特别细， 从输入网址后浏览器的行为开始问起，到api和数据库的设计，最后时间来不及没有把系统设计说完

第一个题是find stepping numbers, 第二题就是best time buy and sell stock。

，development life cycle, 然后debug的一个基本流程思路，以及debugger具体功能。加上一些简历上的东西。

how to scale


昂赛第一轮 java基础知识 queue，linkedlist基本操作，trie tree变种题
昂赛第二轮 DAG最短路径 dijkstra，质数分解，利口儿舅无‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌
昂赛第三轮 讨论如何做test以及情景案例
昂赛第四轮 设计文件传输系统
昂赛第五轮 纯bq

1.简历细节问题，解释(两个最经典cache 算法中的一个，简单的那个)，找出二叉的第某个元素。
2.简历细节问题，给一个字符序列，它重新定义了英文字母的顺序，给一个字符串列表，判断根据重新定义的字符顺序，列表是否排好序。bipartite 问题。
3.简历细节问题，问了许多synchronized database 问题，以及如何保持MongoDB的consistency，尤其有读写冲突的时候，跪妥妥的
4.Singleton class ， synchronized block 问题，can static method be synchronized method？ 找出array中 sub array加起来等于k的个数
5.bq hr 面，问什么离开现在公司，如何做选择数据库种类的决定，解释流程，被告知需要和队友商量，凉凉。。
6.还有一轮hr面，但是被告知跪了。。

************************


https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=539558&highlight=goldman%2Bsach%2B%B5%E7%C3%E6

分数以array形式表现，比如 [[1, 2], [‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌1, 3],[5, 6]], 就是要写个函数能计算1/2 + 1/3 = 5/6。解法参考 https://www.geeksforgeeks.org/program-to-add-two-fractions/
第二题很简单，reverse string，如果用python非常简单return str[::-1]
第三题有一个array的字母，每个字母都有weight，比如 [{a:3}, {b:9}, {c:11}, {d:2}...]，如何用最少的字母去代表一个数字。这个就是coin sum的问题，解法参考 https://www.geeksforgeeks.org/fi ... that-make-a-change/


https://leetcode.com/discuss/interview-question/356874/Goldman-Sachs-or-Phone-Screen-2019-or-Shortest-Path
https://leetcode.com/playground/VRYn8NZw

https://leetcode.com/discuss/interview-question/374394/Goldman-Sachs-or-Coderpad-or-Experienced-Hire-or-2019


https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=539558&highlight=goldman%2Bsach%2B%B5%E7%C3%E6

分数以array形式表现，比如 [[1, 2], [‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌1, 3],[5, 6]], 就是要写个函数能计算1/2 + 1/3 = 5/6。解法参考 https://www.geeksforgeeks.org/program-to-add-two-fractions/
第二题很简单，reverse string，如果用python非常简单return str[::-1]
第三题有一个array的字母，每个字母都有weight，比如 [{a:3}, {b:9}, {c:11}, {d:2}...]，如何用最少的字母去代表一个数字。这个就是coin sum的问题，解法参考 https://www.geeksforgeeks.org/fi ... that-make-a-change/


done: 第一题：给一个全为正数的array，找出sum是某个数的最短的subarray。
done: 第二题：给一个整数，找出此整数的所有prime factor，例如16，返回2，2，2，2

done: 第一题简单找到“abbbc”里最长的重复substring，就是"bbb”，写的时候index错了，debug了一段时间。
Done: 第二题就是面经了，LC 166。全程我讲也没啥回应，可能因为是一面会就行了吧。不隐藏了，求米就是了~


第一题：给一个，一个string letters，dictionary dict(dictionary是一个他自己写的class，但其实就是个string[])
让从dict中找最长的，所有字母都在letters的word,如果有多个word,就一起返回，letters中的每个char可以用多次
返回的是一个set


/* Problem Name is &&& Longest Uniform Substring &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
* Instructions to candidate.
*  1) Run this code in the REPL to observe its behaviour. The
*     execution entry point is main().
*  2) Your task is to implement the following method ('longestUniformSubstring')
*  
*  This method should return an integer array with two elements that correctly identifies the location of the longest
*  uniform substring within the input string. The first element of the array should be the starting index of the longest
*  substring and the second element should be the length.
*  
*  e.g.
*      
*      for the input: "abbbccda" the longest uniform substring is "bbb"
*abbbccda
*s
* f
*int[start index, lenght]
(which starts at index 1 and is 3 characters long).
*
*  3) If time permits, add some additional test cases.
*/

import java.util.*;

public class Solution {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    int longestStart = -1;
    int longestLength = 0;

    // todo: implement the longestUniformSubstring logic
    return new int[]{ longestStart, longestLength };
  }

  public static void main(String[] args) {
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 5});
    // todo: implement more tests, please
    // feel free to make testing more elegant

    boolean pass = true;
    for(Map.‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("All tests pass!");
    } else {
      System.out.println("At least one failure! :( ");
    }
  }
}


2面一共问了两道题，总体还是很简单的，第一道算法，第二道系统设计

第一道算法题比较简单，题目是问给一个二叉树，找到一个二叉树中最短的路径。我用的是递归，然后维护一个全局的变量来存储最短路径。

第二道系统设计是设计一个类似于dropbox的系统，能够让用户上传，浏览，下载文件。以下是我的设计

先讨论了一下系统的throughput和output，做了一些假设，然后做了一个简单的系统的设计
client => front-end server => load balancer => back-end => load balancer => file system server

完了之后面试官‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌‍‌问，如果用户上传一个5gb的文件，系统应该怎么设计？然后我就说为了性能的考虑，将文件在前端进行拆分，然后在后端重组。这个可以灵活回答。

希望对大家有帮助！ 求积分。