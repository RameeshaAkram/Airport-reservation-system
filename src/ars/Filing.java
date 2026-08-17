package ars;

import User.Invoice;
import administrator.Administrator;
import administrator.AirHostess;
import administrator.Flights;
import administrator.Pilots;

import java.io.*;
import java.util.ArrayList;

public class Filing {
    public static void writeObjectToFile(ArrayList<Flights> flights)
    {
        String filename = "flights.txt";

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(flights);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Flights> readObjectFromFile()
    {
        String filename = "flights.txt";
        FileInputStream fis = null;
        ObjectInputStream in = null;

        ArrayList<Flights> flights = new ArrayList<>();

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            flights = (ArrayList<Flights>) in.readObject();
            in.close();
        }catch (ClassNotFoundException e) {

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return flights;

    }

    public static Boolean readObjectFromFile(Object t, String u, String p)
    {
        Boolean EndOfFile = false;
        String filename = t.getClass().getSimpleName();
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);

            Administrator temp = (Administrator) in.readObject();
            while(!EndOfFile){
                if(temp.getUsername().equalsIgnoreCase(u) && temp.getPassword().equals(p)){
                    return true;
                }
                else{
                    return false;
                }
            }
            in.close();
        }catch(EOFException e){
            EndOfFile = true;
        }
        catch (ClassNotFoundException e) {

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Invoice> readBookedFlights() {
        String filename = "bookedflights.txt";
        FileInputStream fis = null;
        ObjectInputStream in = null;

        ArrayList<Invoice> flights = new ArrayList<>();

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            flights = (ArrayList<Invoice>) in.readObject();
            in.close();
        }catch (FileNotFoundException e){
            return null;
        }
        catch (ClassNotFoundException e) {

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return flights;
    }

    public static void writeBookedFlights(ArrayList<Invoice> i) {
        String filename = "bookedflights.txt";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(i);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeToFile(Object o){
        String resource=o.getClass().getSimpleName();
        try
        {
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(resource,true));
            output.writeObject(o);
            output.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean deleteFromFileArray(Object ob, String del)
    {
        try {
            if(ob instanceof Flights) {
                ArrayList<Flights> list = readObjectFromFile();
                for (Object o : list) {
                    Flights com = (Flights) o;
                    if (com.getFlightNumber().equalsIgnoreCase(del)) {
                        list.remove(o);
                        writeObjectToFile(list);
                        return true;
                    }
                }
            }
            else if(ob instanceof Invoice){
                ArrayList<Invoice> list = readBookedFlights();
                for (Object o : list) {
                    Invoice com = (Invoice) o;
                    if (com.flightNumber.equalsIgnoreCase(del)) {
                        list.remove(o);
                        writeBookedFlights(list);
                        return true;
                    }
                }
            }
        }
        catch(ClassCastException c)
        {
            c.printStackTrace();
        }
        return false;
    }

    public static void Registration(Object o) {
        String resource = o.getClass().getSimpleName();

        if (o instanceof Administrator) {
            Administrator a = (Administrator) o;
            Filing fi = new Filing();
            int i = fi.NumberOf(a);
            if (i == 0) {
                fi.writeToFile(a);
            } else
                System.out.println("Administrator already Exists");
        }

    }
    public int NumberOf (Object o){
        int no = -1;
        String resource = o.getClass().getSimpleName();
        boolean EndOfFile = false;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                no++;
                input = new ObjectInputStream(fis);
                if (o instanceof Administrator) {
                    Administrator temp = (Administrator) input.readObject();
                }
                input.close();
            }
            } catch (EOFException i) {
                EndOfFile = true;
            } catch (FileNotFoundException e) {
                return 0;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return no;
        }
}
