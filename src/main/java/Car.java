public class Car {
    private final String name;
    private int position = 1; // 시작부터 1칸씩 있게 시작

    public Car(String name) {
        validateName(name); // 이름 유효성 검사
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        int moveDistance = moveStrategy.getMoveDistance();
        if (moveDistance >= 4) { // 4 이상일 때만 이동
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}