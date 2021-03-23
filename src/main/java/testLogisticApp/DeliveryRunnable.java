package testLogisticApp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import static java.lang.Thread.sleep;

@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRunnable implements Runnable {

    public DeliveryGroup deliveryGroup;

    @Override
    public synchronized void run() {
        for (PackageObject packageObject : this.deliveryGroup.sameRoute) {
            try {
                System.out.println("[Delivering for <"
                        + packageObject.getTargetLocation()
                        + "> and date <"
                        + packageObject.getDeliveryDate()
                        + "> in <"
                        + packageObject.getDistance()
                        + "> seconds]");
                sleep(packageObject.getDistance() * 10);
            } catch (InterruptedException e) {
                log.error(e);
            }

        }
        System.out.println("Delivery Group TO <"
                +this.deliveryGroup.sameRoute.get(0).getTargetLocation()
                +"> total value of delivered packages is " +this.deliveryGroup.groupValue
                +" and revenue is "
                +this.deliveryGroup.groupRevenue);
    }
}
