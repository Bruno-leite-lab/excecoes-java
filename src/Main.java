import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Numero da Sala: ");
        int numero = sc.nextInt();
        System.out.println("Check-in data (dia/Mes/ano): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out data (dia/Mes/ano): ");
        Date checkOut = sdf.parse(sc.next());

        if (checkOut.before(checkIn)){
            System.out.println("erro na reserva: Data de check-out tem que ser depois da data de check-in");

        }
        else{
            Reserva reserva = new Reserva(numero,checkIn,checkOut);
            System.out.println("Reserva: " + reserva);
        }

    }
}
