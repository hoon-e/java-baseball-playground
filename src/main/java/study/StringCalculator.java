package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 요구 사항
 * 1. 빈 공백 문자열을 기준으로 문자열 분리
 * 2. 숫자는 숫자대로, 연산자는 연산자대로
 * 2-1. 연산자가 어떤 연산을 하는지 선택해서 계산
 * 2-2. 뒤에 나눈 수가 0이면? - 불가함
 */
public class StringCalculator {

    public int calculateString(String inputString) {
        String[] strings = splitString(inputString);
        int sum = 0;

        int i=0;
        while(i < strings.length) {
            if(i == 0) {
                int mid = calculate(Integer.parseInt(strings[i]), Integer.parseInt(strings[i+2]), strings[i+1]);
                sum += mid;
                i += 4;
            } else {
                sum = calculate(sum, Integer.parseInt(strings[i]), strings[i-1]);
                i += 2;
            }
        }

        return sum;
    }

    public String inputString() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public String[] splitString(String inputString) {
        return inputString.split(" ");
    }

    public int calculate(int number1, int number2, String operand) {
        switch (operand) {
            case "*":
                return number1 * number2;
            case "-":
                return number1 - number2;
            case "/":
                if(number2 == 0) {
                    break;
                }
                return number1 / number2;
            case "+":
                return number1 + number2;
            default:
                // nothing
        }

        return Integer.MIN_VALUE;
    }
}