package awsProject.awsProject.database.repository;

import awsProject.awsProject.database.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long> {
    Optional<Boss> findByTitle(String title);
}
