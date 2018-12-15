package pl.coderslab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
@Transactional
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

//    private Set<String> programmingSkills = new HashSet<>();
//
//    private Set<String> hobbies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PersonDetails(String country) {
        this.country = country;
    }

    public PersonDetails() {
    }


    //    public Set<String> getProgrammingSkills() {
//        return programmingSkills;
//    }
//
//    public void setProgrammingSkills(Set<String> programmingSkills) {
//        this.programmingSkills = programmingSkills;
//    }
//
//    public Set<String> getHobbies() {
//        return hobbies;
//    }
//
//    public void setHobbies(Set<String> hobbies) {
//        this.hobbies = hobbies;
//    }

//    public PersonDetails(Set<String> hobbies) {
//
//        this.hobbies = hobbies;
//    }
//
//    public PersonDetails(String country, Set<String> programmingSkills, Set<String> hobbies) {
//
//        this.country = country;
//        this.programmingSkills = programmingSkills;
//        this.hobbies = hobbies;
//    }
}
