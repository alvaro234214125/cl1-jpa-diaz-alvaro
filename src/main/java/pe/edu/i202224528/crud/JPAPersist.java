package pe.edu.i202224528.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224528.entity.City;
import pe.edu.i202224528.entity.Country;
import pe.edu.i202224528.entity.CountryLanguage;
import pe.edu.i202224528.entity.CountryLanguageId;

import java.util.ArrayList;
import java.util.List;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country newCountry = new Country();
        newCountry.setCode("PEF");
        newCountry.setName("Peru fake");
        newCountry.setContinent("South America");
        newCountry.setRegion("Andina");
        newCountry.setSurfaceArea(75650.0);
        newCountry.setIndepYear(1821);
        newCountry.setPopulation(3500000);
        newCountry.setLifeExpectancy(76.5);
        newCountry.setGNP(125000.0);
        newCountry.setGNPOld(110000.0);
        newCountry.setLocalName("Latino");
        newCountry.setGovernmentForm("República Federal");
        newCountry.setHeadOfState("Juan Pérez");
        newCountry.setCapital(1);
        newCountry.setCode2("LE");

        City city1 = new City();
        city1.setName("Andesópolis");
        city1.setCountryCode(newCountry);
        city1.setDistrict("Distrito Sur");
        city1.setPopulation(1200000);

        City city2 = new City();
        city2.setName("Costamar");
        city2.setCountryCode(newCountry);
        city2.setDistrict("Distrito Costero");
        city2.setPopulation(850000);

        City city3 = new City();
        city3.setName("Selvaville");
        city3.setCountryCode(newCountry);
        city3.setDistrict("Distrito Amazónico");
        city3.setPopulation(1400000);

        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        newCountry.setCities(cities);

        CountryLanguage lang1 = new CountryLanguage();
        lang1.setId(new CountryLanguageId(newCountry, "Aimara1"));  // Usamos la clave compuesta
        lang1.setIsOfficial("T");
        lang1.setPercentage(90.0);

        CountryLanguage lang2 = new CountryLanguage();
        lang2.setId(new CountryLanguageId(newCountry, "Aimara2"));  // Usamos la clave compuesta
        lang2.setIsOfficial("F");
        lang2.setPercentage(10.0);

        List<CountryLanguage> languages = new ArrayList<>();
        languages.add(lang1);
        languages.add(lang2);
        newCountry.setLanguages(languages);

        em.persist(newCountry);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("Registros creados");
    }
}
