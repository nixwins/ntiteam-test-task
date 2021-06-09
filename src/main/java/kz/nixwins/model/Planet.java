package kz.nixwins.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Persistent;

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

    @ManyToOne(targetEntity = Lord.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lord_id", insertable = false, updatable = false)
    private Lord lord;

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
       this.lord = lord;
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
