package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/add-digits/">各位相加</a>
 */
public class AddDigits {
    /**
     * 该算法用于计算数字的数根。设数字和为d，原数字为n，则：<br>
     * n=sum(0, n-1, a<sub>i</sub>×10<sup>i</sup>)<br>
     * &nbsp;&nbsp;=sum(0, n-1, a<sub>i</sub>×(10<sup>i</sup>-1+1))<br>
     * &nbsp;&nbsp;=sum(0, n-1, a<sub>i</sub>×(10<sup>i</sup>-1))
     * +sum(0, n-1, a<sub>i</sub>)<br>
     * &nbsp;&nbsp;=sum(0, n-1, a<sub>i</sub>×(10<sup>i</sup>-1))+d<br>
     * 显然a<sub>i</sub>×(10<sup>i</sup>-1)能被9整除，于是有n%9 = d%9，也就是x的。
     * 反复迭代直至x为一位数，即可求得x的数根。<br>
     * 于是有：<br>
     * 若n=0，则数根为0<br>
     * 若n不是9的倍数，则数根为n对9取余（<b>而非取模</b>）<br>
     * 若n是9的倍数，则数根为9。<br>
     * 即数根=(n-1)%9+1<br>
     * 注：sum表示求和符号<br>
     *
     * @param number 要计算的数字
     * @return 数字的数根
     */
    public static int addDigits(int number) {
        return (number - 1) % (10 /* radix */ - 1) + 1;
    }
}
