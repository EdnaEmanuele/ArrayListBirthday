package Models;

import static java.util.UUID.randomUUID;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Birthday {

    public static final int MAXNAME =128;
    public static final int MAXADDRESS =128;

    private String _id; //GUID global unic identifier
    private String _name; // quando nao se diz de é public ou private é automaticamente private
    private String _address;
    private Date _bday;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Birthday() {
        _id = randomUUID().toString();
        setName("");
        setAddress("");
        try {
            _bday = sdf.parse("1900-01-01");
        }
        catch (ParseException ex) {

        }
    }

    public Birthday(String name, String address, String bday) {
        _id = randomUUID().toString();
        setName(name);
        setAddress(address);
        setBday(bday);
    }

    //o ID nao tera setter
    public String getId() {return _id;}

    public void setName(String nome) {
        _name = nome;
        if (_name.length() == 0) _name = "to define";
        if (nome.length() > MAXNAME) _name = _name.substring(0, MAXNAME-1);
    }
    public String getNome() {return _name;}

    public void setAddress(String morada) {
        _address = morada;
        if (_address.length() == 0) _address = "to define";
        if (morada.length() > MAXADDRESS) _address = _address.substring(0, MAXADDRESS-1);
    }
    public String getMorada() {return _address;}

    public void setBday(String dtNascimento) {
        try {
            _bday = sdf.parse(dtNascimento);
        }
        catch (Exception ex){
            _bday = new Date("1900-01-01");
        }
    }
    public String getBday() {return _bday.toString();}

    public String toString() {
        return getNome() + " " + sdf.format(_bday); }


}
