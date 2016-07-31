/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment4.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author indra
 */
@Entity
public class Teacher extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Laptop laptop;

    public Teacher() {
        super();
    }

    public Teacher(String name, float salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Teacher[ Name = " + getName() + " Salary = " + salary + " ]";
    }

}
