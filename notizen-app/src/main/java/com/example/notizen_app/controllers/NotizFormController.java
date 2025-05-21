package com.example.notizen_app.controllers;

import com.example.notizen_app.models.Notiz;
import com.example.notizen_app.services.NotizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotizFormController {

    @Autowired
    private NotizService notizService;

    @GetMapping("/create-notiz")
    public String showCreateForm(Notiz notiz){
        return "new-todo-notiz";
    }


    @PostMapping("/notizFill")
    public String createNotiz(@Valid Notiz notiz, BindingResult result, Model model){

        Notiz item = new Notiz();
        item.setDescription(notiz.getDescription());
        item.setTitle(notiz.getTitle());

        notizService.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNotiz(@PathVariable("id") Long id, Model model){
        // check if notiz is there
        Notiz notiz = notizService
                .getNotizById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notiz id: " + id + "not found"));

        notizService.delete(notiz);
        return "redirect:/";
    }

    /**
     * Function that deals with what happens when the EDIT Button is clicked, it redirects you to a new template
     */
    @GetMapping("/edit/{id}")
    public String editNotiz(@PathVariable("id") Long id, Model model){
        // check if notiz is there
        Notiz notiz = notizService
                .getNotizById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notiz id: " + id + "not found"));

        model.addAttribute("notiz", notiz); // translates name, how it appears in html

        return "edit-todo-notiz"; // redirects us to new template
    }


    /**
     * Function to Update a Notiz
     */
    @PostMapping("/notiz_update/{id}")
    public String updateNotizItem(@PathVariable("id") Long id, @Valid Notiz new_notiz, BindingResult bindingResult, Model model){
        Notiz notiz = notizService
                .getNotizById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notiz id: " + id + "not found"));

        // copy over what the User inputs
        notiz.setTitle(new_notiz.getTitle());
        notiz.setDescription(new_notiz.getDescription());

        notizService.save(notiz);
        return "redirect:/";
    }
}
