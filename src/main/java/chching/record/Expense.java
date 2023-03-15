package chching.record;

public class Expense extends Record {
    private final String category;

    public Expense(String category, String description, String date, double value) {
        super(description, date, value);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Category - " + getCategory() +
                " | Description - " + getDescription() +
                " | Date - " + getDate() +
                " | Value - " + String.format("%.2f", getValue());
    }
    
    @Override
    public String toString() {
        return " Category - " + getCategory() +
                " | Description - " + getDescription() +
                " | Date - " + getDate() +
                " | Value - " + String.format("%.02f", getValue());
    }

}
