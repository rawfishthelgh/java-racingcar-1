
//RandomMove를 따로 클래스로 만들었기때문에 randommove인터페이스를 사용해야되고
// 이를위해 고정값을 반환하는 fixedMove클래스를 만듬

public class FixedMove implements MoveStrategy {
    private final int fixedValue;

    public FixedMove(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int getMoveDistance() {
        return fixedValue; // 고정된 값 반환
    }
}