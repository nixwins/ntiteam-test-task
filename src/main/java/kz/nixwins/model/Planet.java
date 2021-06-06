package kz.nixwins.model;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="planets")

public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lord_id")
    private  int lordId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLordId() {
        return lordId;
    }

    public void setLordId(int lordId) {
        this.lordId = lordId;
    }
}
