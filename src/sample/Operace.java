package sample;

public class Operace {

    String generovat(int min, int max){
        return String.valueOf(min + Math.round(Math.random() * (max - min)));
    }

    String dec2bin(String dec){
        return Integer.toBinaryString(Integer.valueOf(dec));
    }

    String dec2hex(String dec){
        return Integer.toHexString(Integer.valueOf(dec));
    }
}
