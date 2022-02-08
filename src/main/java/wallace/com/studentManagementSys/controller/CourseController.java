package wallace.com.studentManagementSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wallace.com.studentManagementSys.entity.Course;
import wallace.com.studentManagementSys.repo.CourseRepo;
import wallace.com.studentManagementSys.service.CourseService;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/addCourse")
    public String add(Model model){

        List<Course> listedCourse = courseService.listAll();
        model.addAttribute("listedCourse", listedCourse);
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.save(course);
        return "redirect:/course";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditedCoursePage(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("addCourse");
        Course course = courseService.get(id);
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") int id){
        courseService.delete(id);
        return "redirect://course";
    }
}
