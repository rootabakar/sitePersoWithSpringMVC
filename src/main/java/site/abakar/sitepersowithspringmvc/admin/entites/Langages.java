package site.abakar.sitepersowithspringmvc.admin.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Langages {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private AppUser appUser;
}
