package com.peace.amz;

/*
 *  Given a array of numbers arr and an integer size of arr
 *  Return the GDC of all numbers of array
 */
class GenericGdc {

    public int generalizedGCD(int num, int[] arr) {
        // assuming arr is sorted from smaller to biggest
        // starting from the smallest at index 0, check if reminder is zero
        int startfrom = arr[0];
        boolean divideAllNumbers = true;

        for (; startfrom > 0; startfrom--) {
            for (int i = 0; i < num; i++) {
                int reminder = arr[i] % startfrom;

                if (reminder != 0) {
                    divideAllNumbers = false;
                    break;
                } else {
                    divideAllNumbers = true;
                    continue;
                }
            }

            if (divideAllNumbers) {
                return startfrom;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int gdc = new GenericGdc().generalizedGCD(2, new int[] { 9, 81, 162 });
        System.out.println(gdc);
    }
}