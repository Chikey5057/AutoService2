package h8.chikey.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "gender")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Gender {

    @Id
    @NonNull
    @Column(name = "Code")
    private char genderID;

    @NonNull
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "gender", fetch = FetchType.EAGER)
    Set<Client> setGender;

    @Override
    public String toString() {
        return "Gender{" +
                "genderID=" + genderID +
                ", name='" + name + '\'' +
                '}';
    }
}
