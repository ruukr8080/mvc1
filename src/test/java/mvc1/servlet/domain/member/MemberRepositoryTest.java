package mvc1.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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
        Member m1 = Member.builder().age(1).name("a").build();
        Member m2 = Member.builder().age(2).name("b").build();
        Member m3 = Member.builder().age(3).name("c").build();


        Member saveM1 = memberRepository.save(m1);
        Member saveM2 = memberRepository.save(m2);
        Member saveM3 = memberRepository.save(m3);
        //when

        //then

        Assertions.assertThat(m1).isEqualTo(saveM2);
        Assertions.assertThat(m2).isEqualTo(saveM2);
        Assertions.assertThat(m3).isEqualTo(saveM3);


    }
}
