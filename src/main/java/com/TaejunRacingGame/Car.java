package com.TaejunRacingGame;

public class Car {
  private final String name;
  private int position;

  public Car(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("Car name cannot be longer than 5 characters");
    }
    this.name = name;
    this.position = 0;
  }

  public void move(int randomValue) {
    if (randomValue >= 4) {
      position++;
    }
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}