package com.PiotrS;

import java.util.ArrayList;
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
            div += (div == 2) ? 1 : 2;
        }
        return primeFactors;
    }

    public boolean isPrime() {
        return getPrimeFactors().size() == 1;
    }

    public static void main(String[] args) {

	    int arg;
	    try {
	        arg = Integer.parseInt(args[0]);
        }
	    catch (Exception e){
            arg = 0;
        }

        PrimeFactor p = new PrimeFactor(arg);
        List<Integer> primeFactors = p.getPrimeFactors();
        System.out.println("\n{" + arg + "} -> " +primeFactors);
        System.out.println("isPrime: " + p.isPrime());
        System.out.println();

    }
}
