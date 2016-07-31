/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment4;

import ea.cs544.indra.assignment4.entity.Laptop;
import ea.cs544.indra.assignment4.entity.NoteBooks;
import ea.cs544.indra.assignment4.entity.Person;
import ea.cs544.indra.assignment4.entity.Student;
import ea.cs544.indra.assignment4.entity.Teacher;

/**
 *
 * @author indra
 */
public class MyCRUD {
    
    private static final String persistenceUnitName = "SC544_ASSIGNMENT4";
    private static MyPersistance myPersister;

    public MyCRUD() {
        this.myPersister = new MyPersistance(persistenceUnitName);
    }

    public boolean deleteStudent(int id) {
        return myPersister.delete(Person.class, id);
    }

    public static void main(String[] args) {
        
        MyCRUD myCRUD = new MyCRUD();

        //Students
        Student jack = new Student("jacky", 3.4);
        Student john = new Student("john", 3.2);
        Student jill = new Student("jill", 3.6);

        //Teacher
        Teacher jim = new Teacher("jim", 45000);
        Teacher jasmin = new Teacher("jasmin", 46000);

        //jack, 3 notebooks (100, 120, 60 pages each)
        jack.addNotebooks(new NoteBooks(100));
        jack.addNotebooks(new NoteBooks(120));
        jack.addNotebooks(new NoteBooks(60));

        //john, 2 notebooks (200, 50 pages each)
        john.addNotebooks(new NoteBooks(200));
        john.addNotebooks(new NoteBooks(50));

        //jill, 1 notebook 300 pages.
        jill.addNotebooks(new NoteBooks(300));

        //jim, has a dell laptop.
        jim.setLaptop(new Laptop("dell"));

        //jasmin has a mac laptop.
        jasmin.setLaptop(new Laptop("mac"));
        
         //persisting objects
         
        myPersister.<Person>persist(jack);
        myPersister.<Person>persist(john);
        myPersister.<Person>persist(jill);
        myPersister.<Person>persist(jim);
        myPersister.<Person>persist(jasmin);
        
        myPersister.printDataFromDatabase(Person.class, "Person");
        
        //deleting student of id 3
        System.out.println(myCRUD.deleteStudent(3));
        
        System.err.println("After Record Has been deleted !!!");
        myPersister.printDataFromDatabase(Person.class, "Person");

    }

}
