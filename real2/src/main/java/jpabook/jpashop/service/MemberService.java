package jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 성능 최적화
@RequiredArgsConstructor
public class MemberService {

    // @Autowired
    private final MemberRepository memberRepository;

    // public MemberService(MemberRepository memberRepository) {
    // this.memberRepository = memberRepository;
    // }

    /**
     * 회원 가입
     * 
     * @param member
     * @return
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicataeMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicataeMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     * 
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
