package kz.nixwins.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lords")

public class Lord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Lord> freeLords;

    public Lord(){}
    public Lord(Long id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;

    }

    public Long getId() {
        return id;
    }

//    public List<Lord> getFreeLords() {
//        return freeLords;
//    }

    public void setFreeLords(List<Lord> freeLords) {
        this.freeLords = freeLords;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
