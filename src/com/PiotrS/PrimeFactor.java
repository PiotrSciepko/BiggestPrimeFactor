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
        BigInteger n = initialNumber.abs();

        BigInteger div = BigInteger.TWO;
        while (n.remainder(div).equals(BigInteger.ZERO)) {
            primeFactors.add(div);
            n = n.divide(div);
        }
        div = BigInteger.valueOf(3);
        while (n.compareTo(div.pow(2)) > -1) {
            if (n.remainder(div).equals(BigInteger.ZERO)) {
                primeFactors.add(div);
                n = n.divide(div);
            } else {
                div = (div.add(BigInteger.TWO));
            }
        }
        if (n.compareTo(BigInteger.TWO) == 1) {
            primeFactors.add(n);
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
