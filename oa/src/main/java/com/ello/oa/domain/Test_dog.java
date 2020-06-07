package com.ello.oa.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @create 2020/5/28  17:00 author：longchenggong
 */
@Component
@ConfigurationProperties(prefix = "dog")
public class Test_dog {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Test_dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
