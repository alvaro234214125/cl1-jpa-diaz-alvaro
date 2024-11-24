package pe.edu.i202224528.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country CountryCode;

    private String Language;

    public CountryLanguageId() {}

    public CountryLanguageId(Country countryCode, String language) {
        this.CountryCode = countryCode;
        this.Language = language;
    }

    public Country getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(Country countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(CountryCode, that.CountryCode) &&
                Objects.equals(Language, that.Language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CountryCode, Language);
    }
}
