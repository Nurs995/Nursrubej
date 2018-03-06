package kz.kaznitu.lessons.demo.models;

import javax.persistence.*;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long group_id;
    private String group_shif;
    private int group_num;
    private Teacher teacher;


    public Journal() {
        this.group_shif = group_shif;
        this.group_num = group_num;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_shif() {
        return group_shif;
    }

    public void setGroup_shif(String group_shif) {
        this.group_shif = group_shif;
    }

    public int getGroup_num() {
        return group_num;
    }

    public void setGroup_num(int group_num) {
        this.group_num = group_num;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}