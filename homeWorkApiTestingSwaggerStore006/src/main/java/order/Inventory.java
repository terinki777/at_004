package order;

import java.util.List;
import java.util.Objects;

public class Inventory {

    private int sold;
//    private int Sold;
private List<Inventory> Sold;
    private String string;
    private int pending;
    private int available;
    private List<Inventory> not_available;
    private List<Inventory> connector;
    private List<Inventory> connector_up;
    private int Pending;
    private String status;
    private int onSaleSoon;

    public Inventory() {
    }


    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

//    public int getSold_() {
//        return Sold;
//    }
//
//    public void setSold_(int Sold) {
//        this.Sold = Sold;
//    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getPending_() {
        return Pending;
    }

    public void setPending_(int Pending) {
        this.Pending = Pending;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public List<Inventory> getNotAvailable() {
        return not_available;
    }

    public void setNotAvailable(List<Inventory> notAvailable) {
        this.not_available = not_available;
    }

    public List<Inventory> getConnectorUp() {
        return connector_up;
    }

    public void setConnectorUp(List<Inventory> connector_up) {
        this.connector_up = connector_up;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOnSaleSoon() {
        return onSaleSoon;
    }

    public void setOnSaleSoon(int onSaleSoon) {
        this.onSaleSoon = onSaleSoon;
    }

//    @Override
//    public boolean equals(Object inv) {
//        if (this == inv) return true;
//        if (inv == null || getClass() != inv.getClass()) return false;
//        Inventory inventory = (Inventory) inv;
//        return sold == inventory.sold
//                //&& Sold == inventory.Sold
//                && string == inventory.string && pending == inventory.pending
//                && available == inventory.available && notAvailable == inventory.notAvailable
//                && connectorUp == inventory.connectorUp && Pending == inventory.Pending
//                && onSaleSoon == inventory.onSaleSoon
//                && Objects.equals(string, inventory.string)
//                && Objects.equals(status, inventory.status);
//    }

    @Override
    public boolean equals(Object inv) {
        if (this == inv) return true;
        if (inv == null || getClass() != inv.getClass()) return false;
        Inventory inventory = (Inventory) inv;
        return sold == inventory.sold
                //&& Sold == inventory.Sold
                //&& string == inventory.string
                && pending == inventory.pending
                && available == inventory.available
                //&& not_available == inventory.not_available
                && connector_up == inventory.connector_up
                && Pending == inventory.Pending
                && onSaleSoon == inventory.onSaleSoon
                && Objects.equals(string, inventory.string)
                && Objects.equals(status, inventory.status);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(sold, Sold, string, pending, available, notAvailable, connectorUp, Pending, status, onSaleSoon);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(sold, string, pending, available, connector_up, Pending, status, onSaleSoon);
    }

    public List<Inventory> getConnector() {
        return connector;
    }

    public void setConnector(List<Inventory> connector) {
        this.connector = connector;
    }
}
