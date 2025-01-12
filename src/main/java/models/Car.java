package models;

public class Car {
    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void incrementProgress() {
        this.progress++;
    }

    @Override
    public String toString() {
        return name; // Car 객체를 출력할 때 이름만 반환하도록 설정
    }
}
