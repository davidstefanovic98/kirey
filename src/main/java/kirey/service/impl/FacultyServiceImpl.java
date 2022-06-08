package kirey.service.impl;

import kirey.entity.Faculty;
import kirey.repository.FacultyRepository;
import kirey.service.FacultyService;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl extends BaseServiceImpl<Faculty> implements FacultyService {

    protected FacultyServiceImpl(FacultyRepository baseRepository) {
        super(baseRepository);
    }
}
