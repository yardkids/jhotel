package jhotel;

/**
 * Kelas ini digunakan untuk mengatur semua yang berhubung dengan kamar
 * baik itu pembuatan kamar serta penentuan status kamar
 *
 * @author Anggi Harumanto -1506673744
 * @version 2018.05.24
 */
public abstract class Room
{
    // instance variables - replace the example below with your own
    public Hotel hotel;
    private String nomor_kamar;
    public StatusKamar status_kamar;
    protected double dailyTariff;

    /**
     * Constructor for objects of class Room
     * @param hotel, nomor_kamar, customer, dailytariff, status_kamar
     */
    public Room(Hotel hotel, String nomor_kamar)
    {
        // initialise instance variables
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        this.status_kamar = StatusKamar.Vacant;
    }
    
    /**
     *  Method ini digunakan untuk mengambil nilai nama variable hotel yang ada
     *  @return hotel
     */
    public Hotel getHotel(){
        return hotel;
    }
    
    /**
     *  Method ini digunakan untuk mengambil nomor kamar yang ada
     *  @return nomor_kamar
     */
    public String getNomorKamar(){
        return nomor_kamar;
    }

    /**
     *  Method ini digunakan untuk mengambil nilai daily tariff yang ada
     * @return dailyTariff
     */
    public double getDailyTariff(){
        return dailyTariff;
    }

    /**
     *  Method ini digunakan untuk mengambil nilai status kamar saat ini, apakah booked, processed atau kosong
     *  @return status_kamar
     */
    public StatusKamar getStatusKamar(){
        return status_kamar;
    }

    /**
     *  Method ini merupakan abstract method untuk mengambil data tipe kamar
     *
     */
    
    public abstract TipeKamar getTipeKamar();
    
    /**
     *  Method ini digunakan untuk menentukan hotel
     *  @param hotel
     */
    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }
    
    /**
     *  Method ini digunakan untuk menentukan nilai nomor kamar
     *  @param nomor_kamar
     */
    public void setNomorKamar(String nomor_kamar){
        this.nomor_kamar = nomor_kamar;
    }

    /**
     *  Method ini digunakan untuk mengubah tarif yang dimasukkan
     *  @param dailytariff
     */
    public void setDailyTariff(double dailytariff){
        this.dailyTariff = dailytariff;
    }
    
    /**
     *  Method ini digunakan untuk mengubah status kamar yang ada, mungkin menjadi booked, processed atau vacant
     *  @param status_kamar
     */
    public void setStatusKamar(StatusKamar status_kamar){
        this.status_kamar = status_kamar;
    }

    /**
     * Method ini digunakan untuk menampilkan string untuk informasi seputar pada kelas Room
     *
     */
    public String toString(){
        if(DatabasePesanan.getPesananAktif(this) == null){
            return  "\nNama Hotel   : " + hotel.getNama() +
                    "\nTipe Kamar   : " + getTipeKamar() +
                    "\nHarga        : " + dailyTariff +
                    "\nStatus Kamar : " + status_kamar;
        }
        
        else{
            return  "\nNama Hotel   : " + hotel.getNama() +
                    "\nTipe Kamar   : " + getTipeKamar() +
                    "\nHarga        : " + dailyTariff +
                    "\nStatus Kamar : " + status_kamar +
                    "\nPelanggan    : " + DatabasePesanan.getPesananAktif(this).getPelanggan().getNama();
        }
    }
}