package ro.fasttrackit.curs19.model;

import java.util.List;
import java.util.Objects;

public class Country {
    private int id;
    private final String name;
    private final String capital;
    private final long population;
    private final double area;
    private final String continent;
    private final List<String> neighours;

    public Country(int id, String name, String capital, long population, double area, String continent, List<String> neighours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighours = neighours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighours() {
        return neighours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                population == country.population &&
                Double.compare(country.area, area) == 0 &&
                Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(neighours, country.neighours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capital, population, area, continent, neighours);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighours=" + neighours +
                '}';
    }
}
