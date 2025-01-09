import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void shouldThrowExceptionForInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("InvalidName"));
    }
    @Test
    @DisplayName("자동차 초기 위치 확인")
    void carInitialPositionTest() {
        Car car = new Car("Car1");
        assertEquals(1, car.getPosition()); // 초기값은 1이어야 함
    }
    @Test
    @DisplayName("랜덤 값이 4 이상일 때 자동차가 전진한다")
    void carShouldMoveWhenRandomValueIsGreaterThanOrEqualToFour() {
        Car car = new Car("Car1");

        car.move(new FixedMove(4));
        assertEquals(2, car.getPosition()); // 초기값 1 + 전진 1 = 2

        car.move(new FixedMove(8));
        assertEquals(3, car.getPosition()); // 기존 위치 2 + 전진 1 = 3
    }
    @Test
    @DisplayName("랜덤 값이 3 이하일 때 자동차가 멈춘다")
    void carShouldNotMoveWhenRandomValueIsLessThanFour() {
        Car car = new Car("Car1");
        car.move(new FixedMove(0));
        assertEquals(1, car.getPosition());
    }


}
