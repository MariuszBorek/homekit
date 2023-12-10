package com.mb.homekit.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class TempDataController {

    private final TempDataRepository tempDataRepository;

    @Autowired
    public TempDataController(TempDataRepository tempDataRepository) {
        this.tempDataRepository = tempDataRepository;
    }

    @GetMapping("/get")
    public List<TempData> getData() {
        return tempDataRepository.findAll();
    }

    @GetMapping("/addSample")
    public void createData() {
        TempData tempData = new TempData();
        tempData.setDataType("csv");
        tempData.setData("data");
        tempDataRepository.save(tempData);
    }

    @PostMapping("/add")
    public TempData createData(@RequestBody TempData tempData) {
        return tempDataRepository.save(tempData);
    }
}