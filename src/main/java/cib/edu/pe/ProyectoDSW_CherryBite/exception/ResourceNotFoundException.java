package cib.edu.pe.ProyectoDSW_CherryBite.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }

}
