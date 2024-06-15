import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void commonSubstring(List<String> a, List<String> b) {
        for (int i = 0; i < a.size(); i++)
            if (hasCommonSubstring(a.get(i), b.get(i))) System.out.println("YES");
            else System.out.println("NO");
    }

    private static boolean hasCommonSubstring(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (char c : str1.toCharArray()) set.add(c);
        for (char c : str2.toCharArray()) if (set.contains(c)) return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> a = List.of("ab", "cd", "ef");
        List<String> b = List.of("af", "ee", "ef");
        commonSubstring(a, b);
    }
}
