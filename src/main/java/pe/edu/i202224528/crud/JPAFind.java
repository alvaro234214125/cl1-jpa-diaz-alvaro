package pe.edu.i202224528.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224528.entity.Country;
import pe.edu.i202224528.entity.City;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            String countryCode = "PER";
            Country country = em.find(Country.class, countryCode);

            if (country != null) {
                List<City> cities = country.getCities();
                cities.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> {
                            System.out.println(city.getName() + " (La población es de " + city.getPopulation() + ")");
                        });

            } else {
                System.out.println("No se encontró el país: " + countryCode);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
