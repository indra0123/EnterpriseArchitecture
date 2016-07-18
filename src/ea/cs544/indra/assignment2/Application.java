/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.cs544.indra.assignment2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author indra
 */
public class Application {

    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("CS544_ASSIGNMENT2");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {

        //Create Car
        Car hondaCar = new Car("Honda", "Mazda", 2016, 25000, Color.SILVER);
        Car tataMotorCar = new Car("Tata Motors", "Celerio", 2016, 20000, Color.RED);

        // CarList 
        List<Car> carList = new ArrayList<>();
        carList.add(hondaCar);
        carList.add(tataMotorCar);

        // Save Car to database
        saveCarToDatabase(carList);

        // Print Data from Database
        printDataFromDatabase(Car.class);
    }

    private static void saveCarToDatabase(List<Car> carList) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            carList.stream().forEach((car) -> {
                em.persist(car);
            });
            tx.commit();

        } catch (Throwable e) {
            if ((tx != null) && (tx.isActive())) {
                tx.rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }

    private static void printDataFromDatabase(Class<Car> aClass) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Car> q = em.createQuery("SELECT c FROM Car c", aClass);
        q.getResultList().stream().forEach((car) -> {
            System.out.println(car);
        });
        em.close();
        emf.close();
    }
}
