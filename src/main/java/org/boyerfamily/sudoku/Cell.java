package org.boyerfamily.sudoku;

import java.util.BitSet;

public class Cell {
    private final int row;
    private final int column;
    private final BitSet rowValues;
    private final BitSet columnValues;
    private final BitSet gridValues;
    private Value value = null;

    public Cell(BitSet rowValues, BitSet columnValues, BitSet gridValues, int row, int column) {
        this.rowValues = rowValues;
        this.columnValues = columnValues;
        this.gridValues = gridValues;
        this.row = row;
        this.column = column;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        if (value == null) {
            return;
        }

        if (rowValues.get(value.ordinal()) || columnValues.get(value.ordinal()) ||
                gridValues.get(value.ordinal())) {
            throw new RuntimeException("Inserting duplicate value");
        }

        this.value = value;
        this.rowValues.set(value.ordinal());
        this.columnValues.set(value.ordinal());
        this.gridValues.set(value.ordinal());
    }

    public void setValue(Integer i) {
        this.setValue(Value.fromInt(i));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public BitSet getRowValues() {
        return rowValues;
    }

    public BitSet getColumnValues() {
        return columnValues;
    }

    public BitSet getGridValues() {
        return gridValues;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;
        return value != cell.value;
    }
}
