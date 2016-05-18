package project.asd.rentalframework.checkin;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Audi on 5/18/2016.
 */
public class BusinessController {
    private ICommand currentCommand;
    private ArrayList<ICommand> commandsExecuted;

    public void setCommand(ICommand command) {
        currentCommand = command;
    }

    public void execute(){
        currentCommand.execute();
        commandsExecuted.add(currentCommand);
    }

    public void undoCommand(Transaction transaction) {
        ICommand command = null;
        for(ICommand cmd : commandsExecuted){
            if(command.getTransaction().getTransactionId() == transaction.getTransactionId()){
                command = cmd;
                command.undo();
                commandsExecuted.remove(command);
                Log.d("Undo Transaction", "Undo successfully!");
                return;
            }
        }
        Log.d("Undo Transaction", "Cannot find the transaction");
    }
}
