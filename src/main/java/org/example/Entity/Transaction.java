package org.example.Entity;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount, int balance) {
}
