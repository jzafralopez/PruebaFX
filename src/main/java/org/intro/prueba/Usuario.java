package org.intro.prueba;

public class Usuario {
    private String correo;
    private String soft;
    private String plataforma;
    private String admin;

    public Usuario(String correo, String plataforma, String soft, boolean admin) {
        this.correo = correo;
        this.plataforma = plataforma;
        this.soft = soft;
        this.admin = String.valueOf(admin);
    }

    public String getCorreo() {
        return correo;
    }

    public String getPlataforma() {
        return plataforma;
    }


    public String getSoft() {
        return soft;
    }

    public String getAdmin() {
        return admin;
    }
}
