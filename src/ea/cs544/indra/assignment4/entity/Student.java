/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment4.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author indra
 */
@Entity
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double gpa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NoteBooks> notebooks = new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addNotebooks(NoteBooks notebook) {
        this.notebooks.add(notebook);
    }

    public List<NoteBooks> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(List<NoteBooks> notebooks) {
        this.notebooks = notebooks;
    }

}
