package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/21
 */

// BitMap的实现
public class BitMap {
    // 获取byte数组的index
    public static int getIndex(int num) {
        return num >> 3;
    }

    // 获取num在index中的bit位
    public static int getPosition(int num) {
        return num & 0x07;
    }

    // 将num所在位置为1
    public static void add(byte[] bits, int num) {
        bits[getIndex(num)] |= 1 << getPosition(num);
    }

    // 判断某一个数是否存在
    public static boolean contains(byte[] bits, int num) {
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }

    // 清空某个数字
    public static void clear(byte[] bits, int num) {
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }

    public static void main(String[] args) {
        byte[] bits = new byte[10];
        add(bits, 1);
        add(bits, 2);
        add(bits, 3);
        System.out.println(contains(bits, 2));
        clear(bits, 2);
        System.out.println(contains(bits, 2));
    }
}
