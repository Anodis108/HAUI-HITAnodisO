package com.example.projectbase.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Pdf.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "pdfs")
public class PDF {
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
    private String url;

    @Nationalized
    @Column(nullable = false)
    private LocalDateTime createdAt;

    //Link to table Profile
    @ManyToOne
    @JoinColumn(name = "profile_id", foreignKey = @ForeignKey(name = "FK_PDF_PROFILE"))
    private Profile profile;
}
