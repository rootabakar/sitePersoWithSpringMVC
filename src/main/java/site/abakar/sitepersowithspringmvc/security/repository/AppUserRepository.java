package site.abakar.sitepersowithspringmvc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByEmail(String email);
}
