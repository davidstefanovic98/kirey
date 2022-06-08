package kirey.repository;

import kirey.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends BaseRepository<Faculty> {

    List<Faculty> findAllByNameAndCity(String name, String city);
}
