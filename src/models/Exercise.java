package models;
import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        while (line.length() > 0) {
            sort(line);
            line = console.nextLine();
        }
    }
 
    public static void sort(String line) {
        int seconds = Integer.valueOf(line);
        int ledCounter = 0;
        String actualHour;
        while (seconds >= 0) {
        	actualHour = toHour(seconds);
        	ledCounter += ledCounter(actualHour);
            seconds--;
        }
        System.out.println(ledCounter);
    }
 
    public static int ledCounter(String hour) {
        int resultado = 0;
        for (int i = 0; i < hour.length(); i++) {
            switch (hour.charAt(i)) {
                case '1':
                    resultado += 2;
                    break;
                case '2':
                case '3':
                case '5':
                    resultado += 5;
                    break;
                case '4':
                    resultado += 4;
                    break;
                case '6':
                case '9':
                case '0':
                    resultado += 6;
                    break;
                case '7':
                    resultado += 3;
                    break;
                case '8':
                    resultado += 7;
            }
        }
        return resultado;
    }
 
    public static String fill(int data) {
        String temp = String.valueOf(data);
        if (temp.length() < 2) {
            return "0" + temp;
        } else {
            return temp;
        }
    }
    
    public static String toHour(int seconds) {
        int hours = seconds / 3600;
        int surplus = seconds % 3600;
        int minutes = surplus / 60;
        surplus = surplus % 60;
        return fill(hours) + fill(minutes) + fill(surplus);
    }
 


	

}
