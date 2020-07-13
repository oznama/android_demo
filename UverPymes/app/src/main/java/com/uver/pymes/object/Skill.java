package com.uver.pymes.object;

public class Skill {

    private Integer id;
    private String name;
    private String description;
    private Integer expertiseYears;

    public Skill(Integer id, String name, String description, Integer expertiseYears) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expertiseYears = expertiseYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExpertiseYears() {
        return expertiseYears;
    }

    public void setExpertiseYears(Integer expertiseYears) {
        this.expertiseYears = expertiseYears;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expertiseYears=" + expertiseYears +
                '}';
    }
}
