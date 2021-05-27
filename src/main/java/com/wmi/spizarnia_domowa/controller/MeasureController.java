package com.wmi.spizarnia_domowa.controller;

import com.wmi.spizarnia_domowa.model.Measure;
import com.wmi.spizarnia_domowa.service.MeasureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/measures")
@AllArgsConstructor
public class MeasureController {
    private final MeasureService measureService;

    @GetMapping("/all")
    public List<Measure> getAll() {
        return measureService.getAll();
    }

    @GetMapping
    public Measure getById(@RequestParam UUID id) {
        return measureService.getById(id);
    }

    @PostMapping
    public Measure addMeasure(@RequestBody Measure measure) {
        return measureService.save(measure);
    }
}
