package edu.unito.hdmm.tasl.db;

public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(String s){
        super(s);
    }

    public DAOException(Exception e){
        super(e);
    }


}
