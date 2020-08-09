package com.PiotrS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactor {
    final int initialNumber;

    public PrimeFactor(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public List<Integer> getPrimeFactors() {
        List<Integer> primeFactors = new ArrayList<>();
        int div = 2;
        int n = initialNumber;
        while (n > 1) {
            while (n % div == 0) {
                primeFactors.add(div);
                n /= div;
            }
            //div++;
            div += (div == 2) ? 1 : 2;
        }
        return primeFactors;
    }

    public List<Integer> getMaxPrimeFactors(List<Integer> list) {
        List<Integer> maxPrimesFirst = new ArrayList<>();
        int n = initialNumber;
        int i = list.size() - 1;
        int div;
        while (n > 1) {
            div = list.get(i);
            while (n % div == 0) {
                maxPrimesFirst.add(div);
                n /= div;
            }
            i--;
        }
        return maxPrimesFirst;
    }

    public boolean isPrime() {
        return getPrimeFactors().size() == 1;
    }

    public static void main(String[] args) {

        PrimeFactor p = new PrimeFactor(256);

        List<Integer> primeFactors = p.getPrimeFactors();
        System.out.println(primeFactors);

        System.out.println(p.getMaxPrimeFactors(primeFactors));

        Collections.reverse(primeFactors);
        System.out.println(primeFactors);

        System.out.println(p.isPrime());

    }
}
