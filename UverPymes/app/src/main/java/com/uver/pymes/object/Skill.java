package com.uver.pymes.object;

public class Skill {

    private String name;
    private String description;
    private Integer expertiseYears;

    public Skill(String name, String description, Integer expertiseYears) {
        this.name = name;
        this.description = description;
        this.expertiseYears = expertiseYears;
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
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expertiseYears=" + expertiseYears +
                '}';
    }
}
