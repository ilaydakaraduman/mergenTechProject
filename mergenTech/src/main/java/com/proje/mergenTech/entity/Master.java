package com.proje.mergenTech.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "MASTER", schema = "HATALOG")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Master implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_MASTER", sequenceName = "SEQ_MASTER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MASTER")
    @Column(name="M_ID",unique = true,nullable = false)
    private Long m_Id;
    @Column(name = "HOSPITAL_NAME")
    private String hastaneAdi;
    @Column(name="IP_ADDRESS")
    private String ipAdresi;
    @Column(name="MAC_ADDRESS")
    private String macAdresi;
    @Column(name = "USER_CODE")
    private String kullaniciKodu;
    @Column(name = "MESSAGE_DESCRIBE")
    private String mesajTanimi;
    @Column(name = "TIME")
    private Date zaman;
    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("master")
    private List<Throwable> throwables = new ArrayList<>();
}