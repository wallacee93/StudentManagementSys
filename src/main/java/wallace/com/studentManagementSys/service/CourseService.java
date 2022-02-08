package wallace.com.studentManagementSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallace.com.studentManagementSys.entity.Course;
import wallace.com.studentManagementSys.repo.CourseRepo;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repo;

    public List<Course> listAll(){

        return repo.findAll();
    }

    public void save(Course course){

        repo.save(course);
    }

    public Course get(long id) {

        return repo.findById(id).get();
    }

    public void delete(long id){

        repo.deleteById(id);
    }
}
