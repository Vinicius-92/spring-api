package dev.vinicissilva.springapi.exceptions;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ExceptionResponse {
  private LocalDateTime date;
  private Integer statusCode;
  private String status;
  private String error;

  public ExceptionResponse(String status, Integer statusCode, String error) {
    this.status = status;
    this.error = error;
    this.statusCode = statusCode;
    this.date = LocalDateTime.now();
  }
}
