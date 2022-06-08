package kirey.repository;

import kirey.annotation.Exclude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Exclude
public interface BaseRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
