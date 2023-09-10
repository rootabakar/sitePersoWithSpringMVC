package site.abakar.sitepersowithspringmvc.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.abakar.sitepersowithspringmvc.admin.entites.Educations;

public interface EducationRepository extends JpaRepository<Educations,Long> {
}
