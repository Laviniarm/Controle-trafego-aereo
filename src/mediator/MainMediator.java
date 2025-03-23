package mediator;

public class MainMediator {

    public static void main(String[] args) {

        ATCMediator atcMediator = ATC.getInstance();

        // Componente 1
        Flight f1 = new Flight(atcMediator, "LATAM", "LA4542");
        Flight f2 = new Flight(atcMediator, "GOL", "GL1273");
        Flight f3 = new Flight(atcMediator, "AZUL", "AZ3321");

        // Componente 2
        Runway mainRunway = new Runway(atcMediator);
        Runway secondRunway = new Runway(atcMediator);

        atcMediator.registerFlight(f1);
        atcMediator.registerFlight(f2);
        atcMediator.registerFlight(f3);
        atcMediator.registerRunway(mainRunway);
        atcMediator.registerRunway(secondRunway);

        // Pouso e decolagem dos aviões
        System.out.println(">> Contato da aeronave 1....");
        f1.getReadyForLanding();
        System.out.println();

        System.out.println(">> Consultando situacao da pista....");
        mainRunway.land();
        System.out.println();

        System.out.println(">> Contato da aeronave 2....");
        f2.getReadyForTakeoff();
        System.out.println();

        System.out.println(">> Consultando situacao da pista....");
        mainRunway.takeoff();

        f1.land();

        System.out.println();
        System.out.println(">> Consultando situacao da pista....");
        mainRunway.land();
        f2.takeoff();
    }
}
