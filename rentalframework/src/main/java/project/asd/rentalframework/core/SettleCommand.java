package project.asd.rentalframework.core;

import android.util.Log;

/**
 * Created by Audi on 5/18/2016.
 */
public class SettleCommand implements ICommand {
    private Transaction transaction;

    public SettleCommand(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public void execute() {
        transaction.finalizeTransaction();
    }

    @Override
    public void undo() {
        Log.d("SettleCommand", "Not support cancel the Finalized Transaction");
        return; //Not support for Settle
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }
}
