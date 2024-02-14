package mvc1.servlet.domain.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hi", 20);
        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMemberId = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMemberId).isEqualTo(saveMember);
    }


    @Test
    void findAll() {
        //given
        Member m1 = new Member("m1", 10);
        Member m2 = new Member("m2", 20);
        Member m3 = new Member("m3", 30);

        Member saveM1 = memberRepository.save(m1);
        Member saveM2 = memberRepository.save(m2);
        Member saveM3 = memberRepository.save(m3);
        //when
        List<Member> all = memberRepository.findAll();
        //then
        Assertions.assertThat(all.size()).isEqualTo(3);
        Assertions.assertThat(all).contains(m1);
        Assertions.assertThat(all).contains(m2);
        Assertions.assertThat(all).contains(m3);

    }
}
