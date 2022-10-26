package entities;

import java.time.LocalDate;
import java.util.Date;

public class HourContract {
    private LocalDate moment;
    private Double valuePerHour;
    private Integer hours;


    public HourContract(){

    }

    public HourContract(LocalDate hora, Double valuePerHour, Integer hours) {
        this.moment = hora;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

        public LocalDate getHora() {
        return moment;
        }

    public void setHora(LocalDate hora) {
        this.moment = hora;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double totalValue(){
        return valuePerHour * hours;
    }
}
