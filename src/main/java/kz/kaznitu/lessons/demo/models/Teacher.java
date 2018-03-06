package kz.kaznitu.lessons.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String Name ;
    private String Surname ;
    private String Email ;
    private Set<Journal> journal;


    public Teacher(){}

    public Teacher(String Name, String Surname, String Email) {
        this.Name = Surname;
        this.Surname = Surname;
        this.Email = Email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    public Set<Journal> getJournal() {
        return journal;
    }

    public void setJournal(Set<Journal> journal) {
        this.journal = journal;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, Name='%s', Surname='%a', Email='%e']%n", id, Name, Surname, Email);
        if (journal != null) {
            for(Journal book : journal) {
                result += String.format("Journal[group_id=%d, group_shifr='%s',group_num='%y']%n", book.getGroup_id(), book.getGroup_shif(), book.getGroup_num());
            }
        }

        return result;
    }
}
