package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/check-if-it-is-a-straight-line/">缀点成线</a>
 */
public class CheckStraightLine {
    /**
     * 直线一般式为Ax + By + C = 0<br>
     * 设有不重合的两点(x<sub>1</sub>, y<sub>1</sub>), (x<sub>2</sub>, y<sub>2</sub>)<br>
     * 当直线和x轴和y轴均不平行时，设直线方程为y = kx + b<br>
     * kx<sub>1</sub> + b = y<sub>1</sub>, kx<sub>2</sub> + b = y<sub>2</sub><br>
     * k = (y<sub>2</sub> - y<sub>1</sub>) / (x<sub>2</sub> - x<sub>1</sub>)<br>
     * b = y<sub>1</sub> - (y<sub>2</sub> - y<sub>1</sub>) * x<sub>1</sub> / (x<sub>2</sub> - x<sub>1</sub>)<br>
     * 此时：<br>
     * A = (y<sub>2</sub> - y<sub>1</sub>) / (x<sub>2</sub> - x<sub>1</sub>)<br>
     * B = -1<br>
     * C = y<sub>1</sub> - (y<sub>2</sub> - y<sub>1</sub>) * x<sub>1</sub> / (x<sub>2</sub> - x<sub>1</sub>)<br>
     * 两边同乘x<sub>2</sub> - x<sub>1</sub>，得<br>
     * A = y<sub>2</sub> - y<sub>1</sub><br>
     * B = x<sub>1</sub> - x<sub>2</sub><br>
     * C = y<sub>1</sub> * (x<sub>2</sub> - x<sub>1</sub>) - (y<sub>2</sub> - y<sub>1</sub>) * x<sub>1</sub><br>
     * &nbsp;&nbsp;&nbsp;= y<sub>1</sub> * x<sub>2</sub> - y<sub>1</sub> * x<sub>1</sub> - y<sub>2</sub> * x<sub>1</sub> + y<sub>1</sub> * x<sub>1</sub><br>
     * &nbsp;&nbsp;&nbsp;= y<sub>1</sub> * x<sub>2</sub> - y<sub>2</sub> * x<sub>1</sub><br>
     * 当直线平行x轴时，带入可得：A = 0, B = x<sub>1</sub> - x<sub>2</sub>, C = y<sub>1</sub> * (x<sub>2</sub> - x<sub>1</sub>)<br>
     * 两边同除x<sub>2</sub> - x<sub>1</sub>，得：A = 0, B = -1, C = y<sub>1</sub><br>
     * 即y = y<sub>1</sub><br>
     * 当直线平行y轴时，带入可得：A = y<sub>2</sub> - y<sub>1</sub>, B = 0, C = x<sub>1</sub> * (y<sub>1</sub> - y<sub>2</sub>)<br>
     * 两边同除y<sub>2</sub> - y<sub>1</sub>，得：A = 1, B = 0, C = -x<sub>1</sub><br>
     * 即x = x<sub>1</sub>
     *
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        var length = coordinates.length;
        if (length == 2) {
            return true;
        }
        var pt1 = coordinates[0];
        var pt2 = coordinates[1];

        var x1 = pt1[0];
        var y1 = pt1[1];
        var x2 = pt2[0];
        var y2 = pt2[1];

        var A = y2 - y1;
        var B = x1 - x2;
        var C = y1 * x2 - y2 * x1;
        for (var i = 2; i < length; i++) {
            var pt = coordinates[i];
            if (A * pt[0] + B * pt[1] + C != 0) {
                return false;
            }
        }
        return true;
    }
}
