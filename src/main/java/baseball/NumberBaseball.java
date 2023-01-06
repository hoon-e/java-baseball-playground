package baseball;

import java.util.Random;
import java.util.Scanner;

/*
1. UI
   - [x] 게임 사용자가 입력 - 반복
   - [ ] 게임 새로 시작
2. 컴퓨터의 숫자 - 1부터 9까지 3자리로 랜덤으로 구성
   - [ ] 1-1. 사용자 입력
3. 입력된 숫자에 따라 경우의 수 로직 구현
   - [ ] 같은 수 같은 자리 : 스트라이크
   - [ ] 수는 같으나 다른 자리 : 볼
   - [ ] 같은 수가 전혀 없다 : 포볼 혹은 낫띵
   - [ ] 숫자가 있느냐 없느냐에 따라서 출력의 값이 변경되어야 한다.
     - [ ] 볼이 먼저 나오므로, 볼 부터 체크
4. 게임 종료 후, 다시 시작 혹은 완전히 종료가 가능
 */

public class NumberBaseball {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String randomNumber = makeRandomNumber();

        while(true) {
            String inputNumber = inputUserString();

            int strike = checkStrike(randomNumber, inputNumber);
            int ball = checkBall(randomNumber, inputNumber);

            break;
        }
    }

    public static String inputUserString() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scn.nextLine();
    }

    public static String makeRandomNumber() {
        return String.valueOf(new Random().nextInt(1000));
    }

    public static int checkBall(String randomNumber, String inputNumber) {
        return 0;
    }

    public static int checkStrike(String randomNumber, String inputNumber) {
        return 0;
    }

    // nothing은 스트라이크랑 볼 없으면 그냥 nothing
    // 비교 로직 필요 없을 듯
    public static int checkNothing(String randomNumber, String inputNumber) {

    }
}