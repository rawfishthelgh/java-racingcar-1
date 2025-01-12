# https://leegeonhoe.notion.site/167ab019694c80f48784c9fb7d3fd449?pvs=4
import random as r

carList = input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)  ").split(',') #pobi,crong,honux
carCount = len(carList)
carData = [[car, 0] for car in carList]

roundCount = int(input("시도할 회수는 몇회인가요?:  "))

def printResult():
    for car, progress in carData:
        print(f'{car} : {"-"*progress}')

#시뮬레이션 실행
print("\n실행 결과")
for i in range(roundCount):
    for car in carData:
        if r.randrange(10) >= 4:
            car[1] += 1
        
    printResult()
    print()
    
    
# winners = [car for car, score in carData if score == max(car[1] for car in carData)] #튜플 언패킹 적용
winners = []
max_score = max(car[1] for car in carData)
for item in carData:
    if item[1] == max_score:
        winners.append(item[0])

print(f'\n{" ".join(winners)}가 최종 우승했습니다!') #join 메서드 : 리스트의 문자열 요소들을 하나로 합치는 역할, 구문자로 공백을 사용. spilt()의 반대과정이라고 생각하면 편함.