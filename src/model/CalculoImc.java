package model;


public class CalculoImc {

    private int massa;
    private double altura;
    private double imc;
    private String status = "";

    public int getMassa() {
        return massa;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {

        this.altura = altura;
    }

    public double getImc() {
        if (massa > 0 && altura > 0) {
            imc = massa / Math.pow(altura, 2);
        } else {
            imc = 0.0;
        }
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getStatus() {
        if (imc > 0) {
            if (imc <= 18.5) {
                this.status = "ABAIXO DO PESO IDEAL!";
            } else if (imc >= 18.6 && imc <= 24.9) {
                this.status = "PESO IDEAL";
            } else if (imc >= 25.0 && imc <= 29.9) {
                this.status = "LEVEMENTE ACIMA DO PESO!";
            } else if (imc >= 30.0 && imc <= 34.9) {
                this.status = "OBESIDADE GRAU 1";
            } else if (imc >= 35.0 && imc <= 39.9) {
                this.status = "OBESIDADE SEVERA";
            } else {
                this.status = "OBESIDADE MÓRBIDA";
            }
            return status;
        } else {
            this.status = "";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}