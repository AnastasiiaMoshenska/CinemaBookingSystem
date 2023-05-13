package com.project.cinemabookingsystem.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="SEATS")
public class Seat {
    @Id
    @GeneratedValue
    private int id;

    private int seatRow;
    private int seatNumber;
    private int hall;
    private String status;

    public Seat() {
    }

    public Seat(int seatRow, int seatNumber, int hall, String status) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.hall = hall;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id && seatRow == seat.seatRow && seatNumber == seat.seatNumber && hall == seat.hall && Objects.equals(status, seat.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatRow, seatNumber, hall, status);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                ", hall=" + hall +
                ", status='" + status + '\'' +
                '}';
    }
}
