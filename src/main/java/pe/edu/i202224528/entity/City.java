package pe.edu.i202224528.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country CountryCode;
    private String District;
    private Integer Population;

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", CountryCode=" + (CountryCode != null ? CountryCode.getCode() : "null") +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public City() {
    }

    public City(Integer ID, String name, Country countryCode, String district, Integer population) {
        this.ID = ID;
        Name = name;
        CountryCode = countryCode;
        District = district;
        Population = population;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Country getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(Country countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }
}
