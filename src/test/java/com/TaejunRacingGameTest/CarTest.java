package com.TaejunRacingGameTest;

import com.TaejunRacingGame.Car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

  @Test
  void carShouldInitializeWithNameAndZeroPosition() {
    Car car = new Car("Car1");
    assertEquals("Car1", car.getName());
    assertEquals(0, car.getPosition());
  }

  @Test
  void carShouldMoveWhenRandomValueIsGreaterThanOrEqualToFour() {
    Car car = new Car("Car1");

    car.move(4);
    assertEquals(1, car.getPosition());

    car.move(7);
    assertEquals(2, car.getPosition());
  }

  @Test
  void carShouldNotMoveWhenRandomValueIsLessThanFour() {
    Car car = new Car("Car1");

    car.move(3);
    assertEquals(0, car.getPosition());

    car.move(0);
    assertEquals(0, car.getPosition());
  }

  @Test
  void shouldThrowExceptionForInvalidCarName() {
    assertThrows(IllegalArgumentException.class, () -> new Car("LongName"));
  }
}