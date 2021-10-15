package com.law.springdata.tutorials.idgenerators.entities;

import com.law.springdata.tutorials.idgenerators.CustomRandomIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {

//    @Id
//    @TableGenerator(name = "employee_gen", table = "id_gen",
//            pkColumnName = "gen_name", valueColumnName = "gen_val",
//            allocationSize = 100)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    @GenericGenerator(name = "emp_id",
            strategy = "com.law.springdata.tutorials.idgenerators.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
