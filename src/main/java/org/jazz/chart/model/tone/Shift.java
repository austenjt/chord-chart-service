package org.jazz.chart.model.tone;

enum Shift
{
    DoubleFlat("bb"),
    Flat("b"),
    Natural(""),
    Sharp("#"),
    DoubleSharp("##");

    private String shift;

    Shift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return this.shift;
    }
}