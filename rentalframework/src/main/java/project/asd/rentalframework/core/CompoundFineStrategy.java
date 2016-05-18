package project.asd.rentalframework.core;

/**
 * Created by lokex on 5/17/16.
 * Calculates fine bassed on fixed basic fine compunded on fixed rate
 */
public class CompoundFineStrategy extends AbstractFineStrategy {


    private int numberOfDaysOverdue;
    private double fixedAmount;
    private double compoundInterest;

    public CompoundFineStrategy(int numberOfDaysOverdue, double basicFine, double compoundInterestRate){
        this.numberOfDaysOverdue = numberOfDaysOverdue;
        this.fixedAmount = basicFine;
        this.compoundInterest = compoundInterestRate;

    }


    @Override
    public double apply() {

        for (int i=0;i<numberOfDaysOverdue;i++){

            double dailyFine = fixedAmount * compoundInterest/100;
            fixedAmount+= dailyFine;
        }

        return  fixedAmount;

    }
}
