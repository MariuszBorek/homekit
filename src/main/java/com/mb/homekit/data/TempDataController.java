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
    public List<TempDataEntity> getData() {
        return tempDataRepository.findAll();
    }

    @GetMapping("/addSample")
    public void createData() {
        TempDataEntity tempDataEntity = new TempDataEntity();
        tempDataEntity.setDataType("csv");
        tempDataEntity.setData("data");
        tempDataRepository.save(tempDataEntity);
    }

    @PostMapping("/add")
    public TempDataEntity createData(@RequestBody TempDataDto tempDataDto) {
        TempDataEntity tempDataEntity = new TempDataEntity();
        tempDataEntity.setData(tempDataDto.getData());
        tempDataEntity.setDataType(tempDataDto.getDataType());
        return tempDataRepository.save(tempDataEntity);
    }
}