package org.example.jpaonetomanye24a.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Region {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Kommune> kommune;

    public Set<Kommune> getKommune() {
        return kommune;
    }

    public void setKommune(Set<Kommune> kommune) {
        this.kommune = kommune;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
