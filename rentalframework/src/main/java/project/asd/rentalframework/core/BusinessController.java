package project.asd.rentalframework.core;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Audi on 5/18/2016.
 */
public class BusinessController {
    private ICommand currentCommand;
    private ArrayList<ICommand> commandsExecuted;

    public BusinessController(){
        commandsExecuted = new ArrayList<>();
    }

    public void setCommand(ICommand command) {
        currentCommand = command;
    }

    public void execute(){
        currentCommand.execute();

        //If command is Settle --> remove from executed command List --> because we don't need to support undo for them
        if(currentCommand instanceof SettleCommand){
            Transaction transaction = currentCommand.getTransaction();
            for(ICommand cmd : commandsExecuted){
                if(transaction.getTransactionId() == transaction.getTransactionId()){
                    commandsExecuted.remove(cmd);
                }
            }
        }
    }


    public void undoCommand(Transaction transaction) {
        for(ICommand cmd : commandsExecuted){
            if(cmd.getTransaction().getTransactionId() == transaction.getTransactionId()){
                cmd.undo();
                commandsExecuted.remove(cmd);
                Log.d("Undo Transaction", "Undo successfully!");
                return;
            }
        }
        Log.d("Undo Transaction", "Cannot find the transaction");
    }

}
