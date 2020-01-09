import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroSala;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroSala, Date checkIn, Date checkOut) {
        this.numeroSala = numeroSala;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public long duracao(){
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return  TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date checkIn, Date checkOut) throws ExcecaoDominio{
        Date hoje = new Date();
        if (checkIn.before(hoje) || checkOut.before(hoje)){
            throw new ExcecaoDominio("datas da reserva tem que ser futuras");
        }
        if (checkOut.before(checkIn)){
            throw new ExcecaoDominio("datas depois de check-in");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString(){
        return "Sala" + getNumeroSala() +
                ", check-in " + sdf.format(checkIn) +
                " check-out " + sdf.format(checkOut) +
                ", "+
                duracao() +
                " noites";

    }
}
