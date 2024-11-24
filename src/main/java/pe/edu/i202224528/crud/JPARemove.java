package pe.edu.i202224528.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224528.entity.Country;

public class JPARemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            String countryCode = "PEF";
            Country country = em.find(Country.class, countryCode);

            if (country != null) {
                em.remove(country);
                System.out.println("El país " + countryCode + " fue eliminado junto con sus cus ciudades y lenguajes");
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
