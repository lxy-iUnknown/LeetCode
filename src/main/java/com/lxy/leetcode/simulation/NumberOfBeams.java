package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/number-of-laser-beams-in-a-bank/">银行中的激光束数量</a>
 */
public class NumberOfBeams {

    private static class DeviceInfo {
        private int row;
        private int deviceCount;
    }

    private static int deviceCount(String bankRow) {
        int count = 0;
        for (int i = 0; i < bankRow.length(); i++) {
            // '0' = 48 = 0b110000
            // '1' = 49 = 0b110001
            count += bankRow.charAt(i) & 1;
        }
        return count;
    }

    private static void nextDeviceInfo(String[] bank, int row, DeviceInfo info) {
        int deviceCount = 0;
        while (row < bank.length && (deviceCount = deviceCount(bank[row])) == 0) {
            row++;
        }
        info.row = row;
        info.deviceCount = deviceCount;
    }

    public static int numberOfBeams(String[] bank) {
        int count = 0;
        DeviceInfo info = new DeviceInfo();
        nextDeviceInfo(bank, 0, info);
        while (info.row < bank.length) {
            int oldDeviceCount = info.deviceCount;
            nextDeviceInfo(bank, info.row + 1, info);
            count += info.deviceCount * oldDeviceCount;
        }
        return count;
    }

    public static int numberOfBeamsSimplified(String[] bank) {
        // 上一个不全为0的行的安全设备个数
        int last = 0;
        int result = 0;
        for (String line : bank) {
            // 当前行的安全设备个数
            int count = deviceCount(line);
            if (count != 0) {
                // 不全为0则更新
                result += last * count;
                last = count;
            }
        }
        return result;
    }
}
