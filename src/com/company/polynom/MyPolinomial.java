package com.company.polynom;


public class MyPolinomial {
    private double[] coeffs;

    public MyPolinomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree (){
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i= coeffs.length-1; i>=0; i--) {
            if (coeffs[i] == 0) continue;
            if ((coeffs[i] > 0) && (i!=coeffs.length-1))
                s.append("+");

            if ((int)coeffs[i] == coeffs[i])
                s.append((int)coeffs[i]);
            else
                s.append(coeffs[i]);

            if (i == 1)
                s.append("x");
            else if
            (i != 0) s.append("x^").append(i);
        }
        return s.toString();
    }

//    public double evaluate ( double x ){
//
//    }

    public MyPolinomial add (MyPolinomial right) {
        double[] add = new double[this.coeffs.length];
        for ( int i = 0; i <= this.coeffs.length-1; i++ ){
            add[i] = this.coeffs[i] + right.coeffs[i];
        }
        return new MyPolinomial(add);
    }

    public MyPolinomial multiply (MyPolinomial right){
        double[] add = new double[this.coeffs.length + right.coeffs.length];
        for (int i=this.coeffs.length-1;i>=0;i--) {
            for (int j=right.coeffs.length-1;j>=0;j--) {
                add[i+j] += this.coeffs[i] *right.coeffs[j];
            }
        }
        return new MyPolinomial(add);
    }
}
