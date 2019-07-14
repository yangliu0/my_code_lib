package sword_to_offer;

/**
 * Created by Yang Liu on 2019/7/14
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个字符串的集合，格式如：{aaa bbb ccc}， {bbb ddd}，{eee fff}，{ggg}，{ddd hhh}要求将其中交集不为空的集合合并，
 * 要求合并完成后的集合之间无交集，例如上例应输出{aaa bbb ccc ddd hhh}，{eee fff}， {ggg}。
 */
public class DisJointSetProblem {
    private int SIZE = 7;
    private int[] father;
    private static List<Set<String>> resultList = new ArrayList<>();


    public static void main(String[] args) {
        String[] str0 = {"aaa", "bbb", "ccc",};
        String[] str1 = {"bbb", "ddd",};
        String[] str2 = {"eee", "fff",};
        String[] str3 = {"ggg",};
        String[] str4 = {"ddd", "hhh",};
        String[] str5 = {"xx", "yy",};
        String[] str6 = {"zz", "yy",};
        String[][] strs = {str0, str1, str2, str3, str4, str5, str6};

        // 将strs转为List<Set>
        for (String[] str : strs) {
            Set<String> set = new HashSet<>(Arrays.asList(str));
            resultList.add(set);
        }
        DisJointSetProblem solution = new DisJointSetProblem();
        solution.disJoin(strs);
    }

    // 获取hashmap
    // key为string，value为string出现的集合index
    public void disJoin(String[][] strs) {
        if (strs == null || strs.length < 2) {
            return;
        }

        father = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            father[i] = i;
        }
        // 获取hashmap
        Map<String, List<Integer>> map = storeInHashMap(strs);
        // 并查集合并
        union(map);
    }

    // 每个string出现的集合index
    public Map<String, List<Integer>> storeInHashMap(String[][] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            for (String str : strs[i]) {
                if (!map.containsKey(str)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(str, list);
                } else {
                    map.get(str).add(i);
                }
            }
        }

        return map;
    }

    // 并查集合并
    public void union(Map<String, List<Integer>> map) {
        Iterator<Map.Entry<String, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<Integer>> entry = it.next();
            List<Integer> value = entry.getValue();
            unionHelp(value);
        }
        // 合并两个set
        for (int i = 0; i < SIZE; i++) {
            if (i != father[i]) {
                Set<String> dest = resultList.get(father[i]);
                Set<String> source = resultList.get(i);
                dest.addAll(source);
            }
        }

        // 当B集合加入到A集合后，清空B
        for (int i = 0; i < SIZE; i++) {
            if (i != father[i]) {
                resultList.get(i).clear();
            }
        }

        System.out.println("合并后： " + resultList);
    }

    public void unionHelp(List<Integer> list) {
        // list[0]最小
        int minFather = getFather(list.get(0));
        for (int i = 0, size = list.size(); i < size; i++) {
            // 合并两个集合到index小的集合
            unionHelp(list.get(0), list.get(i));
        }
    }

    // 路径压缩
    public int getFather(int x) {
        while (x != father[x]) {
            x = father[x];
        }
        return x;
    }

    public void unionHelp(int x, int y) {
        if (father[x] != father[y]) {
            int fx = getFather(x);
            int fy = getFather(y);
            // 合并两个集合到index小的集合
            if (fx < fy) {
                father[y] = fx;
            } else {
                father[x] = fy;
            }
        }
    }
}
