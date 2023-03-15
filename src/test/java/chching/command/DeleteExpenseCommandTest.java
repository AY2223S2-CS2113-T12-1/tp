package chching.command;

import chching.Storage;
import chching.Ui;
import chching.record.Expense;
import chching.record.ExpenseList;
import chching.record.IncomeList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class DeleteExpenseCommandTest {
    static final int OFFSET = 1;
    static final int CORRECT_INDEX = 1;
    static final int TOO_LARGE_INDEX = 5;
    static final int NEGATIVE_INDEX = -1;

    static final String SPENDING_CATEGORY = "entertainment";
    static final String SPENDING_DESCRIPTION = "movie";

    static final String SPENDING_DATE = "02/10/23";
    static final float SPENDING_EXPENSE_VALUE = (float) 10.50;

    static final String GROCERIES_CATEGORY = "entertainment";
    static final String GROCERIES_DESCRIPTION = "movie";

    static final String GROCERIES_DATE = "02/10/23";
    static final float GROCERIES_EXPENSE_VALUE = (float) 500;
    private Ui ui;
    private Storage storage;
    private Expense spending;
    private Expense groceries;
    private ExpenseList defaultExpenseList;
    private IncomeList emptyIncomeList;
    
    @BeforeEach
    void setup() {
        ui = new Ui();
        spending = new Expense(SPENDING_CATEGORY, SPENDING_DESCRIPTION , SPENDING_DATE, SPENDING_EXPENSE_VALUE);
        groceries = new Expense(GROCERIES_CATEGORY,GROCERIES_DESCRIPTION,GROCERIES_DATE,GROCERIES_EXPENSE_VALUE);
        
        
        ArrayList<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(spending);
        expenseList.add(groceries);
        defaultExpenseList = new ExpenseList(expenseList);
    }

    @Test
    void execute_positiveIntegerWithinSize_success(){
        int defaultExpenseListSize = defaultExpenseList.size();
        Command command = new DeleteExpenseCommand(CORRECT_INDEX);
        try {
            command.execute(emptyIncomeList, defaultExpenseList, ui, storage);
            assertEquals(defaultExpenseListSize - OFFSET, defaultExpenseList.size(), "Delete expense working");
        } catch (Exception e) {
            fail(); // test should not reach this line
        }
    }

    @Test
    void execute_positiveIntegerOutsideSize_exceptionThrown() {
        String expectedOutput = "The number is too big";
        Command command = new DeleteExpenseCommand(TOO_LARGE_INDEX);
        try {
            command.execute(emptyIncomeList, defaultExpenseList, ui, storage);
            fail(); // test should not reach this line
        } catch (Exception e) {
            assertEquals(expectedOutput, e.getMessage(), "Delete expense with integer outside size is not captured");
        }
    }

    @Test
    void execute_negativeInteger_exceptionThrown() {
        String expectedOutput = "Negative/Zero index";
        Command command = new DeleteExpenseCommand(NEGATIVE_INDEX);
        try {
            command.execute(emptyIncomeList, defaultExpenseList, ui, storage);
            fail(); // test should not reach this line
        } catch (Exception e) {
            assertEquals(expectedOutput, e.getMessage(), "Delete expense with negative integer is not captured");
        }
    }
}
