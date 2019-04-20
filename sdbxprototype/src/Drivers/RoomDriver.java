/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;
import Database.DevDatabase;
import Models.RoomModel;
import Models.RsvModel;
import java.util.List;

/**
 *
 * @author cmason12
 */
public class RoomDriver {
    
    // SDBX: expose DevDatabase rsvTbl for DEV
    public static List<RsvModel> devRtrnAllRsvs(){return DevDatabase.retrieveAllRsvs();}
    
    // SDBX: Dev Linkage Method; No RsvDriver to use
    public static void devLinkRsvAndRoom(RsvModel rsv, RoomModel rm){
        // Dev Debug info
        System.out.println("\tLinking " + rsv + " & " + rm);
        rsv.setRoom(rm);
        rm.setRsv(rsv);
    }
    
    /**
     * Core RoomDriver Methods
     * 
     * @return 
     */
    
    // return all rooms
    public static List<RoomModel> rtrnAllRooms(){
        return DevDatabase.rtrvAllRooms();
    }
    // return available rooms
    public static List<RoomModel> rtrnAvailableRooms(){
        return DevDatabase.rtrvAvailableRooms();
    }
    // return occupied rooms
    public static List<RoomModel> rtrnOccupiedRooms(){
        return DevDatabase.rtrvOccupiedRooms();
    }
    
    // flag room occupied
    public static void flagRoomAsOccupied(RoomModel rm){
        rm.setIsOccupied(true);
    }
    // flag room available
    public static void flagRoomAsAvailable(RoomModel rm){
        rm.setIsOccupied(false);
    }
    
    // search by rsv
    public static RoomModel srchRoomByRsv(RsvModel rsv){
        return DevDatabase.rtrvByRsv(rsv);
    }
    
    // assignRsvToRoom
    public static void asignRsvToRoom(RoomModel rm, RsvModel rsv){
        rm.setRsv(rsv);
    }
    // deassignRsvFromRoom
    public static void dsignRsvFromRoom(RoomModel rm){
        rm.setRsv(null);
    }
}