package BackingBean;

import Db.DbConnection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lucky on 12/12/2019.
 */
public class Reservation {
    private int id;
    private String date;
    private int nightStay;
    private int adults;
    private int children;
    private String roomType;
    private String bedType;
    private String smoking;
    private String name;
    private String email;
    private String phone;
    private List<Integer> AdultsOptions;
    private List<Integer> childOptions;
    private String[] smokingList;
// Constructor
    public Reservation() {
        AdultsOptions = new ArrayList<Integer>();
        AdultsOptions.add(0);
        AdultsOptions.add(1);
        AdultsOptions.add(2);
        AdultsOptions.add(3);
        AdultsOptions.add(4);
        AdultsOptions.add(5);
        AdultsOptions.add(6);
        AdultsOptions.add(7);
        AdultsOptions.add(8);
        AdultsOptions.add(9);
        AdultsOptions.add(10);
        AdultsOptions.add(11);
        AdultsOptions.add(12);
        AdultsOptions.add(13);
        childOptions = new ArrayList<Integer>();
        childOptions.add(0);
        childOptions.add(1);
        childOptions.add(2);
        childOptions.add(3);
        childOptions.add(4);
        childOptions.add(5);
        childOptions.add(6);
        childOptions.add(7);
        childOptions.add(8);
        childOptions.add(9);
        childOptions.add(10);
        childOptions.add(11);
        childOptions.add(12);
        childOptions.add(13);
    }

   // Setters & Getters


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNightStay() {
        return nightStay;
    }

    public void setNightStay(int nightStay) {
        this.nightStay = nightStay;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdultsOptions(List<Integer> adultsOptions) {
        AdultsOptions = adultsOptions;
    }

    public List<Integer> getAdultsOptions() {
        return AdultsOptions;
    }

    public void setChildOptions(List<Integer> childOptions) {
        this.childOptions = childOptions;
    }

    public List<Integer> getChildOptions() {
        return childOptions;
    }

    public String[] getSmokingList() {
        return smokingList;
    }

    public void setSmokingList(String[] smokingList) {
        smoking=smokingList[0];
        this.smokingList = smokingList;
        System.out.println(smoking);
    }
}