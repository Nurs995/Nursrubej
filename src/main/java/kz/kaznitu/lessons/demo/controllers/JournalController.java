package kz.kaznitu.lessons.demo.controllers;

import kz.kaznitu.lessons.demo.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/journal")
public class JournalController {
    @Autowired
    private JournalRepository journalRepository;
    private long a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Journal> allGroup() {
        return journalRepository.findAll();
    }

    @GetMapping("/all2")
    public String allGroup2(Model model) {
        List<Journal> groups = (List<Journal>) journalRepository.findAll();
        model.addAttribute("groups", groups);
        return "groups";
    }

    @RequestMapping("/add")
    public String journalForm(Model model) {
        model.addAttribute("group", new Journal());
        return "group_add_form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Journal group) {
        journalRepository.save(group);
        return "redirect:/group/all2";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(@RequestParam("id") long idd) {
        journalRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/all2");
    }

    @PostMapping("/editJournal")
    public String editJournal(@ModelAttribute Journal journal) {
        Journal group1 = new Journal();
        group1.setGroup_id(a);
        group1.setGroup_shif(journal.getGroup_shif());
        group1.setGroup_num(journal.getGroup_num());
        journalRepository.save(group1);
        return "redirect:/journal/all2";
    }

    @RequestMapping(value = "/editJournal", method = RequestMethod.GET)
    public ModelAndView editJournal(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<Journal> journal = (Optional<Journal>) journalRepository.findById(id);
        model.addAttribute("journal", journal);
        return new ModelAndView("inp");
    }

    @RequestMapping("/editJournal")
    public String JournalForm2(Model model) {
        model.addAttribute("journal", new Journal());
        return "inp";
    }
}

