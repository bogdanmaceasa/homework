package testLogisticApp.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageObject {

    String targetLocation;

    int distance;

    double value;

    LocalDate deliveryDate;


}
