package EstadoAPP;


/**
* EstadoAPP/EstadoOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Estado.idl
* lunes 28 de mayo de 2018 08:20:08 AM COT
*/

public interface EstadoOperations 
{
  boolean insertarEstado (int id, String nombre);
  String consultarEstadoa (int id);
  boolean eliminarEstado (int id);
  boolean actualizarEstado (int id, String nombre);
  String listarEstado ();
  void shutdown ();
} // interface EstadoOperations