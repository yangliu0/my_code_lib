package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/8/18
 */
public class $165 {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            if (v1.compareTo(v2) != 0) {
                return v1.compareTo(v2);
            }
        }
        return 0;
    }
}
