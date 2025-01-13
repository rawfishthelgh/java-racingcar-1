import models.Car;
import services.RacingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        List<Car> cars = getCarName();
        int roundCount = getRoundCount();

        System.out.println("\n실행결과");
        RacingService.simulateRace(cars, roundCount);

        List<String> winners = RacingService.findWinner(cars);
        System.out.println('\n' + "최종 우승자ㅣ "  + String.join(" ", winners));
    }

    public static List<Car> getCarName() {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"); //pobi,crong,honux
        String[] carNames = sc.nextLine().split(","); //nextLine : 개행문자를 만나면 종료
        List<Car> carData = new ArrayList<>(); //ArrayList<> 표현식 : 리스트의 길이가 가변적
        for (String name : carNames) {
            carData.add(new Car(name.trim()));
        }

        System.out.println(carData);

        return carData;
    }

    public static int getRoundCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println(".시도할 횟수는 몇회인가요?:  ");
        int roundCount = sc.nextInt();

        return roundCount;
    }
}

/*
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -
 */

