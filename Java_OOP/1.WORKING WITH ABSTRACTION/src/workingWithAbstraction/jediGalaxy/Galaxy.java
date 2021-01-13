package workingWithAbstraction.jediGalaxy;

public class Galaxy {
    public Field field;

    public Galaxy(Field field) {
        this.field = field;
    }


    public void movieSith(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (field.isInBounds(row, col)) {
                field.setValue(row,col,0);
            }
            row--;
            col--;
        }
    }

    public long movieJedi(int row, int col) {
        long collectedPower=0;
        while (row >= 0 && col < this.field.getColLength(1)) {
            if (this.field.isInBounds(row, col)) {
                collectedPower += this.field.getValue(row,col);
            }

            row--;
            col++;
        }
        return collectedPower;
    }
}
