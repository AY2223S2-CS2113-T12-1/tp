package seedu.duke;

import seedu.duke.data.RecordList;
import seedu.duke.data.Record;

import java.util.Scanner;

public class Ui {

    public String readCommand() {
        Scanner input = new Scanner((System.in));
        String fullCommand = input.nextLine();
        return fullCommand;
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void showWelcome() {
        showLine();
        System.out.println("    Hello! I'm ChChing.");
        System.out.println("    What can I do for you?");
        showLine();
    }

    public void showGoodbye() {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    public void showAdded(RecordList records, Record record) {
        System.out.println("    Got it. I've added this record:");
        System.out.println("    " + record);
        System.out.println("    Now you have " + records.getRecordCount() + " records in the list.");
    }

    public void showDelete(RecordList records, Record record) {
        System.out.println("    Noted. I've removed this record:");
        System.out.println("    " + record);
        System.out.println("    Now you have " + records.getRecordCount() + " records in the list.");
    }

    public void showAllRecords(RecordList records) {
        System.out.println("    Here are the records in your list:");

        records.printRecordList();
    }

    public void showBalance() {
        System.out.println("    Current balance:");
        System.out.println("    SGD 0.00");
    }


    public void showHelp() {
        System.out.println("    ADD RECORDS:");
        System.out.println("    add expense /c <category> /de <description> /da <date> /v <value>");
        System.out.println("    add income");
        System.out.println();
        System.out.println("    SHOW ALL RECORDS:");
        System.out.println("    list");
        System.out.println();
        System.out.println("    EDIT RECORDS:");
        System.out.println("    edit expense <index> /c <category> /de <description> /da <date> /v <value>");
        System.out.println("    edit income <index>");
        System.out.println();
        System.out.println("    DELETE RECORDS:");
        System.out.println("    delete expense <index>");
        System.out.println("    delete income <index>");
        System.out.println();
        System.out.println("    SHOW BALANCE:");
        System.out.println("    balance");
        System.out.println();
        System.out.println("    SHOW HELP:");
        System.out.println("    help");
        System.out.println();
        System.out.println("    EXIT THE PROGRAM:");
        System.out.println("    exit");
    }

    public void showError(String message) {
        System.out.println("    " + message);
    }
}