import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy; // MoveStrategy 사용

    public RacingCarGame(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy; // 생성자에서 MoveStrategy 주입
    }

    public void play(int tryCount) {
        printCurrentState(); // 초기 상태 먼저 출력
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            printCurrentState();
        }
    }

    private void moveCars() {
        // MoveStrategy를 사용하여 각 자동차 이동
        cars.forEach(car -> car.move(moveStrategy));
    }

    private void printCurrentState() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printResult() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
