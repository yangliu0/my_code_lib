package leetcode.$51_$100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/7/16
 */

// Restore IP Addresses
public class $93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIp(s, res, 0, "", 0);
        return res;
    }

    private void restoreIp(String ip, List<String> res, int index, String restored, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && index == ip.length()) {
            res.add(restored);
        }

        for (int i = 1; i < 4; i++) {
            if (index + i > ip.length()) {
                break;
            }
            String s = ip.substring(index, index + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            restoreIp(ip, res, index + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
