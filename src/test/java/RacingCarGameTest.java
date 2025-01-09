import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarGameTest {

    @Test
    @DisplayName("포비만 전진시킨 뒤 우승한 차를 올바르게 출력하는지 테스트")
    void shouldFindWinnersCorrectly() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        );

        cars.get(0).move(new FixedMove(4)); // pobi만 전진
        RacingCarGame game = new RacingCarGame(cars, new FixedMove(0)); //나머지는 멈춤
        game.printResult();

        assertEquals(2, cars.get(0).getPosition()); // pobi는 2칸
        assertEquals(1, cars.get(1).getPosition()); // crong은 1칸
        assertEquals(1, cars.get(2).getPosition()); // honux는 1칸
    }
    @Test
    @DisplayName("공동 우승자가 있을 경우 올바르게 출력한다")
    void shouldFindMultipleWinners() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        );

        cars.get(0).move(new FixedMove(4)); // pobi 전진
        cars.get(1).move(new FixedMove(4)); // crong 전진
        RacingCarGame game = new RacingCarGame(cars, new FixedMove(0)); // honux 멈춤
        game.printResult();

        assertEquals(2, cars.get(0).getPosition()); // pobi는 2칸
        assertEquals(2, cars.get(1).getPosition()); // crong은 2칸
        assertEquals(1, cars.get(2).getPosition()); // honux는 1칸
    }
}
