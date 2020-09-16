package com.PiotrS;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    final BigInteger initialNumber;

    public PrimeFactor(BigInteger initialNumber) {
        this.initialNumber = initialNumber;
    }

    public List<BigInteger> getPrimeFactors() {
        List<BigInteger> primeFactors = new ArrayList<>();
        BigInteger div = BigInteger.TWO;
        BigInteger n = initialNumber;
        while (n.abs().compareTo(BigInteger.ONE) == 1) {
            while (n.remainder(div).equals(BigInteger.ZERO)) {
                primeFactors.add(div);
                n = n.divide(div);
            }
            if (div.equals(BigInteger.TWO)) {
                div = div.add(BigInteger.ONE);
            } else {
                div = div.add(BigInteger.TWO);
            }
        }
        return primeFactors;
    }

    public boolean isPrime() {
        return getPrimeFactors().size() == 1;
    }

    public static void main(String[] args) {

        BigInteger arg;
        try {
            arg = new BigInteger(args[0]);
        } catch (Exception e) {
            arg = BigInteger.ZERO;
        }

        PrimeFactor p = new PrimeFactor(arg);
        List<BigInteger> primeFactors = p.getPrimeFactors();
        System.out.println("\n" + arg + " -> " + primeFactors);
        //System.out.println("isPrime: " + p.isPrime());
        System.out.println();

    }
}
