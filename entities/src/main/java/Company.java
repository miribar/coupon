import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue
    Long id;
    String compName;
    String password;
    String email;
    Collection<Coupon> coupons;

    public Company(Long id, String compName, String password, String email, Collection<Coupon> coupons) {
        this.id = id;
        this.compName = compName;
        this.password = password;
        this.email = email;
        this.coupons = coupons;
    }

    public Long getId() {
        return id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Collection<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", compName='" + compName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", coupons=" + coupons +
                '}';
    }
}
