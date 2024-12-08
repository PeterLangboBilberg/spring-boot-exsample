package com.plg.learn.spring;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @SequenceGenerator( name="custumer_id_sequnce", sequenceName = "custumer_id_sequnce", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custumer_id_sequnce")
    private Integer id;
    private String name;
    private String email;
    private Integer age;


    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
