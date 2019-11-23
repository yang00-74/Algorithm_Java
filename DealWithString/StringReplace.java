
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StringReplace {

    public static void main(String[] args) {
        String s = "888,99897,98898";
        StringBuffer s1 = new StringBuffer(s);
        System.out.println(new StringReplace().replaceSpace(s1));
    }

    public String replaceSpace(StringBuffer s) {
        if (s == null) {
            return null;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                s.replace(i, i + 1, "%20");
            }
        }
        String s0 = s.toString();
        return s0;
    }


    class User {
        private Integer id;
        private String name;

        public User(String name, Integer id) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void testStream() {
        List<User> list = new ArrayList<User>(){};
        list.add(new User("cool",1));
        list.add(new User("Hello",1));

        AtomicReference<String> firstName = new AtomicReference<>();

        list.parallelStream()
                .filter(user -> 1 == user.getId())
                .forEach(user -> {firstName.set(user.getName());System.out.println("kkk");});
        String s = list.parallelStream()
                .filter(user -> 1 == user.getId())
                .map(User::getName)
                .findFirst().orElse("");

        System.out.println("User:"+ s);
    }

    public static List<Integer> getIntegerListFromString(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        String[] array = src.split(",");
        List<Integer> list = Arrays.asList(array).stream()
                .filter(s -> s.matches("^[1-9]\\d*$"))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        return list.size() != array.length ? null : list;
    }

    public static void testMap() {
        HashMap map = new HashMap();
        fillMap(map);
        System.out.println(isJsonValue(map,"09",Integer.class));
    }

    private static void fillMap(HashMap map){
        map.put("09", 7L);
        map.put("08","looop");
        map.put("07","looop");
        map.put("06","looop");
        throw  new RuntimeException("hhhh, error!");
    }

    public static <K extends Map, T> Boolean isJsonValue(K root, String key, Class<T> type) {
        return root.containsKey(key) && type.isInstance(root.get(key));
    }
}
