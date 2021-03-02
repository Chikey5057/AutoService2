package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientID;

    @NonNull
    @Column(name = "FirstName")
    private String firstName;

    @NonNull
    @Column(name = "LastName")
    private String lastName;

    @NonNull
    @Column(name = "Patronymic")
    private String patronymic;

    @NonNull
    @Column(name = "Birthday")
    private Date birthday;
    @NonNull
    @Column(name = "RegistrationDate")
    private Date registrationDate;
    @NonNull
    @Column(name = "Email")
    private String email;
    @NonNull
    @Column(name = "Phone")
    private String phone;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "GenderCode",nullable = false)
    private Gender gender;

    @NonNull
    @Column(name = "PhotoPath")
    private String photoPath;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    Set<ClientService> setClient;


    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
