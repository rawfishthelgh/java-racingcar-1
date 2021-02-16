package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.FixedNumberGeneratingStrategy;

class CarsTest {

    @ParameterizedTest
    @DisplayName("생성 성공 - 올바른 입력")
    @ValueSource(strings = {"pobi,joy,poz", "pobi,joy , poz"})
    void from_valid(String input) {
        assertThat(Cars.fromString(input).getCars())
                .containsExactly(
                        Car.from("pobi"),
                        Car.from("joy"),
                        Car.from("poz"));
    }

    @ParameterizedTest
    @DisplayName("생성 실패 - (,)중복")
    @ValueSource(strings = {"aa,,bb"})
    void from_invalid(String input) {
        assertThatThrownBy(() -> Cars.fromString(input).getCars())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("생성 실패 - Car 이름 중복")
    void from_duplicatedName() {
        assertThatThrownBy(() -> Cars.fromString("joy,joy").getCars())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void driveAll() {
        Cars cars = Cars.fromString("joy,poz");
        cars.driveAll(new FixedNumberGeneratingStrategy());

        cars.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(Position.valueOf(2)));
    }

    @Test
    @DisplayName("우승자 리턴 - 단일 우승자")
    public void getWinners_singleWinner() {
        Car winner = new Car(CarName.valueOf("A"), Position.valueOf(2));
        Car loser = new Car(CarName.valueOf("B"), Position.valueOf(1));

        Cars cars = Cars.fromList(Arrays.asList(winner, loser));

        assertThat(cars.getWinners()).containsExactly(winner);
    }

    @Test
    @DisplayName("우승자 리턴 - 공동 우승자")
    public void getWinners_manyWinners() {
        Car winner1 = Car.from("A");
        Car winner2 = Car.from("B");

        Cars cars = Cars.fromList(Arrays.asList(winner1, winner2));

        assertThat(cars.getWinners()).containsExactly(winner1, winner2);
    }

    @Test
    @DisplayName("getCars - 수정 불가 리스트 반환")
    void getCars() {
        List<Car> cars = Cars.fromString("A,B").getCars();

        assertThatThrownBy(() -> cars.add(new Car("C")))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> cars.remove(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("getWinners - 수정 불가 리스트 반환")
    void getWinners() {
        List<Car> cars = Cars.fromString("A,B").getWinners();

        assertThatThrownBy(() -> cars.add(new Car("C")))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> cars.remove(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}