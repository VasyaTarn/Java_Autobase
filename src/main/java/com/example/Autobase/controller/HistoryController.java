package com.example.Autobase.controller;

import com.example.Autobase.model.Flight;
import com.example.Autobase.model.HistoryApp;
import com.example.Autobase.service.historyAppService.HistoryAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    private HistoryAppService historyAppService;

    @GetMapping("/histories")
    public String showHistories(Model model) {
        List<HistoryApp> histories = historyAppService.findAll();
        model.addAttribute("histories", histories);
        return "histories";
    }
}
