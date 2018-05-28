package GeneroAPP;


/**
* GeneroAPP/GeneroPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Genero.idl
* lunes 28 de mayo de 2018 05:21:16 PM COT
*/

public abstract class GeneroPOA extends org.omg.PortableServer.Servant
 implements GeneroAPP.GeneroOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarGenero", new java.lang.Integer (0));
    _methods.put ("consultarGenero", new java.lang.Integer (1));
    _methods.put ("eliminarGenero", new java.lang.Integer (2));
    _methods.put ("actualizarGenero", new java.lang.Integer (3));
    _methods.put ("listarGenero", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // GeneroAPP/Genero/insertarGenero
       {
         int id = in.read_long ();
         String nombre = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarGenero (id, nombre);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // GeneroAPP/Genero/consultarGenero
       {
         int id = in.read_long ();
         String $result = null;
         $result = this.consultarGenero (id);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // GeneroAPP/Genero/eliminarGenero
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.eliminarGenero (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // GeneroAPP/Genero/actualizarGenero
       {
         int id = in.read_long ();
         String nombre = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarGenero (id, nombre);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // GeneroAPP/Genero/listarGenero
       {
         String $result = null;
         $result = this.listarGenero ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 5:  // GeneroAPP/Genero/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:GeneroAPP/Genero:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Genero _this() 
  {
    return GeneroHelper.narrow(
    super._this_object());
  }

  public Genero _this(org.omg.CORBA.ORB orb) 
  {
    return GeneroHelper.narrow(
    super._this_object(orb));
  }


} // class GeneroPOA