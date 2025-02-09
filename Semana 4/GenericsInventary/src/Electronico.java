class Electronico extends Producto {  
    private int garantiaMeses;  

    public Electronico(String nombre, double precio, int garantiaMeses) {  
        super(nombre, precio);  
        this.garantiaMeses = garantiaMeses;  
    }  

    @Override  
    public String toString() {  
        return super.toString() + ", Garantía: " + garantiaMeses + " meses";  
    }  
}

class Ropa extends Producto {  
    private String talla;  

    public Ropa(String nombre, double precio, String talla) {  
        super(nombre, precio);  
        this.talla = talla;  
    }  

    @Override  
    public String toString() {  
        return super.toString() + ", Talla: " + talla;  
    }  
}

class Comida extends Producto {  
    private String fechaExpiracion;  

    public Comida(String nombre, double precio, String fechaExpiracion) {  
        super(nombre, precio);  
        this.fechaExpiracion = fechaExpiracion;  
    }  

    @Override  
    public String toString() {  
        return super.toString() + ", Expira el: " + fechaExpiracion;  
    }  
}
