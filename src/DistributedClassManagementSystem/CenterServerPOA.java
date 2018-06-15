package DistributedClassManagementSystem;


/**
* DistributedClassManagementSystem/CenterServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DistributedClassManagementSystem.idl
* Thursday, June 14, 2018 9:31:34 o'clock PM EDT
*/

public abstract class CenterServerPOA extends org.omg.PortableServer.Servant
 implements DistributedClassManagementSystem.CenterServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createTRecord", new java.lang.Integer (0));
    _methods.put ("createSRecord", new java.lang.Integer (1));
    _methods.put ("getRecordCount", new java.lang.Integer (2));
    _methods.put ("editRecords", new java.lang.Integer (3));
    _methods.put ("transferRecord", new java.lang.Integer (4));
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
       case 0:  // DistributedClassManagementSystem/CenterServer/createTRecord
       {
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String address = in.read_string ();
         String phone = in.read_string ();
         String specialization = in.read_string ();
         String location = in.read_string ();
         String managerId = in.read_string ();
         boolean $result = false;
         $result = this.createTRecord (firstName, lastName, address, phone, specialization, location, managerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // DistributedClassManagementSystem/CenterServer/createSRecord
       {
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String courseRegistered[] = DistributedClassManagementSystem.CoursesHelper.read (in);
         String status = in.read_string ();
         String statusDate = in.read_string ();
         String managerId = in.read_string ();
         boolean $result = false;
         $result = this.createSRecord (firstName, lastName, courseRegistered, status, statusDate, managerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // DistributedClassManagementSystem/CenterServer/getRecordCount
       {
         String managerId = in.read_string ();
         String $result = null;
         $result = this.getRecordCount (managerId);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // DistributedClassManagementSystem/CenterServer/editRecords
       {
         String recordId = in.read_string ();
         String fieldName = in.read_string ();
         String newValue = in.read_string ();
         String managerId = in.read_string ();
         boolean $result = false;
         $result = this.editRecords (recordId, fieldName, newValue, managerId);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // DistributedClassManagementSystem/CenterServer/transferRecord
       {
         String managerID = in.read_string ();
         String recordID = in.read_string ();
         String remoteCenterServerName = in.read_string ();
         boolean $result = false;
         $result = this.transferRecord (managerID, recordID, remoteCenterServerName);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // DistributedClassManagementSystem/CenterServer/shutdown
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
    "IDL:DistributedClassManagementSystem/CenterServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CenterServer _this() 
  {
    return CenterServerHelper.narrow(
    super._this_object());
  }

  public CenterServer _this(org.omg.CORBA.ORB orb) 
  {
    return CenterServerHelper.narrow(
    super._this_object(orb));
  }


} // class CenterServerPOA
