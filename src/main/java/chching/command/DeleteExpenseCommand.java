package chching.command;

import chching.ChChingException;
import chching.Storage;
import chching.Ui;
import chching.record.ExpenseList;
import chching.record.IncomeList;

public class DeleteExpenseCommand extends Command {
    private final int index;
    public DeleteExpenseCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(IncomeList incomes, ExpenseList expenses, Ui ui, Storage storage) throws ChChingException {
        if(index <0){
            throw new ChChingException("Negative index");
        }
        else if(index >= incomes.size()){
            throw new ChChingException("The number is too big");
        }
        expenses.deleteExpense(index);
        System.out.println("Expense deleted, here is the updated list:");
        expenses.printExpenseList();
    }
    
}
