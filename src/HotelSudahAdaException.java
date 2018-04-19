public class HotelSudahAdaException extends Exception {
    private Hotel hotel_error;

    public HotelSudahAdaException(Hotel hotel_input){
        super("Hotel dengan nama : ");
        hotel_error = hotel_input;
    }

    public String getPesan(){
        return super.getMessage() + hotel_error.getNama() + " sudah terdaftar.";
    }
}
