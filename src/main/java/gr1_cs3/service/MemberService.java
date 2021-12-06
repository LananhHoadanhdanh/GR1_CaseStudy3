package gr1_cs3.service;

import gr1_cs3.model.Member;

public interface MemberService extends GeneralService<Member>{

    public String getPassByUser(String username);

    boolean checkAdmin(String username, String password);

    boolean checkLogin(String username, String password);
<<<<<<< HEAD

    String getPassByUser(String username);
=======
<<<<<<< HEAD

    String getPassByUser(String username);
=======
>>>>>>> 7061a5d8b365618c9e0cd8c293c6c8eca3b8af5e
>>>>>>> duy
}
