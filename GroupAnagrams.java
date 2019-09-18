import java.util.Collection;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        String[] strings = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            strings[i] = String.valueOf(cs);
            System.out.println(String.valueOf(cs));
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String pattern = strings[i];
            if (map.containsKey(pattern)) {
                map.get(pattern).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(pattern, list);
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}