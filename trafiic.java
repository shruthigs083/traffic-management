import java.util.*;

class TrafficLight {
    enum LightColor { RED, YELLOW, GREEN }

    private LightColor color;

    public TrafficLight() {
        this.color = LightColor.RED;
    }

    public void setColor(LightColor color) {
        this.color = color;
    }

    public LightColor getColor() {
        return color;
    }

    public void displayLight() {
        System.out.println("Current Light: " + color);
    }
}

class Lane {
    private String laneName;
    private int vehicleCount;
    private boolean hasEmergencyVehicle;

    public Lane(String laneName) {
        this.laneName = laneName;
        this.vehicleCount = 0;
        this.hasEmergencyVehicle = false;
    }

    public void addVehicles(int count) {
        vehicleCount += count;
    }

    public void setEmergencyVehicle(boolean status) {
        this.hasEmergencyVehicle = status;
    }

    public boolean hasEmergency() {
        return hasEmergencyVehicle;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public String getLaneName() {
        return laneName;
    }

    public void clearVehicles() {
        vehicleCount = 0;
    }
}

class TrafficSignalController {
    private Map<String, Lane> lanes = new HashMap<>();
    private TrafficLight trafficLight = new TrafficLight();

    public TrafficSignalController() {
        lanes.put("North", new Lane("North"));
        lanes.put("South", new Lane("South"));
        lanes.put("East",  new Lane("East"));
        lanes.put("West",  new Lane("West"));
    }

    public void updateTraffic(String lane, int vehicles, boolean emergency) {
        Lane selectedLane = lanes.get(lane);
        selectedLane.addVehicles(vehicles);
        selectedLane.setEmergencyVehicle(emergency);
    }

    public void runSignalCycle() {
        Lane priorityLane = null;

        // Emergency vehicle priority
        for (Lane lane : lanes.values()) {
            if (lane.hasEmergency()) {
                priorityLane = lane;
                break;
            }
        }

        // Otherwise choose busiest lane
        if (priorityLane == null) {
            priorityLane = Collections.max(
                lanes.values(),
                Comparator.comparingInt(Lane::getVehicleCount)
            );
        }

        System.out.println("\n--------------------------------------");
        System.out.println("Green Light Given To: " + priorityLane.getLaneName());
        System.out.println("--------------------------------------");

        trafficLight.setColor(TrafficLight.LightColor.GREEN);
        trafficLight.displayLight();

        System.out.println("Vehicles Moving...");
        priorityLane.clearVehicles();

        trafficLight.setColor(TrafficLight.LightColor.YELLOW);
        System.out.println("\nYellow Light - Prepare to Stop");

        trafficLight.setColor(TrafficLight.LightColor.RED);
        System.out.println("Red Light - Lane Closed");
    }

    public void displayTrafficStatus() {
        System.out.println("\n===== Traffic Status =====");
        for (Lane lane : lanes.values()) {
            System.out.println(lane.getLaneName() + 
                " Lane -> Vehicles: " + lane.getVehicleCount() + 
                ", Emergency: " + lane.hasEmergency());
        }
    }
}

public class TrafficManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrafficSignalController controller = new TrafficSignalController();
        
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Update Traffic");
            System.out.println("2. Run Traffic Cycle");
            System.out.println("3. Show Traffic Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter lane (North/South/East/West): ");
                    String lane = sc.nextLine();

                    System.out.print("Enter number of vehicles: ");
                    int vehicles = sc.nextInt();

                    System.out.print("Is there an emergency vehicle? (true/false): ");
                    boolean emergency = sc.nextBoolean();

                    controller.updateTraffic(lane, vehicles, emergency);
                    break;

                case 2:
                    controller.runSignalCycle();
                    break;

                case 3:
                    controller.displayTrafficStatus();
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}