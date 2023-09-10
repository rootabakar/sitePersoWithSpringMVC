package site.abakar.sitepersowithspringmvc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.abakar.sitepersowithspringmvc.security.entites.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findAppRoleByNom(String appRole);
}
