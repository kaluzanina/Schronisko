package bada_bdbt_proj;

public class UserAttributes {
    private String username;
    private String role;
    private Long id;

    public UserAttributes(String username, String role, Long id) {
        this.username = username;
        this.role = role;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }
}
