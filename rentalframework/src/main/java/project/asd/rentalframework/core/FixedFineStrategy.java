package project.asd.rentalframework.core;

/**
 * Created by lokex on 5/17/16.
 */
public class FixedFineStrategy extends AbstractFineStrategy {


    private int numberOfDaysOverdue;
    private double fixedAmount;

    public FixedFineStrategy(int numberOfDaysOverdue, double fixedAmount){
        this.numberOfDaysOverdue = numberOfDaysOverdue;
        this.fixedAmount = fixedAmount;
    }


    @Override
    public double apply() {
        return numberOfDaysOverdue * fixedAmount;
    }
}
