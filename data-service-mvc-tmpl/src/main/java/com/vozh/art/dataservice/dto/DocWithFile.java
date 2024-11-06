package com.vozh.art.dataservice.dto;

import com.vozh.art.dataservice.entity.SignedDoc;
import lombok.Getter;
import lombok.Setter;

//
//@Getter
//@Setter
public record DocWithFile(SignedDoc doc, byte[] file) {
}
