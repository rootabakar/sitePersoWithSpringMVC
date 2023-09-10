package site.abakar.sitepersowithspringmvc.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.abakar.sitepersowithspringmvc.admin.entites.Experiences;

public interface ExperiencesRepository extends JpaRepository<Experiences,Long> {
}
