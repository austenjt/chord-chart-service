package org.jazz.chart.model.tone;

enum Note
{
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    A("A"),
    B("B");

    private String note;

    Note(String note) {
        this.note = note;
    }

    public String getNote() {
        return this.note;
    }

}