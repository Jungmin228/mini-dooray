package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/milestone")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/no/{projectNo}")
    public List<MilestoneDto> getMilestoneByProjectNo(@PathVariable("projectNo") Integer no) {
        return milestoneService.getMilestoneByProjectNo(no);
    }
}