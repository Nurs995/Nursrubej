package kz.kaznitu.lessons.demo.controllers;

import kz.kaznitu.lessons.demo.models.Teacher;
import kz.kaznitu.lessons.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")

public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher_add_form";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Teacher> allTeacher() {
        return teacherRepository.findAll();
    }

    @GetMapping("/all2")
    public String allTeacher2(Model model) {
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
    public ModelAndView deleteTeacher(@RequestParam("id") long idd) {
        teacherRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editTeacher")
    public String editTeacher(@ModelAttribute Teacher teacher) {
        Teacher teacher1 = new Teacher();
        teacher1.setId(a);
        teacher1.setName(teacher.getName());
        teacher1.setSurname(teacher.getSurname());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editTeacher",method = RequestMethod.GET)
    public ModelAndView editTeacher(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Teacher> teacher = (Optional <Teacher>) teacherRepository.findById(id);
        model.addAttribute("teacher",teacher);
        return new ModelAndView("smp");
    }
    @RequestMapping("/editTeacher")
    public String showForm2(Model model){
        model.addAttribute("teacher",new Teacher());
        return "smp";
    }
}