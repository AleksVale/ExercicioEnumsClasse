package entities;

import java.time.LocalDate;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department departamento;
    private List <HourContract> contratos;

    public Worker(){
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department departamento, List<HourContract> contratos) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departamento = departamento;
        this.contratos = contratos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Department departamento) {
        this.departamento = departamento;
    }

    public List<HourContract> getContratos() {
        return contratos;
    }

    public void setContratos(List<HourContract> contratos) {
        this.contratos = contratos;
    }

    public void addContract(HourContract contrato){
        contratos.add(contrato);
    }
    public void removeContract(HourContract contrato){
        contratos.remove(contrato);
    }
    public Double income(Integer year, Integer month){
        Double somaContratos = 0.0;
        for (HourContract cont: contratos) {
            LocalDate moment = cont.getHora();
            if(moment.getYear() == year && moment.getMonthValue() == month){
                somaContratos += cont.totalValue();
            }
        }
        Double income = baseSalary+ somaContratos;
        return income;
    }
}
