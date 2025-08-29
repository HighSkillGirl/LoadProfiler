package high.skill.girl.project.proxy_profiler.proxy;

import java.util.List;
import java.util.Objects;

public class Women {
    private int age;

    public Women(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        Women other = (Women) otherObject;
        return age == other.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return String.format("%s: [%d]", getClass().getName(), age);
    }
}
