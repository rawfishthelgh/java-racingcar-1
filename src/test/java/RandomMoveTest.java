import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomMoveTest {

    @Test
    @DisplayName("랜덤 값 0~9 사이에서 생성되는지 테스트")
    void randomMoveShouldGenerateValuesBetweenZeroAndNine() {
        RandomMove randomMove = new RandomMove();
        for (int i = 0; i < 100; i++) {
            int value = randomMove.getMoveDistance();
            assertTrue(value >= 0 && value <= 9, "랜덤 값은 0~9 사이여야함");
        }
    }
}

