package com.sparta.basicspringsession3.controller;

import com.sparta.basicspringsession3.dto.*;
import com.sparta.basicspringsession3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto){
        return ResponseEntity.ok(memberService.saveMember(memberSaveRequestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMemberById(@PathVariable("memberId") Long memberId){
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateresponseDto> updateMember(@PathVariable("memberId") Long memberId, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto){
        return ResponseEntity.ok(memberService.updateMember(memberId,memberUpdateRequestDto));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
    }
}
