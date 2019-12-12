package comloiane.springcloudmysql.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String sex;
    private String city;
    private String address;
    private String patient;
    private String birthdate;


  
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSex(String sex) { this.sex = sex; }
    public String getSex() { return sex; }

    public void setBirthDate(String birthdate) { this.birthdate = birthdate; }
    public String getBirthDate() { return birthdate; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return city; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }

    public void setPatient(String patient) { this.patient = patient; }
    public String getPatient() { return patient; }
}