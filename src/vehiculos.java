public class vehiculos {
    private String placa, marca, tipoCombustible, color, propietario;
    private Double cilindraje;

    public vehiculos() {
    }

    public vehiculos(String placa, String marca, String tipoCombustible, String color, String propietario, Double cilindraje) {
        this.placa = placa;
        this.marca = marca;
        this.tipoCombustible = tipoCombustible;
        this.color = color;
        this.propietario = propietario;
        this.cilindraje = cilindraje;
    }
    //Getters y Setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Double cilindraje) {
        this.cilindraje = cilindraje;
    }
}
