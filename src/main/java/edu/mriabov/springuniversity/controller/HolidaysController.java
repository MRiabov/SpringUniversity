package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Holiday;
import edu.mriabov.springuniversity.repository.HolidayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {
    @Autowired
    private HolidayRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        switch (display) {
            case "federal" -> model.addAttribute("federal",true);
            case "festival" -> model.addAttribute("festival",true);
            default -> {
                model.addAttribute("federal",true);
                model.addAttribute("festival",true);
            }
        }//todo is this ok?
        Iterable<Holiday> holidaysIterable = holidaysRepository.findAll();
        List<Holiday> holidays=java.util.stream.StreamSupport.stream(holidaysIterable.spliterator(),false)
                .toList();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
