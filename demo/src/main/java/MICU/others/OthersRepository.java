// src/main/java/MICU/others/OthersRepository.java
package MICU.others;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OthersRepository extends JpaRepository<Others, Integer> {
    // Optional: date range by createdAt for filtering
    List<Others> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
