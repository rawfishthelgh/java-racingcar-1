package com.TaejunRacingGameTest;

import com.TaejunRacingGame.RacingGame;
import com.TaejunRacingGame.Car;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

  @Test
  void shouldCreateCarsFromNames() {
    List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
    RacingGame game = new RacingGame(carNames, 5);

    List<String> createdCarNames = new ArrayList<>();
    for (Car car : game.getCars()) {
      createdCarNames.add(car.getName());
    }

    assertTrue(createdCarNames.containsAll(carNames));
    assertEquals(carNames.size(), createdCarNames.size());
  }

  @Test
  void shouldFindWinnersCorrectly() {
    List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
    RacingGame game = new RacingGame(carNames, 1);

    for (Car car : game.getCars()) {
      if (car.getName().equals("Car1")) {
        car.move(4);
      }
    }

    List<String> winners = game.findWinners();

    assertEquals(1, winners.size());
    assertEquals("Car1", winners.get(0));
  }
}