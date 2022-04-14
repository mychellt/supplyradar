package br.com.supplyradar.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailAttachment {
    private String name;
    private String type;
    private byte[] file;
}
