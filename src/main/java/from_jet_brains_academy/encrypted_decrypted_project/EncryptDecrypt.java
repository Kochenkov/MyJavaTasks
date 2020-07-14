package from_jet_brains_academy.encrypted_decrypted_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) throws IOException {

        // инициализация полей под параметры с консоли
        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";
        int key = 0;
        String alg = "shift";
        String answer = "";

        // считываем введенные с консоли параметры и сеттим их в переменные
        for (int i = 0; i < args.length; i++) {
            if ("-key".equals(args[i])) {
                key =  Integer.parseInt(args[i+1]);
            }
            if ("-mode".equals(args[i])) {
                mode = args[i+1];
            }
            if ("-data".equals(args[i])) {
                data = args[i+1];
            } else if ("-in".equals(args[i])) {
                in = args[i+1];
                data = takeDataFromFile(in);
            }
            if ("-out".equals(args[i])) {
                out = args[i+1];
            }
            if ("-alg".equals(args[i])) {
                alg = args[i+1];
            }
        }

        // выбор типа шифрования
        switch (mode) {
            case ("enc"):
                answer = (crypting(data, key, alg));
                break;
            case ("dec"):
                key = - key;
                answer = (crypting(data, key, alg));
                break;
        }

        // вывод на экран или в файл
        if ("".equals(out)) {
            System.out.println(answer);
        } else {
            writeDataToFile(out, answer);
        }
    }

    private static String takeDataFromFile(String inName) throws FileNotFoundException {
        File file = new File(inName);
        Scanner scan = new Scanner(file);
        String data = "";
        while(scan.hasNext()) {
            data = data + scan.nextLine();
        }
        return data;
    }

    private static void writeDataToFile(String fileName, String inData) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(inData);
        fileWriter.close();
    }

    private static String crypting(String inputStr, int key, String alg) {
        switch (alg) {
            case("shift"):
                return shiftMainAlg(inputStr, key);
            case("unicode"):
                return unicodeMainAlg(inputStr, key);
            default:
                return null;
        }
    }

    private static String unicodeMainAlg(String inputStr, int key) {
        char[] chArr = inputStr.toCharArray();
        int[] intArr = new int[chArr.length];
        for (int i=0; i<chArr.length; i++) {
            intArr[i] = (int) chArr[i];
            int a = intArr[i] + key;
            chArr[i] = (char) a;
        }
        return new String(chArr);
    }

    private static String shiftMainAlg(String inputStr, int key)  {
        char[] chArr = inputStr.toCharArray();
        int[] intArr = new int[chArr.length];
        for (int i=0; i<chArr.length; i++) {
            intArr[i] = (int) chArr[i];
            if (intArr[i]>=97 && intArr[i]<=122) {
                int dif = intArr[i] - 97 + key;
                if (dif <= 26 && dif>=0) {
                    chArr[i] = (char) (intArr[i]+key);
                } else if (dif<0) {
                    int b = dif + 26;
                    chArr[i] = (char) (b + 97);
                } else {
                    int b = dif - 26;
                    chArr[i] = (char) (b + 97);
                }
            }
        }
        return new String(chArr);
    }
}