package pl.coderslab.domain;

import java.util.Set;

public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String country;

    private Set<String> programmingSkills;

    private Set<String> hobbies;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String firstName, String lastName, String country, Set<String> programmingSkills, Set<String> hobbies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.programmingSkills = programmingSkills;
        this.hobbies = hobbies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(Set<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }
}
