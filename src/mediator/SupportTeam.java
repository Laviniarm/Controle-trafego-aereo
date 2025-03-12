package mediator;

public class SupportTeam {
    private boolean available = true;

    public void prepareRunway() {
        if (available) {
            System.out.println("Support team is preparing the runway.");
            available = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runway is now secure.");
            available = true;
        } else {
            System.out.println("Support team is busy.");
        }
    }

    public boolean isAvailable() {
        return available;
    }
}
