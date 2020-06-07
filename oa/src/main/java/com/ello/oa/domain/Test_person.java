package com.ello.oa.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @create 2020/5/28  16:57 author：longchenggong
 *
 * @ConfigurationProperties :告诉springboot将本类中的所有属性和配置文件中的配置进行绑定，从全局配置文件中获取
 * prefix = "person" 和yml配置文件中一一映射
 *
 * @Validated增加校验
 */

@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Test_person {


    private String name;
    private Integer age;
    private Boolean aBoolean;
    @NotNull
    private Date birth;

    private Test_dog dog;
    private Map<String,Object> map;
    private List<Object> list;


    @Override
    public String toString() {
        return "Test_person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", aBoolean=" + aBoolean +
                ", birth=" + birth +
                ", dog=" + dog +
                ", map=" + map +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
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

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Test_dog getDog() {
        return dog;
    }

    public void setDog(Test_dog dog) {
        this.dog = dog;
    }

    public Map <String, Object> getMap() {
        return map;
    }

    public void setMap(Map <String, Object> map) {
        this.map = map;
    }

    public List <Object> getList() {
        return list;
    }

    public void setList(List <Object> list) {
        this.list = list;
    }
}
