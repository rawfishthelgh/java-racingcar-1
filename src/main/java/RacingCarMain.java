import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        InputController inputController = new InputController(); // 사용자 입력 처리 클래스
        List<Car> cars = inputController.getCarNames(); // 자동차 입력 및 검증
        int CountNum = inputController.getCountNum(); // 시도 횟수 입력
        // MoveStrategy를 구현한 객체 생성 (RandomMove 사용)
        MoveStrategy moveStrategy = new RandomMove();

        RacingCarGame racingCarGame = new RacingCarGame(cars, moveStrategy);
        racingCarGame.play(CountNum); // 게임 실행
        racingCarGame.printResult(); // 결과 출력
    }
}
