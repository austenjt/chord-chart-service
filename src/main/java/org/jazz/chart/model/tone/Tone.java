package org.jazz.chart.model.tone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Tone
{
    private Note note;
    private Shift shift;
    private int octave;
    private int duration;
}



