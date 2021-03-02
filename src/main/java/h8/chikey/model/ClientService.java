package h8.chikey.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "clientservice")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class ClientService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientServiceID;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "ClientId",nullable = false)
    private Client client;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "ServiceId",nullable = false)
    private Service service;

    @NonNull
    @Column(name = "StartTime")
    private Date startTime;
    @Column(name = "Comment")
    private String comment;


    @Override
    public String toString() {
        return "ClientService{" +
                "clientServiceID=" + clientServiceID +
                ", client=" + client +
                ", service=" + service +
                ", startTime=" + startTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
