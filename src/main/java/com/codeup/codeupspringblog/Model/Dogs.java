package com.codeup.codeupspringblog.Model;

//Create a model class (Dog) with proper annotations to make a dogs table with the following properties:
//        1) id
//        2) age
//        3) name
//        4) resideState
//        Be sure to include getters and setters and constructors and needed annotations.
//        When running the ‘SHOW CREATE TABLE dogs’, you should have the following schema:
//        CREATE TABLE `dogs` (
//        `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
//        `age` tinyint(3) unsigned NOT NULL,
//        `name` varchar(200) NOT NULL,
//        `reside_state` char(2) DEFAULT ‘XX’,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `UK_?????????????????` (`age`)
//        ) ENGINE=MyISAM DEFAULT CHARSET=utf8


import jakarta.persistence.*;

@Entity
@Table(name="dogs", uniqueConstraints = @UniqueConstraint(columnNames = "age", name = "UK_age"))
public class Dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition= "int(11) auto_Increment")
    private int id;
    @Column(name="age", columnDefinition = "tinyint(3)", nullable = false)
    private int age;
    @Column(name="name", nullable = false, columnDefinition = "varchar(200)")
    private String name;
    @Column(columnDefinition = "char(2) default 'XX'")
    private String reside_state;

    public Dogs(int id, int age, String name, String reside_state) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public Dogs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}
