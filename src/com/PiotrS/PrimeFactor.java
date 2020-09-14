package com.PiotrS;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    final long initialNumber;

    public PrimeFactor(long initialNumber) {
        this.initialNumber = initialNumber;
    }

    public List<Long> getPrimeFactors() {
        List<Long> primeFactors = new ArrayList<>();
        long div = 2;
        long n = initialNumber;
        while (Math.abs(n) > 1) {
            while (n % div == 0) {
                primeFactors.add(div);
                n /= div;
            }
            div += (div == 2) ? 1 : 2;
        }
        return primeFactors;
    }

    public boolean isPrime() {
        return getPrimeFactors().size() == 1;
    }

    public static void main(String[] args) {

	    long arg;
	    try {
	        arg = Long.parseLong(args[0]);
        } catch (Exception e){
	        arg = 0;
        }

        PrimeFactor p = new PrimeFactor(arg);
        List<Long> primeFactors = p.getPrimeFactors();
        System.out.println("\n" + arg + " -> " + primeFactors);
        //System.out.println("isPrime: " + p.isPrime());
        System.out.println();

    }
}
