package gr1_cs3.service;

import gr1_cs3.model.Member;

public interface MemberService extends GeneralService<Member>{

    public String getPassByUser(String username);

    boolean checkAdmin(String username, String password);

    boolean checkLogin(String username, String password);

}
