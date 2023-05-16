package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t01.n01.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class SucursalDTO implements Serializable {

    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;

    private final ArrayList<String> paissos = paissos();
    private String tipusSucursal;

    public ArrayList<String> paissos () {
        ArrayList<String> paissos = new ArrayList<>();
        paissos.add("Alemania");
        paissos.add("Bélgica");
        paissos.add("Croacia");
        paissos.add("Dinamarca");
        paissos.add("España");
        paissos.add("Francia");
        paissos.add("Irlanda");
        paissos.add("Letonia");
        paissos.add("Luxemburgo");
        paissos.add("Países Bajos");
        paissos.add("Suecia");
        paissos.add("Bulgaria");
        paissos.add("Eslovaquia");
        paissos.add("Grecia");
        paissos.add("Malta");
        paissos.add("Polonia");
        paissos.add("República Checa");
        paissos.add("Austria");
        paissos.add("Chipre");
        paissos.add("Eslovenia");
        paissos.add("Finlandia");
        paissos.add("Hungría");
        paissos.add("Italia");
        paissos.add("Lituania");
        paissos.add("Portugal");
        paissos.add("Rumanía");
        return paissos;
    }

    public String setTipusSucursal () {
        String tipusSucursal;
        if (paissos.contains(paisSucursal)) {
            tipusSucursal= "comunitario";
        } else {
            tipusSucursal= "no comunitario";
        }
        return tipusSucursal;
    }

    public SucursalDTO() {}

    public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = setTipusSucursal();
    }

    public SucursalDTO(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = setTipusSucursal();
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

}
