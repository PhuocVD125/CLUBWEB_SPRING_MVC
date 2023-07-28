package com.phuocvu.web.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type;
    private String photoUrl;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    /*
    @JoinColumn(name = "club_id", nullable = false):
    Thuộc tính name = "club_id" chỉ định rằng cột club_id trong bảng Event được sử dụng để lưu khóa chính của đối tượng Club liên quan.
    Thuộc tính nullable = false chỉ định rằng club_id không được chấp nhận giá trị null,
    nghĩa là mỗi Event phải liên kết với một Club.
    */
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;
}
