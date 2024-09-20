package de.rinderle.dhbw.wwi23b3.kiss;

import java.time.format.DateTimeFormatter;

interface FormatterFactory {
    DateTimeFormatter createFormatter();
}