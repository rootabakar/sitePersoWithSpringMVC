package site.abakar.sitepersowithspringmvc.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.abakar.sitepersowithspringmvc.admin.entites.Competences;

public interface CompetencesRepository extends JpaRepository<Competences,Long> {
}
