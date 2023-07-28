package com.phuocvu.web.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // chap nhan gia tri null, long thi khong
    private String title;
    private String photoUrl;
    private String content;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    /*
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE):
    Đây là mối quan hệ "one-to-many" được thể hiện bởi Annotation @OneToMany.
    Nó cho biết mỗi đối tượng Club có thể liên kết với nhiều đối tượng Event.
    Thuộc tính mappedBy = "club" chỉ định rằng trường "club" trong class Event là trường nào được dùng để ánh xạ quan hệ này.
    Nghĩa là trường "club" trong class Event đại diện cho đối tượng Club chính nó.
    Thuộc tính cascade = CascadeType.REMOVE chỉ định rằng khi xóa một đối tượng Club,
    tất cả các đối tượng Event liên quan đến nó cũng sẽ bị xóa.
    */
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<Event> events = new ArrayList<>();
}
