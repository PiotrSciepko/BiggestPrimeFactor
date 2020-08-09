package com.PiotrS;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    int initialNumber;

    public PrimeFactor(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public List<Integer> getPrimeFactors() {
        List<Integer> primeFactors = new ArrayList<Integer>();

        int div = 2;
        while (initialNumber > 1) {
            while (initialNumber % div == 0) {
                primeFactors.add(div);
                initialNumber /= div;
            }
            div++;
        }
        return primeFactors;
    }

    public static void main(String[] args) {

        PrimeFactor p = new PrimeFactor(13);
        System.out.println(p.getPrimeFactors());

    }
}
