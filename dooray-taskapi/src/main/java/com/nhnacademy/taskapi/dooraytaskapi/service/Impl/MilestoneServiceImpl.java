package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;

    @Override
    public List<MilestoneDto> getMilestoneByProjectNo(Integer no) {
        return milestoneRepository.getMilestoneByProjectNo(no);
    }

    @Override
    public void registerMilestone(MilestoneRegisterRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(ProjectNotFoundException::new);
        Milestone milestone = Milestone.addMilestone()
            .name(request.getMilestoneName())
            .project(project)
            .build();
        milestoneRepository.save(milestone);
    }
}
