import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputController {
    private final Scanner scanner = new Scanner(System.in);

    public List<Car> getCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분):");
                String input = scanner.nextLine();
                return createCars(input.split(",")); // 입력된 이름으로 Car 리스트 생성
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }
        }
    }

    public int getCountNum() {
        System.out.println("시도할 횟수를 입력하세요:");
        return scanner.nextInt();
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name)); // Car 객체 생성 시 유효성 검사 수행
        }
        return cars;
    }
}
