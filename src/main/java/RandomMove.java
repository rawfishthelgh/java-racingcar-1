import java.util.Random;

public class RandomMove implements MoveStrategy {
    private final Random random = new Random();

    @Override
    public int getMoveDistance() {
        return random.nextInt(10); // 0~9 사이 값 생성
    }
}

