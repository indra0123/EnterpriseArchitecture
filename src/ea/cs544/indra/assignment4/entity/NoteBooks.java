/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author indra
 */
@Entity
public class NoteBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pages;

    public NoteBooks() {
    }

    public NoteBooks(int pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
