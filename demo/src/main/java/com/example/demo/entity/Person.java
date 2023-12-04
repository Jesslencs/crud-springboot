package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_people")
@NoArgsConstructor


public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false,unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "age", nullable = false)

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Builder
    public Person(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
