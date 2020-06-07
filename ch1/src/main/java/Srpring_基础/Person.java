package Srpring_基础;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/25  11:01
 * @since 1.0.0
 */

public class Person {
    private String name;
    private int age;
    private Food food;
    private Set set;

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private List list;
    private Map map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
