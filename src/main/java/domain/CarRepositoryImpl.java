package domain;

import static utils.Constant.ADD_POINT;
import static utils.Constant.MOVING_STANDARD_NUM;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import strategy.MovingStrategy;

public class CarRepositoryImpl implements CarRepository{

    private Map<Car, Integer> carBoard;

    @Override
    public void cycleCars(MovingStrategy movingStrategy) {
        for (Car car : carBoard.keySet()) {
            move(car, movingStrategy.getNum());
        }
    }

    @Override
    public void move(Car car, int number) {
        if (isAllowedToMove(number)) {
            carBoard.put(car, carBoard.get(car) + ADD_POINT);
        }
    }

    @Override
    public boolean isAllowedToMove(int number) {
        if (number >= MOVING_STANDARD_NUM) {
            return true;
        }
        return false;
    }

    @Override
    public List<Car> findWinners() {
        int maxValue = Collections.max(carBoard.values());
        return carBoard.keySet().stream()
            .filter(x -> carBoard.get(x) == maxValue)
            .collect(Collectors.toList());
    }
    @Override
    public Map<Car, Integer> getCarBoard() {
        return carBoard;
    }

    @Override
    public void insertCarBoard(Map<Car, Integer> cars) {
        this.carBoard = cars;
    }
}
