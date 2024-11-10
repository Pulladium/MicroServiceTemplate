package com.vozh.art.dataservice.dto;

import com.vozh.art.dataservice.entity.mongoDoc.SignedDoc;


public record DocWithFile(SignedDoc doc, byte[] file) {
}
