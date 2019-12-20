package ManageBean;

import BackingBean.Reservation;
import Db.DbConnection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucky on 12/12/2019.
 */


@ManagedBean
    public class ReservationBean {
public static int idEdit;

    Reservation reservation;
    DbConnection db;


    public ReservationBean() {
        reservation=new Reservation();
        db=new DbConnection();
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }



    public String addReservationRecord(){
        try {
System.out.println("Lucky");
            //  connection.insertData(this.getDate(),reservation.getNightStay(),reservation.getAdults(),reservation.getChildren(),reservation.getRoomType(),reservation.getBedType(),reservation.getSmoking(),reservation.getName(),reservation.getEmail(),reservation.getPhone());
            db.insertData(this.reservation.getDate(),this.reservation.getNightStay(),this.reservation.getAdults(),this.reservation.getChildren(),this.reservation.getRoomType(),this.reservation.getBedType(),this.reservation.getSmoking(),this.reservation.getName(),this.reservation.getEmail(),this.reservation.getPhone());

        }catch (Exception e){
            e.printStackTrace();
        }
        return "ListAllReservation";
    }



    public String updateReservation(){

int id=idEdit;
        System.out.println(id);

        db.updateRecord(id,this.reservation.getDate(),this.reservation.getNightStay(),this.reservation.getAdults(),this.reservation.getChildren(),this.reservation.getRoomType(),this.reservation.getBedType(),this.reservation.getSmoking(),this.reservation.getName(),this.reservation.getEmail(),this.reservation.getPhone());
        return "ListAllReservation";
    }


    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = new ArrayList<Reservation>();
        try {

            ResultSet rs = db.getRecords();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt(1));
                reservation.setDate(rs.getDate(2).toString());
                reservation.setNightStay(rs.getInt(3));
                reservation.setAdults(rs.getInt("Adults"));
                reservation.setChildren(rs.getInt(5));
                reservation.setRoomType(rs.getString(6));
                reservation.setBedType(rs.getString(7));
                reservation.setSmoking(rs.getString(8));
                reservation.setName(rs.getString(9));
                reservation.setEmail(rs.getString(10));
                reservation.setPhone(rs.getString(11));
               // reservation.setId(rs.getInt("id"));
                //reservation.setFirstName(rs.getString("first_name"));
               // reservation.setLastName(rs.getString("last_name"));
                //reservation.setEmail(rs.getString("email"));


                reservations.add(reservation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return reservations;
    }


    public String deleteReservation(int id){
        System.out.println(id);
        db.deleteRecord(id);
        return "ListAllReservation";
    }

    public String editReservation(int id){



        ResultSet rs = db.getRecord(id);
        try {

            while (rs.next()) {
                reservation.setId(rs.getInt(1));
                reservation.setDate(rs.getDate(2).toString());
                reservation.setNightStay(rs.getInt(3));
                reservation.setAdults(rs.getInt("Adults"));
                reservation.setChildren(rs.getInt(5));
                reservation.setRoomType(rs.getString(6));
                reservation.setBedType(rs.getString(7));
                reservation.setSmoking(rs.getString(8));
                reservation.setName(rs.getString(9));
                reservation.setEmail(rs.getString(10));
                reservation.setPhone(rs.getString(11));
                idEdit=rs.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "edit";
    }




}
