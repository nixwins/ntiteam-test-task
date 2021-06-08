package kz.nixwins.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="planets")
@DynamicUpdate
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lord_id")
    private  Long lordId;

    @Column(insertable = false, updatable = false)
//    @JoinColumn(name = "lord_name")
    private String lordName;

    public String getLordName() {
        return lordName;
    }

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

    public Long getLordId() {
        return lordId;
    }

    public void setLordId(Long lordId) {
        this.lordId = lordId;
    }
}
