package com.tapusd.domain;

public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String department;

    public Student () {}

    public Student(String name, Integer age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return " | " + id + " | " + name + " | " + age + " | " + department + " | ";
    }
}
