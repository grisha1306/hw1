package com.company.complex;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex () {

    }

    public MyComplex (double real, double imag ) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString () {
        if ( this.imag < 0.0 )
            return "(" + real + " - " + Math.abs(imag) + "i)";
        else
            return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal() {
        return !((this.real - 0.0) <= 0.00001);
    }

    public boolean isImaginary() {
        return !((this.imag - 0.0) <= 0.00001);
    }

    public boolean equals (double real, double imag) {
        return  (Math.abs((this.real - real)) <= 0.00001 && Math.abs((this.imag - imag)) <= 0.00001);
    }

    public boolean equals (MyComplex another) {
        return Math.abs((this.real - another.real)) <= 0.00001 && Math.abs((this.imag - another.imag)) <= 0.00001;
    }

    public double magnitude() {
        return Math.sqrt( Math.pow(this.real, 2) + Math.pow(this.imag,2));
    }


    public double argument() {
        if ( this.real > 0.0)
            return Math.atan(this.imag/this.real);
        else {
            if( this.real < 0.0 && this.imag > 0.0 )
                return Math.PI + Math.atan(this.imag/this.real);
            else
                return Math.PI - Math.atan(this.imag/this.real);
        }
    }

    public MyComplex add ( MyComplex right ){
        setValue((this.real + right.real),(this.imag + right.imag));
        return this;
    }

    public MyComplex addNew (MyComplex right) {
        return new MyComplex((this.real + right.real),(this.imag + right.imag));
    }

    public MyComplex substractNew (MyComplex right) {
        return new MyComplex((this.real - right.real),(this.imag - right.imag));
    }

    public MyComplex substract ( MyComplex right ){
        setValue((this.real - right.real),(this.imag - right.imag));
        return this;
    }

    public MyComplex multiply (MyComplex right ) {
        setValue( (this.real * right.real - this.imag* right.imag), (this.imag*right.real + this.real*right.imag) );
        return this;
    }

    public MyComplex divide (MyComplex right ) {
        double real = (this.real*right.real + this.imag* right.imag) / (right.real* right.real + right.imag* right.imag);
        double imag = (this.imag*right.real - this.real* right.imag) / (right.real* right.real + right.imag* right.imag);
        setValue(real,imag);
        return this;
    }

    public MyComplex conjugate () {
        setValue(this.real, -this.imag);
        return this;
    }

}
