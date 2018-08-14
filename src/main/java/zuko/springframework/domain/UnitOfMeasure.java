package zuko.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    public  UnitOfMeasure (){}

    public UnitOfMeasure(String uom) {
        this.uom = uom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

    public Long getId() {
        return this.id;
    }

    public String getUom() {
        return this.uom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
