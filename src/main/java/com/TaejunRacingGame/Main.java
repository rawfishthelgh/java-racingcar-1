package com.TaejunRacingGame;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write("경주할 자동차 이름을 입력하세요(심표로 구분):");
    bw.flush();

    String input = br.readLine();
    List<String> carNames = Arrays.asList(input.split(","));

    bw.write("시도할 횟수는 몇 회인가요?");
    bw.flush();
    int rounds = Integer.parseInt(br.readLine());

    RacingGame game = new RacingGame(carNames, rounds);
    game.play(bw);

    List<String> winners = game.findWinners();

    bw.write(String.join(", ", winners) + "가 최종 우승했습니다!\n");
    bw.flush();
  }
}