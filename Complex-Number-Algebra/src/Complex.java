/**
 * Complex class
 * Created by Julian D. Quitian on 12/25/2015.
 */
public class Complex {
    //Complex : real + (imaginary)i
    public double real, imaginary;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(){
        this.real = 0;
        this.imaginary = 0;
    }
    public Complex getSum(Complex ... args){
        Complex sum = new Complex(this.real, this.imaginary);
        for(Complex i : args){
            sum.real += i.real;
            sum.imaginary += i.imaginary;
        }
        return sum;
    }
    public Complex getDifference(Complex ... args){
        Complex dif = new Complex(this.real, this.imaginary);
        for(Complex i : args){
            dif.real -= i.real;
            dif.imaginary -= i.imaginary;
        }
        return dif;
    }
    public Complex getProduct(Complex a, Complex b){
        Complex product = new Complex();
        product.real = (a.real * b.real) - (a.imaginary * b.imaginary);
        product.imaginary = (a.real * b.imaginary) + (a.imaginary * b.real);
        return product;
    }
    public Complex getNegation(){
        Complex negation = this;
        negation.real = -(this.real);
        negation.imaginary = -(this.imaginary);
        return negation;
    }
    public Complex getInverse(Complex a){
        Complex inverse = new Complex();
        inverse.real = a.real / (a.real * a.real + a.imaginary * a.imaginary);
        inverse.imaginary = (- a.imaginary) / (a.real * a.real + a.imaginary * a.imaginary);
        return inverse;
    }


    public String toString(){
        String real, imaginary;
        if(this.real == 0 && this.imaginary == 0)
            return "0";
        if(this.real == 0 && this. imaginary == 1)
            return "i";
        if(this.real == 0 && this.imaginary > 1)
            return "" + this.imaginary + "i";
        if(this.real == 0 && this.imaginary < 0)
            return "-" + this.imaginary + "i";
        return this.real + " + " + this.imaginary + "i";
    }
}
