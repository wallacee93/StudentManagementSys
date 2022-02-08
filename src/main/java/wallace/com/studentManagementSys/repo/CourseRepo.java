package wallace.com.studentManagementSys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wallace.com.studentManagementSys.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {


}
