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
        BigInteger n = initialNumber.abs();
        while (n.compareTo(div.pow(2)) == 1 || n.compareTo(div.pow(2)) == 0) {
            if (n.remainder(div).equals(BigInteger.ZERO)) {
                primeFactors.add(div);
                n = n.divide(div);
            } else {
                div = (div.add(BigInteger.ONE));
            }
        }
        primeFactors.add(n);
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
