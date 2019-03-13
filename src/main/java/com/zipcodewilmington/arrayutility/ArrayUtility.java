package com.zipcodewilmington.arrayutility;


import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arraysToMerge, T valueToEvaluate) {
        array = mergeArrays(arraysToMerge);
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommonElement = null;
        Integer count = 0;

        T [] temp = mergeArrays(arrayToMerge);
        for (T element: temp) {
            if(getNumberOfOccurrences(element) > count){
                count = getNumberOfOccurrences(element);
                mostCommonElement = element;
            }
        }
        return mostCommonElement;
    }

    public Integer getNumberOfOccurrences(T object) {

        Integer counter = 0;
        for (T element : array) {
            if (element == object) {

                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T object) {
        Integer j = 0;
        T[] answer = Arrays.copyOf(array,array.length - getNumberOfOccurrences(object));
        for (int i = 0; i < array.length; i++) {
            if(array[i] != object){
                answer[j] = array[i];
                j++;
            }
        }
        return answer;
    }

    public T[] mergeArrays(T[] arrayToMerge) {
        T[] answer = Arrays.copyOf(array, array.length + arrayToMerge.length);
        for (int i = 0; i < array.length ; i++) {
            answer[i] = array[i];
        }
        for (int i = array.length, j = 0; i < answer.length; i++, j++) {
            answer[i] = arrayToMerge[j];
        }
        return answer;
        }
    }

