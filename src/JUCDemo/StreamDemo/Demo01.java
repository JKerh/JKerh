package JUCDemo.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo01 {
    public static void main(String[] args) {
        List<User> users=new ArrayList<>();
        users.add(new User(16,"A"));
        users.add(new User(13,"B"));
        users.add(new User(22,"C"));
        users.add(new User(16,"A"));

        users.stream()
                .distinct()
//                .skip(users.size()-3)
                .map(u->"hello:"+u.getName())
                .findFirst();
    }
}

class User{

    private int age;
    private  String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}