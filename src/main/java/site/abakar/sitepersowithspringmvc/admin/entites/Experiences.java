package site.abakar.sitepersowithspringmvc.admin.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Experiences {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomPoste;
    private String date;
    private String nomEntreprise;
    private String paysVille;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;
}

