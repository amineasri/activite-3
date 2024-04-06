package com.example.hopital.web;

import com.example.hopital.entity.Patient;
import com.example.hopital.repo.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepo patientRepo;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kwd) {
        Page<Patient> patientList;
        if (kwd.isEmpty()) {
            patientList = patientRepo.findAll(PageRequest.of(page, size));
        } else {
            patientList = patientRepo.findByNom(kwd, PageRequest.of(page, size));
        }
        model.addAttribute("listPatient", patientList.getContent());
        model.addAttribute("pages", new int[patientList.getTotalPages()]);
        model.addAttribute("current_page", page);
        model.addAttribute("keyword", kwd);

        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepo.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
