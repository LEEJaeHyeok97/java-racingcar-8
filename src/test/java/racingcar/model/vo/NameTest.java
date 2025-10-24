package racingcar.model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("입력 이름이 비어있으면 예외를 발생한다.")
    @Test
    void nameEmptyExceptionTest() {
        //given
        String input = "";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }

    @DisplayName("5글자를 초과한 이름을 입력하면 예외를 발생한다.")
    @Test
    void createNameMaxLengthExceed() {
        //given
        String name = "McGregor";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @DisplayName("5글자를 초과하지 않은 이름을 입력하면 Name 객체를 생성한다.")
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