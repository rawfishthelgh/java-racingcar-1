package services;

import models.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//RacingService, printProgress, findWinner 정의

//Race를 실행 roundCount만큼 Random을 돌려 4이상이면  car.incrementProgress()로 진척도를 증가시킨다
public class RacingService {
    public static void simulateRace(List<Car> cars, int roundCount) {
        Random r = new Random();
        for (int i = 0; i < roundCount; i++) {  //라운드를 반복하며 진척도 증가시키는 로직
            for (Car eachCar : cars) {
                if (r.nextInt(10) >= 4) {
                    eachCar.incrementProgress();
                }
            }
            printProgress(cars);
            System.out.println();
        }
    }

    //경기중 진척도 출력 로직
    public static void printProgress(List<Car> cars) {
        for (Car eachCars : cars) {
            System.out.println(eachCars.getName() + " : " + "-".repeat(eachCars.getProgress()));
        }
    }

    //승자 구별 로직
    public static List<String> findWinner(List<Car> cars) {
        //stream() 다양한 데이터는 다른 형식으로 다뤄야 한다. List를 정렬할 때는 List.sort()를 사용하고, 배열을 정렬할 때는 Arrays.sort()를 사용 하는 식.
        //이러한 문제를 극복하기 위해 나온 것이 바로 Stream(). 배열이나 컬렉션뿐만 아니라 파일에 저장된 데이터도 모두 같은 방식으로 다룰 수 있게 한다.
        //스트림은 데이터 소스를 읽기만 할 뿐, 변경하지 않는다. 또한 일회용이다.
        int maxScore = cars.stream()
                .mapToInt(Car::getProgress)  // ::는 메소드 참조로 eachCar 안의 getProgress를 불러온다.
                .max()
                .orElse(0); //예외값이 있을시 0으로 처리
        List<String> winners = new ArrayList<>();
        for (Car eachCar : cars) {
            if (eachCar.getProgress() == maxScore) {
                winners.add(eachCar.getName());
            }
        }
        return winners;
    }
}
