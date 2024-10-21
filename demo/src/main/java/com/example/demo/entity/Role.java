@Entity
public class Role implements GrantedAuthority {
    @Id
    private String name;

    // Implement methods from GrantedAuthority interface

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}