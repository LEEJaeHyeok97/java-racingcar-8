package racingcar.model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("입력 이름이 비어있을 때 예외 테스트")
    @Test
    void nameEmptyExceptionTest() {
        //given
        String input = "";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }

    @DisplayName("5글자를 초과한 이름 입력 시 예외 테스트")
    @Test
    void createNameMaxLengthExceed() {
        //given
        String name = "McGregor";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @DisplayName("5글자를 초과하지 않은 이름 입력 테스트")
    @Test
    void createNameWithnMaxLength() {
        //given
        String input = "woni";

        //when
        Name name = new Name(input);
        // then
        Assertions.assertThat(name.getName())
                .isEqualTo(input);
    }
}