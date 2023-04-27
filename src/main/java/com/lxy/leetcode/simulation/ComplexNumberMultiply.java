package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/complex-number-multiplication/">复数乘法</a>
 */
public class ComplexNumberMultiply {
    private static class Complex {
        private int real;
        private int imaginary;

        public Complex(String s) {
            int index = s.indexOf('+');
            real = Integer.parseInt(s, 0, index, 10);
            imaginary = Integer.parseInt(s, index + 1, s.length() - 1, 10);
        }

        public void multiply(Complex other) {
            // (a + b * i)(c + d * i) = (ac - bd) + (bc + ad) * i
            int real = this.real * other.real - imaginary * other.imaginary;
            int imaginary = this.imaginary * other.real + this.real * other.imaginary;
            this.real = real;
            this.imaginary = imaginary;
        }

        @SuppressWarnings("StringBufferReplaceableByString")
        @Override
        public String toString() {
            return new StringBuilder()
                    .append(real).append('+')
                    .append(imaginary).append('i')
                    .toString();
        }
    }

    public static String complexNumberMultiply(String number1, String number2) {
        Complex c = new Complex(number1);
        c.multiply(new Complex(number2));
        return c.toString();
    }
}
