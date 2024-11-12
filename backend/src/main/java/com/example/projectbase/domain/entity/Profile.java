package com.example.projectbase.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * The type Profile.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Nationalized
    @Column(nullable = false)
    private String name;

    @Nationalized
    @Column(nullable = false)
    private String phoneNumber;

    @Nationalized
    @Column(nullable = false)
    private String email;

    @Nationalized
    @Column(nullable = false)
    private String status;

    @Nationalized
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Nationalized
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    //Link to table User
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_PROFILE_USER"))
    private User user;

    //Link to table PDF
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    @JsonIgnore
    private Set<PDF> PDFs = new HashSet<>();
}
