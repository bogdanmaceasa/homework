package testLogisticApp;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@ToString
public class DeliveryGroup {

    List<PackageObject> sameRoute;

    double groupValue;

    double groupRevenue;

    DeliveryGroup (List<PackageObject> sameRoute) {
        this.sameRoute = sameRoute;
        setGroupRevenue();
        setGroupValue();
    }

    public void setGroupRevenue() {
        for (PackageObject packageObject : this.sameRoute){
            this.groupRevenue += packageObject.getDistance();
        }
    }

    public void setGroupValue() {
        for (PackageObject packageObject : this.sameRoute){
            this.groupValue += packageObject.getValue();
        }
    }

}
