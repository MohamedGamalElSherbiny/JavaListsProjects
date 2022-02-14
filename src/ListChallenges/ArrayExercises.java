package ListChallenges;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercises {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int count = readInteger();

        int[] myArray = readElements(count);
        int[] mySortedArray = sortIntegers(myArray);

        System.out.println("\nYour original Array is:");
        printArray(myArray);
        System.out.println("\nYour sorted Array is:");
        printArray(mySortedArray);

        int[] reversedArray = reverseArray(myArray);
        System.out.println("\nReversed Array is " + Arrays.toString(reversedArray));

        int minimumValue = findMin(myArray);
        System.out.println("\nThe minimum element of the array = " + minimumValue);
    }

    private static int readInteger(){
        System.out.print("Please enter the number of elements in the array: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    private static int[] readElements(int count){
        int[] myArray = new int[count];
        for(int i = 0; i < count; i++){
            System.out.print("Please enter your #" + (i+1) + " number: ");
            myArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return myArray;
    }

    private static int[] sortIntegers(int[] array){
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for (int i = 0; i < array.length - 1; i++){
                if(array[i] < array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

    private static int findMin(int[] array){
        int minValue = array[0];
        for(int i = 1; i < array.length; i++){
            if(minValue > array[i]){
                minValue = array[i];
            }
        }
        return minValue;
    }

    private static int[] reverseArray(int[] array){
        int temp;
        int size = array.length;
        for (int i = 0; i < (size/2); i++){
            temp = array[i];
            array[i] = array[size - (i + 1)];
            array[size - (i + 1)] = temp;
        }
        return array;
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Element #" + (i + 1) + " = " + array[i]);
        }
    }
}
