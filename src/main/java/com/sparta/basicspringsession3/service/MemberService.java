package com.sparta.basicspringsession3.service;

import com.sparta.basicspringsession3.dto.*;
import com.sparta.basicspringsession3.entity.Member;
import com.sparta.basicspringsession3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> DtoList = new ArrayList<>();
        for (Member member : members) {
            MemberSimpleResponseDto memberSimpleResponseDto = new MemberSimpleResponseDto(member.getId(),member.getName());
            DtoList.add(memberSimpleResponseDto);
        }
        return DtoList;
    }

    public MemberDetailResponseDto getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        return new MemberDetailResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public MemberUpdateresponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        member.update(memberUpdateRequestDto.getName());
        return new MemberUpdateresponseDto(member.getId(),member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        memberRepository.delete(member);
    }
}
