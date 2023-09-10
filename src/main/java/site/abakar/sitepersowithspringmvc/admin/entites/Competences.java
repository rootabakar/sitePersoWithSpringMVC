package site.abakar.sitepersowithspringmvc.admin.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;

@AllArgsConstructor
@Entity @Data @NoArgsConstructor @Builder
public class Competences {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;
}

