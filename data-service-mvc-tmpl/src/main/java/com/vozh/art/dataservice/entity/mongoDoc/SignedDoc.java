package com.vozh.art.dataservice.entity.mongoDoc;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
@Document(collection = "signed_documents")
public class SignedDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String fileType;

    private String gridFsFileId; // ID файла в GridFS

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String ed25519PublicKey;

    private String ed25519Signature;

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fileType='" + fileType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", ed25519PublicKey='" + ed25519PublicKey + '\'' +
                ", ed25519Signature='" + ed25519Signature + '\'' +
                '}';
    }
}
