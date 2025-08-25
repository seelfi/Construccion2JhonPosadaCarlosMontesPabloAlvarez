package app.domain.model;

public class Login {
    private  String username;
    private  String password;

    public Login(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío.");
        }
        if (username.length() > 15) {
            throw new IllegalArgumentException("El nombre de usuario no puede tener más de 15 caracteres.");
        }
        if (!username.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("El nombre de usuario solo debe contener letras y números.");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un número.");
        }
        if (!password.matches(".*[!@#$%^&*()_+=<>?{}\\[\\]-].*")) {
            throw new IllegalArgumentException("La contraseña debe contener al menos un carácter especial.");
        }

        this.username = username;
        this.password = password; // más adelante se debería hashear
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

