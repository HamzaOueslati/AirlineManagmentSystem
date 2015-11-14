/**
 * Created by hamza on 02/11/2015.
 */
public class SeatID {
    private Integer row;
    private char column;

    public SeatID(Integer row, char column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void display() {
        System.out.println("colonne du siège: " + getColumn() + "Rang du siège : " +getRow());
    }
}
