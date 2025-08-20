package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/complex-number-multiplication/">复数乘法</a>
 */
public class ComplexNumberMultiply {
    public static String complexNumberMultiply(String number1, String number2) {
        var c = new Complex(number1);
        c.multiply(new Complex(number2));
        return c.toString();
    }

    private static class Complex {
        private int real;
        private int imaginary;

        public Complex(String s) {
            var index = s.indexOf('+');
            real = Integer.parseInt(s, 0, index, 10);
            imaginary = Integer.parseInt(s, index + 1, s.length() - 1, 10);
        }

        public void multiply(Complex other) {
            // (a + b * i)(c + d * i) = (ac - bd) + (bc + ad) * i
            var real = this.real * other.real - imaginary * other.imaginary;
            var imaginary = this.imaginary * other.real + this.real * other.imaginary;
            this.real = real;
            this.imaginary = imaginary;
        }

        @Override
        public String toString() {
            return String.valueOf(real) + '+' + imaginary + 'i';
        }
    }
}
