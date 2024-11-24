package pe.edu.i202224528.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id; 

    private String IsOfficial;
    private Double Percentage;
    
    public CountryLanguage() {}
    
    public CountryLanguage(Country countryCode, String language, String isOfficial, Double percentage) {
        this.id = new CountryLanguageId(countryCode, language);
        this.IsOfficial = isOfficial;
        this.Percentage = percentage;
    }
    
    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "CountryCode=" + (id != null && id.getCountryCode() != null ? id.getCountryCode().getCode() : "null") +
                ", Language='" + id.getLanguage() + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                ", Percentage=" + Percentage +
                '}';
    }
}
