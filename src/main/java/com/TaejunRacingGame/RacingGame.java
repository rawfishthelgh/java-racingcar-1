package com.TaejunRacingGame;

import java.util.*;
import java.io.*;

public class RacingGame {
  private final List<Car> cars;
  private final int rounds;
  private final Random random = new Random();

  public RacingGame(List<String> carNames, int rounds) {
    this.cars = createCars(carNames);
    this.rounds = rounds;
  }

  private List<Car> createCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return cars;
  }

  public void play(BufferedWriter bw) throws IOException {
    for (int i = 0; i < rounds; i++) {
      for (Car car : cars) {
        int randomValue = random.nextInt(10);
        car.move(randomValue);
      }

      bw.write("Round " + (i + 1) + " Results:\n");
      for (Car car : cars) {
        bw.write(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
      }
      bw.write("\n");
      bw.flush();
    }
  }

  public List<String> findWinners() {
    int maxPosition = 0;
    List<String> winners = new ArrayList<>();

    for (Car car : cars) {
      if (car.getPosition() > maxPosition) {
        maxPosition = car.getPosition();
      }
    }

    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }

    return winners;
  }

  public List<Car> getCars() {
    return cars;
  }
}