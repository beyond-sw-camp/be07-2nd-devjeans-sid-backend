package org.devjeans.sid.domain.launchedProject.controller;

import org.devjeans.sid.domain.launchedProject.dto.LaunchProjectDTO.DetailBasicLaunchedProjectResponse;
import org.devjeans.sid.domain.launchedProject.dto.LaunchedProjectMemberDTO.LaunchedProjectMemberResponse;
import org.devjeans.sid.domain.launchedProject.dto.LaunchedProjectTechStackDTO.LaunchedProjectTechStackResponse;
import org.devjeans.sid.domain.launchedProject.entity.LaunchedProject;
import org.devjeans.sid.domain.launchedProject.service.LaunchedProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/launched-projects")
public class LaunchedProjectController {

    private final LaunchedProjectService launchedProjectService;

    @Autowired
    public LaunchedProjectController(LaunchedProjectService launchedProjectService){
        this.launchedProjectService = launchedProjectService;
    }

    // Launched-Project 등록 (아직 수정중...ㅠㅠ)
//    @PostMapping("/register")
//    public ResponseEntity<>


    // Launched-Project id로 Launched-Project 기본정보 조회
    @GetMapping("/detail/{id}/basic-info")
    public ResponseEntity<DetailBasicLaunchedProjectResponse> getDetailBasicInfo(@PathVariable Long id) {
        LaunchedProject launchedProject = launchedProjectService.findById(id);
        DetailBasicLaunchedProjectResponse basicInfo = DetailBasicLaunchedProjectResponse.fromEntity(launchedProject);
        return ResponseEntity.ok(basicInfo);
    }

    // Launched-Project id로 프로젝트에 사용된 기술스택(TechStack)리스트 조회
    @GetMapping("/detail/{id}/tech-stacks")
    public ResponseEntity<List<LaunchedProjectTechStackResponse>> getTechStacks(@PathVariable Long id){
        List<LaunchedProjectTechStackResponse> stacks = launchedProjectService.getTechStacksByProjectId(id);
        return ResponseEntity.ok(stacks);
    }

    // Launched-Project id로 프로젝트에 참여한 회원(LaunchedProjectMember)리스트 조회
    @GetMapping("/detail/{id}/members")
    public ResponseEntity<List<LaunchedProjectMemberResponse>> getProjectMembers(@PathVariable Long id) {
        List<LaunchedProjectMemberResponse> members = launchedProjectService.getProjectMembers(id);
        return ResponseEntity.ok(members);
    }


    // 유저는 프로젝트 모집글을 삭제할 수 있다.


    // 유저는 런칭된 프로젝트 목록을 조회할 수 있다.


    // 유저는 프로젝트 완성글에 사이다를 누를 수 있다.

}
