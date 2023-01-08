package baseball;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
    public static Scanner scn = new Scanner(System.in);

    public enum GameStatus {
        RESTART,
        KEEP_PLAYING,
        STOP_PLAYING
    }

    public static void main(String[] args) {

        // 처음 랜덤 넘버 생성
        String randomNumber = makeRandomNumber();

        GameStatus flag = GameStatus.KEEP_PLAYING;

        while( flag == GameStatus.KEEP_PLAYING || flag == GameStatus.RESTART ) {
            String inputNumber = inputUserString();
            flag = playBaseballGame(randomNumber, inputNumber);

            // flag == 2라면 맞춰서 게임 재시작 하는 경우
            if( flag == GameStatus.RESTART ) {
                randomNumber = makeRandomNumber();
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    // 게임 수행
    public static GameStatus playBaseballGame(String randomNumber, String inputNumber) {

        // 스트라이크 체크
        // 3스트라이크라면 바로 리턴
        int strike = checkStrike(randomNumber, inputNumber);

        if( strike == 3 ) {
            return gameRestart();
        }

        // 볼 체크
        int ball = checkBall(randomNumber, inputNumber);

        // 스트라이크와 볼이 모두 없는 경우 - 포볼
        printResult(ball, strike);

        return GameStatus.KEEP_PLAYING;
    }

    public static GameStatus gameRestart() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

        String gameFlag = scn.nextLine();

        while(!gameFlag.equals("1") && !gameFlag.equals("2")) {
            System.out.println("1 혹은 2을 입력해주세요. ");
            gameFlag = scn.nextLine();
        }

        if(gameFlag.equals("1")) {
            return GameStatus.RESTART;
        } else {
            return GameStatus.STOP_PLAYING; // 게임 종료
        }
    }

    public static int checkStrike(String randomNumber, String inputNumber) {
        int count = 0;

        for(int i = 0; i < randomNumber.length(); i++) {
            if(randomNumber.charAt(i) == inputNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int checkBall(String randomNumber, String inputNumber) {
        int count = 0;

        for(int i = 0; i < randomNumber.length(); i++ ) {
            if((randomNumber.charAt(i) != inputNumber.charAt(i)) && (inputNumber.contains(String.valueOf(randomNumber.charAt(i))))) {
                count++;
            }
        }
        return count;
    }

    // 결과 출력
    public static void printResult(int ball, int strike) {
        if( ball != 0 ) {
            System.out.print(ball + "볼 ");
        }

        if( strike != 0 ) {
            System.out.print(strike + "스트라이크");
        }

        if( ball == 0 && strike == 0 ) {
            System.out.print("포볼");
        }

        System.out.println();
    }

    // 숫자 입력 받는 UI
    public static String inputUserString() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scn.nextLine();
    }

    // 3자리의 숫자가 모두 겹치지 않도록
    public static String makeRandomNumber() {
        boolean[] selected = new boolean[10];

        int checked = 0;
        StringBuilder sb = new StringBuilder();

        while(checked < 3) {
            int selectIdx = new Random().nextInt(10);

            if(!selected[selectIdx]) {
                sb.append(selectIdx);
                selected[selectIdx] = true;
                checked++;
            }
        }

        return sb.toString();
    }
}