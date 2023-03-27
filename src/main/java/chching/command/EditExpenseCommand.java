package chching.command;

import chching.ChChingException;
import chching.Storage;
import chching.Ui;
import chching.currency.Converter;
import chching.currency.Selector;
import chching.parser.Expenses;
import chching.record.Expense;
import chching.record.ExpenseList;
import chching.record.IncomeList;
import chching.record.TargetStorage;

import java.util.HashMap;

/**
 * Models a class to handle the EditExpense command. Inherited from Command class.
 */
public class EditExpenseCommand extends Command {
    private int index;
    private HashMap<String, String> argumentsByField;
    private boolean hasCategory;
    private boolean hasDescription;
    private boolean hasDate;
    private boolean hasValue;


    public EditExpenseCommand(HashMap<String, String> argumentsByField) throws ChChingException {
        this.argumentsByField = argumentsByField;
    
        index = Expenses.getIndex(argumentsByField);
        hasCategory = argumentsByField.containsKey("c");
        hasDescription = argumentsByField.containsKey("de");
        hasDate = argumentsByField.containsKey("da");
        hasValue = argumentsByField.containsKey("v");
    }

    /**
     * Executes edit of expenses.
     * Based on the fields the user wants to edit, the corresponding fields will be edited.
     *
     * @param incomes       ArrayList of income.
     * @param expenses      ArrayList of income.
     * @param ui        User interface.
     * @param storage       Storage of data.
     * @param converter     Convert value.
     * @param targetStorage store target.
     * @throws ChChingException if the index is invalid or if there is no field to edit.
     */
    @Override
    public void execute(IncomeList incomes, ExpenseList expenses, Ui ui, Storage storage, Selector selector,
                        Converter converter, TargetStorage targetStorage) throws ChChingException {
        // check if the index is valid
        if (index <= 0) {
            throw new ChChingException("Negative/Zero index");
        } else if (index > expenses.size()) {
            throw new ChChingException("The index is too big");
        }
        assert index > 0 : "Index must be a positive integer";
        
        if (!hasCategory && !hasDescription && !hasDate && !hasValue) {
            throw new ChChingException("No fields to edit");
        }
        // change from 1-based indexing to 0-based indexing
        int indexZeroBased = index - 1;
        Expense expense = expenses.get(indexZeroBased);
        
        // edit the fields accordingly
        if (hasCategory) {
            String value = argumentsByField.get("c");
            expenses.editExpense(index, "c", value);
        }
        if (hasDescription) {
            String value = argumentsByField.get("de");
            expenses.editExpense(index, "de", value);
        }
        if (hasDate) {
            String value = argumentsByField.get("da");
            expenses.editExpense(index, "da", value);
        }
        if (hasValue) {
            String value = argumentsByField.get("v");
            expenses.editExpense(index, "v", value);
        }
        
        boolean isExpense = true;
        ui.showEdited(index, expense, isExpense);
    }
}
